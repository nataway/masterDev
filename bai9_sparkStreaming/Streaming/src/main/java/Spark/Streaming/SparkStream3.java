package Spark.Streaming;

import Genprotos.DataTracking;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.Trigger;
import org.apache.spark.sql.types.DataTypes;
import serializers.KafkaDeserializer;

//import org.apache.spark.sql.connector.read.streaming.SupportsTriggerAvailableNow;

import java.util.concurrent.TimeoutException;

import static org.apache.spark.sql.functions.*;

public class SparkStream3 {

    public static void main(String[] args) throws StreamingQueryException, TimeoutException {

        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Kafka Integration using Structured Streaming")
                .master("local")
                .getOrCreate();

        UserDefinedFunction strLen = udf(
                ( byte[] x) -> new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test",x).toString1(),
                DataTypes.StringType);
        spark.udf().register("strLen", strLen);
        Dataset<Row> df = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "172.17.80.21:9092")
                .option("subscribe", "chibm_test")
                .load()
                .selectExpr("CAST(key as string)","strLen(value) as value", "CAST(topic as STRING)",
                        "CAST(offset as long)", "CAST(partition as long)",
                        "YEAR(timestamp) as year", "MONTH(timestamp) as month", "DAY(timestamp) as day",
                        "HOUR(timestamp) as hour")
                .select(col("key"),
                        split(col("value"),",").getItem(0).as("version"),
                        split(col("value"),",").getItem(1).as("Name"),
                        split(col("value"),",").getItem(2).as("TimeStamp"),
                        split(col("value"),",").getItem(3).as("Phone_Id"),
                        split(col("value"),",").getItem(4).as("Lon"),
                        split(col("value"),",").getItem(5).as("lat"),
                        col("topic"),
                        col("partition"),
                        col("year"),
                        col("month"),
                        col("day"),
                        col("hour"));

//        Dataset<Row> DF = df;

        //.printSchema();
        df.writeStream()
                .option("partition",1)
                .outputMode("append")
                .format("parquet")
                .option("compression","snappy")
                .option("checkpointLocation", "checkpoint")
                .option("path", "chibm")
                .partitionBy("year", "month","day", "hour")
                .start();

        spark.streams().awaitAnyTermination();
    }
}
