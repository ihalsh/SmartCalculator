fun main() = if (readLine()!!.isPalindrome()) println("yes") else println("no")

fun String.isPalindrome() = this == reversed()