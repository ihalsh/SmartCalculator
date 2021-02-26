fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    println(a in b..c)
}