import java.util.*

fun main() = Scanner(System.`in`).run {
    println(Array(nextInt()) { nextInt() }.filter { it % 4 == 0 }.max())
}