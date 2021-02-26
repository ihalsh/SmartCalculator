import java.util.*

fun main() {
    with(Scanner(System.`in`)) {
        val quantity = nextInt()
        when (nextBoolean()) {
            true -> println(quantity in 15..25)
            false -> println(quantity in 10..20)
        }
    }
}