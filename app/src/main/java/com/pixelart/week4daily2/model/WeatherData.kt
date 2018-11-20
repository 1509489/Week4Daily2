package com.pixelart.week4daily2.model

data class WeatherData(val cod: String, val message: Double, val cnt: Int, val list: List<WeatherList>, val city: City)