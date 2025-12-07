import java.text.DecimalFormat

class Ticket(val ticketType: TicketType, val origin: String, val destination: Destination) {
    override fun toString() : String {
        val df = DecimalFormat("#.##")
        val price = destination.getPrice(ticketType)
        return """
***

[$origin]

to

[${destination.name}]

Price: ${df.format(price)}[$ticketType]

***
"""
    }
}