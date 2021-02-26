fun main() =
        readLine()!!.let { string: String ->
            readLine()!!.toInt().let { n: Int ->
                println("""Symbol # $n of the string "$string" is '${string[n - 1]}'""")
            }
        }