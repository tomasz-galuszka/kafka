package com.galuszkat.poc.events.kafka.domain

import java.time.Instant

data class TextData(
    val text: String,
    val modified: Instant
)
