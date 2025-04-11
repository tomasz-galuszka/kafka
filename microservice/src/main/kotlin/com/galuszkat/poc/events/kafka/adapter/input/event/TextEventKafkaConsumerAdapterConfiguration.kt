package com.galuszkat.poc.events.kafka.adapter.input.event

import com.galuszkat.poc.events.kafka.domain.TextData
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
internal class TextEventKafkaConsumerAdapterConfiguration {

    @Bean
    fun textEventConsumerFactory(): ConsumerFactory<String, TextData> =
        DefaultKafkaConsumerFactory<String, TextData>(
            mapOf(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
                ConsumerConfig.GROUP_ID_CONFIG to CONSMER_GROUP_ID,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to TextData::class.java,
            ),
            StringDeserializer(),
            JsonDeserializer(TextData::class.java))

    @Bean
    fun textEventKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, TextData> =
        ConcurrentKafkaListenerContainerFactory<String, TextData>()
            .apply {
                this.consumerFactory = textEventConsumerFactory()
            }

    companion object {
        const val CONSMER_GROUP_ID = "test-kafka-loop-consumer-group"
    }
}