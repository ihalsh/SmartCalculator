fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    if (a > b) {
        println(a)
        return
    }
    println(b)
}