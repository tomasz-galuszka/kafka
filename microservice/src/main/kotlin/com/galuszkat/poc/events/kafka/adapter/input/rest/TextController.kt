package com.galuszkat.poc.events.kafka.adapter.input.rest

import com.galuszkat.poc.events.kafka.adapter.output.event.TextEventPublisher
import com.galuszkat.poc.events.kafka.domain.TextData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.Clock

@RestController
internal class TextController(
    private val clock: Clock,
    private val publisher: TextEventPublisher
) {

    @PostMapping("/text")
    suspend fun handle(@RequestBody request: TextRequest) {
        publisher.publish(TextData(request.text, clock.instant()))
    }
}