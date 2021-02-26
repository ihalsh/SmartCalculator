fun main() = mutableMapOf<Int, String>().let { map ->
    var counter = 0
    while (map[counter] != "z") map[++counter] = readLine()!!
    print(map[4])
}