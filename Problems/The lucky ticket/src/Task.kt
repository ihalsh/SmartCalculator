fun main() = readLine()!!
        .map { it.toInt() }
        .chunked(3)
        .map { it.sum() }
        .run { println(if (first() == last()) "Lucky" else "Regular")
}