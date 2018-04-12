package pl.dmcs.weatherapp.classes

import pl.dmcs.weatherapp.interfaces.HTTPConnector

class JSONConnector(private val city: String?) {
    fun getJson(connector: HTTPConnector) = connector.getJson(connector.getUrl(city))
}