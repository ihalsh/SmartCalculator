fun main() {
    val (duration, foodCost, flightCost, nightCost) = readLine()!!.split(" ").map { it.toInt() }
    println(foodCost * duration + flightCost * 2 + nightCost * (duration - 1))
}