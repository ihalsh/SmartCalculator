import kotlin.math.sqrt

fun main() = sqrt(readLine()!!.toDouble()).toInt().let { n -> (1..n).forEach { println(it * it) } }