#!/bin/bash

KAFKA_MANAGE_BIN_DIR=/opt/kafka/bin

KAFKA_RUNTIME_HOST=localhost
KAFKA_RUNTIME_PORT=9092

TEST_TOPIC=testowy-topic

DOCKER_CONTAINER_ID=kafka-testowa

echo "Creating topic:"
docker exec -it ${DOCKER_CONTAINER_ID} ${KAFKA_MANAGE_BIN_DIR}/kafka-topics.sh --create --topic ${TEST_TOPIC} --bootstrap-server ${KAFKA_RUNTIME_HOST}:${KAFKA_RUNTIME_PORT}

echo "Created topic details:"
docker exec -it ${DOCKER_CONTAINER_ID} ${KAFKA_MANAGE_BIN_DIR}/kafka-topics.sh --describe --topic ${TEST_TOPIC} --bootstrap-server ${KAFKA_RUNTIME_HOST}:${KAFKA_RUNTIME_PORT}

echo "All topics:"
docker exec -it ${DOCKER_CONTAINER_ID} ${KAFKA_MANAGE_BIN_DIR}/kafka-topics.sh --list --bootstrap-server ${KAFKA_RUNTIME_HOST}:${KAFKA_RUNTIME_PORT}


