docker exec -it kafka2_broker_1 bin/sh &&
kafka-console-consumer.sh --bootstrap-server broker:9092 -topic student -from-beginning