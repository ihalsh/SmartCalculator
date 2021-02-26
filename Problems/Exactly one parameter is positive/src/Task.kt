import java.util.*

fun main() = Scanner(System.`in`).run { println(Array(3) { nextInt() }.count { it > 0 } == 1) }