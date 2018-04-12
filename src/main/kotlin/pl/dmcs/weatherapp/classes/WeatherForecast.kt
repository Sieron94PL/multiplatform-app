package pl.dmcs.weatherapp.classes

import pl.dmcs.weatherapp.interfaces.WeatherForecastHandler


class WeatherForecast(private val json: String?) {
    fun getForecastWeather(forecastWeather: WeatherForecastHandler) =  forecastWeather.getForecastWeather(json)
}

