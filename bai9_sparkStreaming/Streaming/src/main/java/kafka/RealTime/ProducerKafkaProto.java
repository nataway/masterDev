package kafka.RealTime;



import Genprotos.DataTracking;
import com.github.javafaker.Faker;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerKafkaProto {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String topicName = "chibm_test2";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.193.104:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "serializers.KafkaSerializer");
        props.put("schema.registry.url", "http://192.168.193.104:8081");
        Faker faker = new Faker();
        Producer<String, DataTracking> producer = new KafkaProducer<String, DataTracking>(props);

        String key = "testkey";
        ProducerRecord<String, DataTracking> record
                = new ProducerRecord<String, DataTracking>(topicName, key, getDataTracking(faker));
        producer.send(record);
        producer.close();

//        while (true){
//            ProducerRecord<String, DataTracking> record
//                    = new ProducerRecord<String, DataTracking>(topicName, key, getDataTracking(faker));
//            producer.send(record);
//        }

    }

    public static DataTracking getDataTracking(Faker faker){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String fullName = faker.name().fullName();
        String phoneId = String.valueOf(faker.phoneNumber().phoneNumber());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long TS = Long.parseLong(sdf1.format(timestamp));

        DataTracking DT = DataTracking.newBuilder()
                .setVersion("12")
                .setName(fullName)
                .setTimestamp(TS)
                .setPhoneId(phoneId)
                .setLon(123456)
                .setLat(123456).build();
        return DT;
    }
}
