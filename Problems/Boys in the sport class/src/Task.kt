fun main() = println(readLine()!!.split(" ").run { equals(sorted()) || equals(sortedDescending()) })
