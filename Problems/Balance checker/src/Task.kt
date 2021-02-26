import java.util.*

fun main() = Scanner(System.`in`).asSequence().map { it.toInt() }.toList().checkBalance()

fun List<Int>.checkBalance() {
    var balance = first()
    takeLast(size - 1).forEach {
        if (balance - it < 0) {
            println("Error, insufficient funds for the purchase. You have $balance, but you need $it.")
            return
        }
        balance -= it
    }
    println("Thank you for choosing us to manage your account! You have $balance money.")
}