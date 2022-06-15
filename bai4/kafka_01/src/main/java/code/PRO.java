package code;

import com.opencsv.CSVWriter;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import model.Customer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.LongSerializer;



import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.IntStream;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

public class CONSUM {
    private static Path currentRelativePath = Paths.get("");
    private static String PATHSAVECSV = currentRelativePath.toAbsolutePath().toString()+"/src/main/java/out/customer.csv";
    private static String PATHSAVEBTREE = currentRelativePath.toAbsolutePath().toString()+"/src/main/java/code/BTree/saveTree/save.txt";
    private final static String TOPIC = "new-employees";

    public static void main(String... args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "AvroProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        KafkaProducer<String, Customer> producer = new KafkaProducer<String, Customer>(props);

        Customer customer = 
        ProducerRecord<String, Customer> producerRecord = new ProducerRecord<>(TOPIC, customer);
    }

}
