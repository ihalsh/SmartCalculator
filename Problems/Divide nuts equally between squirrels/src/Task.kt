import java.util.Scanner

fun main() = println(Scanner(System.`in`).asSequence().toList().run { last().toInt() / first().toInt() })