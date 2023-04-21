import arrivals.ArrivalsRow
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class CuandoSubo {
    private val url = "https://cuandosubo.sube.gob.ar/onebusaway-webapp/where/iphone/stop.action?id=82_6274109245"
    private val doc = Jsoup.connect(url).get()

    fun raw() : Element? = doc.body()
    fun getAddress() : String? = doc.selectFirst(".arrivalsStopAddress")?.text()
    fun getLine() : String? = doc.selectFirst(".arrivalsRouteEntry")?.child(0)?.text()

    fun getArrivals() : List<ArrivalsRow> {
        val res = mutableListOf<ArrivalsRow>()
        val rows = doc.select(".arrivalsRow")

        for (r in rows){
            res.add(ArrivalsRow.from(r))
        }

        return res
    }
}