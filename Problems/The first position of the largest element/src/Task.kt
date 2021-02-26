import java.util.*

fun main() = Scanner(System.`in`).asSequence().toList().run {
    println("${max()} ${indexOf(max()) + 1}")
}