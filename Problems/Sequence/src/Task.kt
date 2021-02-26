fun main() = readLine()!!.replace(" ", "").let { chars ->
    println(chars.dropLast(1) == chars.dropLast(1).filterIndexed { index, c -> c + 1 == chars[index + 1] })
}