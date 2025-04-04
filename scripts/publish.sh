#!/bin/bash

KAFKA_MANAGE_BIN_DIR=/opt/kafka/bin

KAFKA_RUNTIME_HOST=localhost
KAFKA_RUNTIME_PORT=9092

TEST_TOPIC=testowy-topic

DOCKER_CONTAINER_ID=kafka-testowa


TESTOWY_EVENT="To jest testowy event ${RANDOM}"
echo "Publishing to topic ${TEST_TOPIC} message: ${TESTOWY_EVENT}"

# docker exec -it ${DOCKER_CONTAINER_ID} cat ${KAFKA_MANAGE_BIN_DIR}/kafka-console-producer.sh

docker exec -it ${DOCKER_CONTAINER_ID} bash -c "echo '${TESTOWY_EVENT}' | ${KAFKA_MANAGE_BIN_DIR}/kafka-console-producer.sh --topic ${TEST_TOPIC} --bootstrap-server ${KAFKA_RUNTIME_HOST}:${KAFKA_RUNTIME_PORT}"