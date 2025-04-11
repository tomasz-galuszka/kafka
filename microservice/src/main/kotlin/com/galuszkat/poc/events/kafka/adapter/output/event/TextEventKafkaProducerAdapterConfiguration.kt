package com.galuszkat.poc.events.kafka.adapter.output.event

import com.galuszkat.poc.events.kafka.domain.TextData
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
internal class TextEventKafkaProducerAdapterConfiguration {

    @Bean
    fun textDataKafkaTemplate(): KafkaTemplate<String, TextData> =
        KafkaTemplate(textDataKafkaProducerFactory())

    @Bean
    fun textDataKafkaProducerFactory(): ProducerFactory<String, TextData> =
        DefaultKafkaProducerFactory(mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        ))
}