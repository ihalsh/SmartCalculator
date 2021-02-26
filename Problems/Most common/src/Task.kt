fun main() = mutableMapOf<String, Int>().run {
    while (true) {
        val string = readLine()!!
        if (string == "stop") break
        computeIfPresent(string) { _, v -> v + 1 }
        computeIfAbsent(string) { 1 }
    }
    print(maxBy { it.value }?.key)
}