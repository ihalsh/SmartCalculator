import java.util.*

fun main() = println(Scanner(System.`in`).asSequence().fold(0) { acc, i -> acc + (i.toInt() + 1) / 2 })