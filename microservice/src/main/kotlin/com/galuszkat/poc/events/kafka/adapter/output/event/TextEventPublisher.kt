package com.galuszkat.poc.events.kafka.adapter.output.event

import com.galuszkat.poc.events.kafka.domain.TextData
import com.galuszkat.poc.events.kafka.util.logger
import kotlinx.coroutines.future.await
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
internal class TextEventPublisher(
    private val textDataKafkaTemplate: KafkaTemplate<String, TextData>
) {

    suspend fun publish(event: TextData) {
        textDataKafkaTemplate.send(TOPIC_NAME, event).await()
        log.info("Published event: $event")
    }

    companion object {
        private const val TOPIC_NAME = "testowy-topic"
        private val log by logger()
    }
}