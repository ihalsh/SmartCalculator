import java.util.*

fun main() {
    val (a, b, c) = Scanner(System.`in`).asSequence().map { it.toInt() }.toList()
    println(if (a + b > c && a + c > b && b + c > a) "YES" else "NO")
}