import java.util.*

fun main() = Scanner(System.`in`).run { println(Array(3) { nextInt() }.let { it.contains(it.sum() - 20) }) }