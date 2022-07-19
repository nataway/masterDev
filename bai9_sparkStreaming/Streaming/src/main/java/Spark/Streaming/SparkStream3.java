package Spark.Streaming;

import Genprotos.DataTracking;
import com.google.protobuf.Parser;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.internal.config.R;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import serializers.KafkaDeserializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.apache.spark.sql.functions.*;

public class SparkStream3 {

    private static final Map<String, Object> KAFKA_CONSUMER_PROPERTIES;

    static {
        Map<String, Object> kafkaProperties = new HashMap<>();
        kafkaProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.193.104:9092");
        kafkaProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        kafkaProperties.put("schema.registry.url", "http://192.168.193.104:8081");

        kafkaProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        KAFKA_CONSUMER_PROPERTIES = Collections.unmodifiableMap(kafkaProperties);
    }

    public static void main(String[] args) throws TimeoutException {

        StructType schema = new StructType()
                                .add("version", DataTypes.StringType)
                                .add("name",DataTypes.StringType)
                                .add("timestamp", DataTypes.LongType)
                                .add("phone_id", DataTypes.StringType)
                                .add("lon", DataTypes.LongType)
                                .add("lat", DataTypes.LongType);
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Kafka Integration using Structured Streaming")
                .master("local")
                .getOrCreate();
        spark.sparkContext().setLogLevel("ERROR");
//        UserDefinedFunction strLen = udf(
//                ( byte[] x) -> new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getVersion() +","+
//                        new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getName() +","+
//                        new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getTimestamp()+","+
//                        new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getPhoneId()+","+
//                        new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getLat() +","+
//                        new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).getLon(),
//                                DataTypes.StringType);
        UserDefinedFunction strLen = udf(
                ( byte[] x) -> new KafkaDeserializer<>(DataTracking.parser()).deserialize("chibm_test2",x).toString1(),
                DataTypes.StringType);
        spark.udf().register("strLen", strLen);
        Dataset<Row> df = spark
                .read()
                .format("kafka")
                .option("kafka.bootstrap.servers", "192.168.193.104:9092")
                .option("subscribe", "chibm_test2")
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
                        col("offset"));

//        Dataset<Row> DF = df;

        df.printSchema();
//        DF.printSchema();
        df.show();
//        Dataset<Row> DT = df.select(df.col("value").)
//        df.repartition(1).write().mode("append")
//                .format("parquet")
//                .save("chibm");
//        df.writeStream()
//                .outputMode("append")
//                .format("parquet")
//                .option("compression","snappy")
//                .option("checkpointLocation", "checkpoint") ///Users/laquocanh/IdeaProjects/sparkstreaming/checkpoint hdfs://172.17.80.21:9000/anhlq36/sparkss/checkpoint/
//                .option("path", "chibm") ///Users/laquocanh/IdeaProjects/sparkstreaming/output1 hdfs://172.17.80.21:9000/anhlq36/sparkss/output/"
//                .partitionBy("year", "month","day", "hour")
//                .start();
//
    }
}
