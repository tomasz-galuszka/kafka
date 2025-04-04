package com.galuszkat.poc.events.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaEventsPocApplication {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KafkaEventsPocApplication>(*args)
        }
    }
}


