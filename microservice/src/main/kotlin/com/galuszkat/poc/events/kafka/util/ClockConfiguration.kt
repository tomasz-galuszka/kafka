package com.galuszkat.poc.events.kafka.util

import java.time.Clock
import java.time.Clock.systemUTC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class ClockConfiguration {

    @Bean
    fun clock(): Clock {
        return systemUTC()
    }
}