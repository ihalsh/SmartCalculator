fun generate(functionName: String): (Int) -> Int {
    val identity: (Int) -> Int = { it }
    val half: (Int) -> Int = { it / 2 }
    val zero: (Int) -> Int = { 0 }

    return when (functionName) {
        "identity" -> identity
        "half" -> half
        else -> zero
    }
}