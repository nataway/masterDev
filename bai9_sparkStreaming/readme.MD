Tao folders proto ( file DataTrackingProto.proto voi noi dung da cho, DataTracking.sh)

Ta run file DataTracking.sh, gen ra file java : class DataTracking.java, DataTrackingPro, inteface DataTrackingOrBuilder, 

Class ProducerKafkaProto gui 1 mess/s len topic:data_tracking_chibm tren kafka

Class ReadkafkaProto de consume du lieu tu kafka

Class SparkStream3 lay du lieu kafka day len HDFS. partition by year, month, day, hour.

folder serializers chua KafkaDeserializer: giai ma mess khi nhan dc tu kafka, KafkaSerializer : ma hoa tap tin trc khi gui len kafka


Producer sinh dữ liệu đẩy lên kafka topic data_tracking_chibm trên server 172.17.80.23
```bash
hdfs://172.17.80.21:9000/user/chibm/checkpoint
hdfs://172.17.80.21:9000/user/chibm/data_tracking
```

Câu lệnh spark-submit: trên server 172.17.80.21 trong folder /home/hadoop/chibm/Kafspark
```bash
chay file spark-kafka.sh
```
hoac chay cau lenh 
```bash
spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.4.0,com.google.protobuf:protobuf-java:3.15.8 --deploy-mode cluster --class Spark.Streaming.SparkStream3 streaming-1.0-SNAPSHOT.jar
```

> HIVE : server 21 user hadoop

tao bang tren hive voi database  chibm:
```
CREATE TABLE IF NOT EXISTS chibm.data_tracking_2022_22 (key STRING, version STRING, Name STRING, year STRING, month STRING, day STRING, hour STRING, PhoneID STRING, Lon STRING, lat STRING, `topic` STRING, `partition` INTEGER, `offset` BIGINT ) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS PARQUET LOCATION "/user/chibm/data_tracking/year=2022/month=07/day=22/hour=21";
```
>query ở trên table vừa tạo
```
hive> SELECT * FROM chibm.data_tracking_2022_22;
```
![alt text](https://drive.google.com/drive/u/0/my-drive)

