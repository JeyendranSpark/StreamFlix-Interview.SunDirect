package com.example.streamflix.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.streamflix.Data.MovieRepository
import com.example.streamflix.Model.CarouselData

class HomeViewModel : ViewModel() {
    fun getHomeContent(): List<CarouselData> = MovieRepository.getHomeData()
}