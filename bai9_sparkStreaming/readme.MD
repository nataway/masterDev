Tao folders proto ( file DataTrackingProto.proto voi noi dung da cho, DataTracking.sh)

Ta run file DataTracking.sh, gen ra file java : class DataTracking.java, DataTrackingPro, inteface DataTrackingOrBuilder, 

Class ProducerKafkaProto gui 1 mess/s len topic:data_tracking_chibm tren kafka

Class ReadkafkaProto de consume du lieu tu kafka

Class SparkStream3 lay du lieu kafka day len HDFS. partition by year, month, day, hour.

folder serializers chua KafkaDeserializer: giai ma mess khi nhan dc tu kafka, KafkaSerializer : ma hoa tap tin trc khi gui len kafka
