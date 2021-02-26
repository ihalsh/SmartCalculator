import java.util.*

fun main() = with(Scanner(System.`in`)) { println(Array(3) { nextInt() }.toSet().size == 3) }