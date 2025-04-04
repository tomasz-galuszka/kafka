package com.galuszkat.poc.events.kafka.adapter.publisher

import com.galuszkat.poc.events.kafka.domain.TextData
import com.galuszkat.poc.events.kafka.util.logger
import kotlinx.coroutines.future.await
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
internal class TextEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    suspend fun publish(event: TextData) {
        kafkaTemplate.send(TOPIC_NAME, event.text).await()
        log.info("Published event: $event")
    }

    companion object {
        private const val TOPIC_NAME = "testowy-topic"
        private val log by logger()
    }
}