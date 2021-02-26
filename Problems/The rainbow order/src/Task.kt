fun main() = println(Rainbow.valueOf(readLine()!!.toUpperCase()).ordinal + 1)

enum class Rainbow {
        RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}