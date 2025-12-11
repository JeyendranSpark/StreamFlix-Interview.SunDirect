package com.example.streamflix.Model

data class CarouselData(
    val title: String,
    val type: CarouselType,
    val items: List<VideoItem>
)