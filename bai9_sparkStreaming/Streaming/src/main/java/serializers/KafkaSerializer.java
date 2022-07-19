package serializers;

import com.google.protobuf.Message;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;

/**
 * Serializer for Kafka to serialize Protocol Buffers messages
 *
 * @param <T> Protobuf message type
 */
public class KafkaSerializer<T extends Message> extends KafkaProtobufSerializer<T> {
    @Override
    public byte[] serialize(String topic, T record) {
        return record.toByteArray();
    }


}