private fun Int.getAnswer() = mapOf(
        1 to "You have chosen a square",
        2 to "You have chosen a circle",
        3 to "You have chosen a triangle",
        4 to "You have chosen a rhombus")
        .getOrDefault(this, "There is no such shape!")

fun main() = println(readLine()!!.toInt().getAnswer())