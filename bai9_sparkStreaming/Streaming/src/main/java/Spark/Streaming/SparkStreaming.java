package Spark.Streaming;

import Genprotos.DataTracking;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.apache.spark.streaming.kafka010.OffsetRange;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SparkStreaming {

    private static final Map<String, Object> KAFKA_CONSUMER_PROPERTIES;
    private static final String KAFKA_TOPIC = "chibm_test";
    private static final OffsetRange[] offsetRanges =
            // topic, partition, inclusive starting offset, exclusive ending offset
            { OffsetRange.create(KAFKA_TOPIC, 0, 0, 100) };


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

    public static void main(String[] args) {
        final SparkConf spark = new SparkConf()
                .setMaster("local")
                .setAppName("spark");
//        Dataset<Row> df = spark
//                .read()
//                .format("kafka")
//                .option("kafka.bootstrap.servers", "192.168.193.104:9092")
//                .option("subscribe", "chibm_test")
//                .load();
        JavaSparkContext sparkContext = new JavaSparkContext(spark);
        JavaRDD<ConsumerRecord<String, DataTracking>> rdd =
                KafkaUtils.createRDD(sparkContext, KAFKA_CONSUMER_PROPERTIES,
                        offsetRanges, LocationStrategies.PreferConsistent());
//        System.out.println(rdd.toString());


//        df.printSchema();
//        Dataset<String> DF = df
//                .as(STRING())
//                .flatMap((FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), STRING());
//        Dataset<Row> DF = df.selectExpr("CAST(value AS STRING)");
//        DF.show(5);
//        df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
//                .write()
//                .mode("overwrite")
//                .format("parquet")
//                .save("chibm");


    }
}
