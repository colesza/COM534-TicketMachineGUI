class SpecialOffer (val id: Int, val destination: Destination, val details: String, val startDate: String, val endDate: String) {
    override fun toString(): String {
        return "For: ${destination.name}\n$details\nFrom: $startDate\nTo: $endDate\n"
    }
}