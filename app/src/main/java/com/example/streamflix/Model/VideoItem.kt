package com.example.streamflix.Model

import java.io.Serializable

data class VideoItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val videoUrl: String
) : Serializable