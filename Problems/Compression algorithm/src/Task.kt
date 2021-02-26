fun main() = with(StringBuilder()) {
    val string = readLine()!!
    append(string[0])
    for (i in 1 until string.length) {
        if (string[i] == string[i - 1]) {
            append(string[i])
        } else {
            print("${last()}$length")
            clear()
            append(string[i])
        }
    }
    print("${last()}$length")
}