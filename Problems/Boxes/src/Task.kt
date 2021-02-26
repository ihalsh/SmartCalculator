import java.util.*

fun main() = Scanner(System.`in`).run { Array(6) { nextInt() } }.run {
    val (x1, y1, z1) = take(3).sorted()
    val (x2, y2, z2) = takeLast(3).sorted()
    println(when {
        x1 == x2 && y1 == y2 && z1 == z2 -> "Box 1 = Box 2"
        x1 <= x2 && y1 <= y2 && z1 <= z2 -> "Box 1 < Box 2"
        x1 >= x2 && y1 >= y2 && z1 >= z2 -> "Box 1 > Box 2"
        else -> "Incomparable"
    })
}