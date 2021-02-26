import java.util.*

fun main() = println(when (Scanner(System.`in`).nextInt()) {
    in 0..9 -> 1
    in 10..99 -> 2
    in 100..999 -> 3
    else -> 4
})