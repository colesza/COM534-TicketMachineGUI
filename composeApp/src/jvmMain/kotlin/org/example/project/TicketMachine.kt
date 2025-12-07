class TicketMachine(val station: String) {

    private val destinations = mutableListOf<Destination>()
    var specialOffers = mutableListOf<SpecialOffer>()

    private var money = 0.0

    var users = mutableListOf<User>()
    var user: User? = null

    fun insertMoney(insertedMoney: Double) {
        money += insertedMoney
    }

    fun buyTicket(destination: Destination, ticketType: TicketType): Ticket? {

        val price = destination.getPrice(ticketType)
        if (money >= price) {
            money -= price
            destination.sellTicket(ticketType)
            return Ticket(ticketType, station, destination)
        }

        return null
    }

    fun findDestinationByName(name: String): Destination? {
        // find() finds the first entry in a list matching the condition specified in the lambda,
        // or null if it cannot be found
        return destinations.find { it.name == name }
    }

    fun addDestination(destination: Destination): Boolean {
        if (user != null) {
            destinations.add(destination)
            return true
        }
        return false
    }

    fun changeAllPrices(factor: Double): Boolean {
        if (user != null) {
            destinations.forEach {
                it.changePricesByFactor(factor)
            }
            return true
        }
        return false
    }

    fun getAllDestinations(): List<Destination> {
        if (user != null) {
            return destinations
        }
        return listOf()
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun login(username: String, password: String): Boolean {
        user = users.find { it.username == username && it.password == password }
        return user != null
    }

    fun logout() {
        user = null
    }

    fun addSpecialOffer(so: SpecialOffer): Boolean {
        if (user != null) {
            specialOffers.add(so)
            return true
        }
        return false

    }

    fun deleteSpecialOffer(so: SpecialOffer): Boolean {
        if (user != null) {
            specialOffers = specialOffers.filter { it.id != so.id }.toMutableList()
            return true
        }
        return false
    }

    fun findSpecialOffer(stationName: String): List<SpecialOffer> {
        return specialOffers.filter { stationName == it.destination.name }
    }
}