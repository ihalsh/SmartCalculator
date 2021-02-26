fun main() = readLine()!!.run {
    val (name, surname, age) = split(" ")
    println("${name.first()}. $surname, $age years old")
}