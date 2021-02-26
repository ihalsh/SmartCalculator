fun main() = readLine()!!.split(" ").run {
    println(Country.compareCurrenciesOf(first(), last()))
}

enum class Country(val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar");

    companion object {
        fun compareCurrenciesOf(firstCountry: String, secondCountry: String): Boolean {
            fun contains(name: String) = values().any { it.name == name.toUpperCase() }

            return if (contains(firstCountry) && contains(secondCountry)) {
                valueOf(firstCountry.toUpperCase()).currency == valueOf(secondCountry.toUpperCase()).currency
            } else false
        }
    }
}