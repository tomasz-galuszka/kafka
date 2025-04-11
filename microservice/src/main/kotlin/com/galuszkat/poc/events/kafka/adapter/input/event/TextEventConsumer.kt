package com.galuszkat.poc.events.kafka.adapter.input.event

import com.galuszkat.poc.events.kafka.adapter.input.event.TextEventKafkaConsumerAdapterConfiguration.Companion.CONSMER_GROUP_ID
import com.galuszkat.poc.events.kafka.domain.TextData
import com.galuszkat.poc.events.kafka.util.logger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
internal class TextEventConsumer {

    @KafkaListener(
        topics = [TOPIC_NAME],
        groupId = CONSMER_GROUP_ID,
        containerFactory = "textEventKafkaListenerContainerFactory"
    )
    fun consume(text: TextData) {
        log.info("$TOPIC_NAME received event: $text")
    }

    companion object {
        private const val TOPIC_NAME = "testowy-topic"
        private val log by logger()
    }
}