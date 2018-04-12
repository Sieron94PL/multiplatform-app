package pl.dmcs.weatherapp.interfaces

import pl.dmcs.weatherapp.model.ForecastWeather

interface WeatherForecastHandler {
    fun getForecastWeather(json: String?): ForecastWeather?
}