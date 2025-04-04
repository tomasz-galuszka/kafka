package com.galuszkat.poc.events.kafka.adapter

import com.galuszkat.poc.events.kafka.adapter.publisher.TextEventPublisher
import com.galuszkat.poc.events.kafka.domain.TextData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
internal class TextController(
    private val publisher: TextEventPublisher
) {

    @PostMapping("/text")
    suspend fun handle(@RequestBody textData: TextData) {
        publisher.publish(textData)
    }
}