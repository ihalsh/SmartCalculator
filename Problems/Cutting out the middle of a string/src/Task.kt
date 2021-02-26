fun main() = println(readLine()!!.run {
    (length / 2 + length % 2 - 1).let { take(it) + takeLast(it) }
})