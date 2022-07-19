package serializers;

import Genprotos.DataTracking;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

import com.google.protobuf.Parser;
//import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;

/**
 * Deserializer for Kafka to deserialize Protocol Buffers messages
 *
 * @param <T> Protobuf message type
 */
public class KafkaDeserializer<T extends Message> extends KafkaProtobufDeserializer<T> {
    private final Parser<T> parser;

    public KafkaDeserializer(Parser<T> parser) {
        this.parser = parser;
    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        try {
            return parser.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}