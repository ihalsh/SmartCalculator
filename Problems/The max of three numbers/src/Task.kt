fun main() = println(readLine()!!
        .split(" ")
        .map { it.toInt() }
        .toMutableList()
        .let { list ->
            repeat(2) { n ->
                if (list[n] > list[n + 1]) list[n + 1] = list[n].also { list[n] = list[n + 1] }
            }
            list.last()
        })