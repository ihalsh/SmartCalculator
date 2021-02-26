import java.util.*

fun main() = Scanner(System.`in`)
        .asSequence()
        .groupingBy { it.toInt() }
        .eachCount()
        .run {
            print("${getOrDefault(2, 0)} " +
                    "${getOrDefault(3, 0)} " +
                    "${getOrDefault(4, 0)} " +
                    "${getOrDefault(5, 0)}")
        }
