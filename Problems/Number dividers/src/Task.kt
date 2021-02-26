import java.util.*

fun main() = Scanner(System.`in`).nextInt().let { n ->
    listOf(2, 3, 5, 6).forEach { m ->
        if (n % m == 0) println("Divided by $m")
    }
}