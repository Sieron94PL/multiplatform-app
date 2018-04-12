package pl.dmcs.weatherapp.interfaces

import pl.dmcs.weatherapp.model.ForecastWeather

interface HTTPConnector {
    fun getUrl(city: String?): String?
    fun getJson(url: String?): String?

}