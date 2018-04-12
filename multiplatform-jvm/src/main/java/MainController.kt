import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextInputControl
import pl.dmcs.weatherapp.classes.JSONConnector
import pl.dmcs.weatherapp.classes.WeatherForecast
import pl.dmcs.weatherapp.interfaces.HTTPConnector
import pl.dmcs.weatherapp.model.ForecastWeather
import java.net.URL
import java.util.*

class MainController : Initializable {

    @FXML
    lateinit var searchBtn: Button

    @FXML
    lateinit var cityNameLabel: Label
    @FXML
    lateinit var desc1: Label

    @FXML
    lateinit var temp1: Label
    @FXML
    lateinit var pressure1: Label

    @FXML
    lateinit var date2: Label
    @FXML
    lateinit var desc2: Label
    @FXML
    lateinit var temp2: Label
    @FXML
    lateinit var pressure2: Label

    @FXML
    lateinit var date3: Label
    @FXML
    lateinit var desc3: Label
    @FXML
    lateinit var temp3: Label
    @FXML
    lateinit var pressure3: Label

    @FXML
    lateinit var date4: Label
    @FXML
    lateinit var desc4: Label
    @FXML
    lateinit var temp4: Label
    @FXML
    lateinit var pressure4: Label

    @FXML
    lateinit var date5: Label
    @FXML
    lateinit var desc5: Label
    @FXML
    lateinit var temp5: Label
    @FXML
    lateinit var pressure5: Label

    @FXML
    lateinit var searchCityInput: TextInputControl


    fun searchCity() {

        val cityName = searchCityInput.text
        val json: String? = JSONConnector(cityName).getJson(HTTPConnectorImpl())

        if (json != null) {
            val forecastWeather: ForecastWeather? = WeatherForecast(json).getForecastWeather(WeatherForecastImpl());
            val list = WeatherForecastImpl().getForecastWeatherFourDay(forecastWeather)
            cityNameLabel.text = cityName
            desc1.text = forecastWeather!!.list.get(0).weather.get(0).main
            temp1.text = forecastWeather!!.list.get(0).main.temp.toString()
            pressure1.text = forecastWeather!!.list.get(0).main.pressure.toString()


            date2.text = list.get(1).dt_txt
            desc2.text = list.get(1).weather.get(0).main
            temp2.text = list.get(1).main.temp.toString()
            pressure2.text = list.get(1).main.pressure.toString()

            date3.text = list.get(2).dt_txt
            desc3.text = list.get(2).weather.get(0).main
            temp3.text = list.get(2).main.temp.toString()
            pressure3.text = list.get(2).main.pressure.toString()


            date4.text = list.get(3).dt_txt
            desc4.text = list.get(3).weather.get(0).main
            temp4.text = list.get(3).main.temp.toString()
            pressure4.text = list.get(3).main.pressure.toString()

            date5.text = list.get(4).dt_txt
            desc5.text = list.get(4).weather.get(0).main
            temp5.text = list.get(4).main.temp.toString()
            pressure5.text = list.get(4).main.pressure.toString()
        }
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
    }
}