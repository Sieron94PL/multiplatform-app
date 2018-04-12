import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import pl.dmcs.weatherapp.interfaces.WeatherForecastHandler
import pl.dmcs.weatherapp.model.ForecastWeather


class WeatherForecastImpl : WeatherForecastHandler {

    override fun getForecastWeather(json: String?): ForecastWeather? {
        val mapper = jacksonObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val forecastWeather = mapper.readValue<ForecastWeather>(json.toString())
        return forecastWeather
    }

    fun getForecastWeatherFourDay(forecastWeather: ForecastWeather?): ArrayList<pl.dmcs.weatherapp.model.List> {
        val list: ArrayList<pl.dmcs.weatherapp.model.List> = ArrayList()
        for (i in forecastWeather!!.list) {
            if (i.dt_txt.contains("12:00:00")) {
                list.add(i)
            }
        }
        return list
    }
}