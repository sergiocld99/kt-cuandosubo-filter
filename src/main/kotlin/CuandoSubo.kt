import arrivals.ArrivalsRow
import org.jsoup.Jsoup

class CuandoSubo {
    private val url = "https://cuandosubo.sube.gob.ar/onebusaway-webapp/where/iphone/stop.action?id=82_6274109245"

    fun run() {
        val doc = Jsoup.connect(url).get()
        val address = doc.selectFirst(".arrivalsStopAddress")?.text()
        val rows = doc.select(".arrivalsRow")

        println("Address is $address")

        for (r in rows){
            val a = ArrivalsRow.from(r)
            println(a)
        }
    }
}