import java.lang.Character.getNumericValue

fun main() = println(readLine()!!.fold(0) { acc: Int, c: Char -> acc + getNumericValue(c) })