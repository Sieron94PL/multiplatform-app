import pl.dmcs.weatherapp.interfaces.HTTPConnector
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL

class HTTPConnectorImpl : HTTPConnector {

    override fun getUrl(city: String?): String {
        return "http://api.openweathermap.org/data/2.5/forecast?q=$city&units=metric&appid=f126704c249658d3d210e76930bccc2e"
    }

    override fun getJson(url: String?): String? {
        try {
            val url = URL(url)
            val conn = url.openConnection()

            val reader = BufferedReader(InputStreamReader(conn.getInputStream()) as Reader?)

            val json = StringBuffer(1024)
            var tmp = reader.readLine()


            while (tmp != null) {
                json.append(tmp).append("\n")
                tmp = reader.readLine()
            }

            return json.toString()
        } catch (e: Exception) {
            return null

        }
    }
}