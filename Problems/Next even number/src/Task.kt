import java.util.*

fun main() = Scanner(System.`in`).nextInt().let { println(if (it % 2 == 0) it + 2 else it + 1) }