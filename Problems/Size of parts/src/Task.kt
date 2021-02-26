import java.util.*

fun main() = Scanner(System.`in`).run { Array(nextInt()) { nextInt() } }.run {
    println("${count { it == 0 }} ${count { it == 1 }} ${count { it == -1 }}")
}