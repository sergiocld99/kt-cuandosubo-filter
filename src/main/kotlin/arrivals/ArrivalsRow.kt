package arrivals

import org.jsoup.nodes.Element

class ArrivalsRow(val destination: String, val status: String) {

    companion object {

        fun from(element: Element) : ArrivalsRow {
            val d = element.selectFirst(".arrivalsDestinationEntry")?.child(0)?.text()
            val s = element.selectFirst(".arrivalsStatusEntry")?.text()

            return ArrivalsRow(d ?: "", s ?: "")
        }
    }

    override fun toString(): String {
        return "destination: $destination, status: $status"
    }
}