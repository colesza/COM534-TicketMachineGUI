import java.text.DecimalFormat

class Destination(var name: String, var singlePrice: Double, var returnPrice: Double) {
    var takings = 0.0
    var sales = 0


    fun getPrice(ticketType: TicketType) : Double {
        return if (ticketType == TicketType.SINGLE) singlePrice else returnPrice
    }

    fun sellTicket(ticketType: TicketType) {
        takings += this.getPrice(ticketType)
        sales++
    }

    override fun toString(): String {
        val df = DecimalFormat("#.##")
        return "Station $name: sales $sales, total takings ${df.format(takings)}"
    }

    // names of stations can change, e.g. local station Ashurst (New Forest) was Lyndhurst Road before 1995
    fun changeDetails(newName: String, newSinglePrice: Double, newReturnPrice: Double) {
        name = newName
        singlePrice = newSinglePrice
        returnPrice = newReturnPrice
    }

    fun changePricesByFactor(factor: Double) {
        singlePrice *= factor
        returnPrice *= factor
    }

}