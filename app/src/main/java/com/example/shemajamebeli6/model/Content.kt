package com.example.shemajamebeli6.model


import com.squareup.moshi.Json

data class Content(
    @Json(name = "content")
    val content: List<ContentItem>
)