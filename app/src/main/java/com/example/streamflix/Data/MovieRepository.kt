package com.example.streamflix.Data

import com.example.streamflix.Model.CarouselData
import com.example.streamflix.Model.CarouselType
import com.example.streamflix.Model.VideoItem


object MovieRepository {
    // Using Big Buck Bunny / Sintel (Open Source)
    private const val VIDEO_URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    private const val IMG_URL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"

    fun getHomeData(): List<CarouselData> {
        val videos = List(10) {
            VideoItem(it, "Movie $it", "Description", IMG_URL, VIDEO_URL)
        }

        return listOf(
            CarouselData("Featured", CarouselType.HERO, videos.take(1)),
            CarouselData("Trending Now", CarouselType.POSTER, videos),
            CarouselData("Continue Watching", CarouselType.LANDSCAPE, videos),
            CarouselData("Top Cast", CarouselType.CIRCLE, videos)
        )
    }
}