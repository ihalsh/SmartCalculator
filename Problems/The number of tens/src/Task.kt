fun main() = readLine()!!.run { println(if (length < 2) 0 else elementAt(length - 2)) }