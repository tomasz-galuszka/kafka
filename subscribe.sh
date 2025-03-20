#!/bin/bash

KAFKA_MANAGE_BIN_DIR=/opt/kafka/bin

KAFKA_RUNTIME_HOST=localhost
KAFKA_RUNTIME_PORT=9092

TEST_TOPIC=testowy-topic

DOCKER_CONTAINER_ID=kafka-testowa

echo "Reading messages from ${TEST_TOPIC}:"

docker exec -it ${DOCKER_CONTAINER_ID} ${KAFKA_MANAGE_BIN_DIR}/kafka-console-consumer.sh --topic ${TEST_TOPIC} --bootstrap-server ${KAFKA_RUNTIME_HOST}:${KAFKA_RUNTIME_PORT} --from-beginning