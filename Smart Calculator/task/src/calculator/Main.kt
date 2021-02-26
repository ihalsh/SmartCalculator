package calculator

import java.math.BigInteger
import java.util.*
import kotlin.math.pow

fun main() {
    val variables = mutableMapOf<String, BigInteger>()
    while (true) {
        val userInput = readLine()
        if (userInput.isNullOrBlank()) continue

        userInput.cleanUp().run {
            when {
                isCommand() -> when (this) {
                    EXIT -> println(BYE).also { return }
                    HELP -> println(HELP_MESSAGE)
                    else -> println(UNKNOWN_COMMAND)
                }
                isNumber() -> println(toNumber())
                isVariableName() -> println(variables[this] ?: UNKNOWN_VARIABLE)
                isAssignment() -> {
                    when {
                        isValidAssignment() -> {
                            val (key, value) = split('=')
                            when {
                                value.isNumber() -> variables[key] = value.toNumber()
                                variables[value] != null -> variables[key] = variables[value]!!
                                else -> println(UNKNOWN_VARIABLE)
                            }
                        }
                        isInvalidIdentifier() -> println(INVALID_IDENTIFIER)
                        else -> println(INVALID_ASSIGNMENT)
                    }
                }
                isExpression() -> {
                    convertToInfix(this, variables).run {
                        when {
                            contains("null") -> println(UNKNOWN_VARIABLE)
                            count { it.isLeftParenthesis() } != count { it.isRightParenthesis() } ->
                                println(INVALID_EXPRESSION)
                            else -> println(processPostfix(convertToPostfix(this)))
                        }
                    }
                }
                else -> println(INVALID_EXPRESSION)
            }
        }
    }
}

private fun convertToInfix(input: String, variables: MutableMap<String, BigInteger>): MutableList<String> = input
        .split("""(?<=[-+*/^(])|(?=[-+*/^)])""".toRegex())
        .map { if (it.isVariableName()) variables[it].toString() else it }
        .toMutableList()

fun convertToPostfix(infix: MutableList<String>): MutableList<String> = mutableListOf<String>()
        .apply {
            val stack = Stack<String>()
            repeat(infix.size) {
                infix.removeAt(0).run {
                    if (isNumber()) add(this)
                    if (isLeftParenthesis()) stack.push(this)
                    if (isRightParenthesis()) {
                        while (!stack.peek().isLeftParenthesis()) add(stack.pop())
                        stack.pop()
                    }
                    if (isOperation())
                        if (stack.isNotEmpty()) {
                            if (stack.peek().getPriority() < getPriority()) stack.push(this) else {
                                while (stack.isNotEmpty() && stack.peek().getPriority() >= getPriority()) add(stack.pop())
                                stack.push(this)
                            }
                        } else stack.push(this)
                }
            }
            while (stack.isNotEmpty()) add(stack.pop())
        }

fun processPostfix(postfix: MutableList<String>): String {

    fun calculate(a: String, b: String, s: String) = when (s) {
        PLUS -> a.toNumber() + b.toNumber()
        MINUS -> a.toNumber() - b.toNumber()
        MULTIPLY -> a.toNumber() * b.toNumber()
        DIVIDE -> a.toNumber() / b.toNumber()
        POWER -> a.toNumber().toBigDecimal().pow(b.toInt()).toBigInteger()
        else -> BigInteger.ZERO
    }

    val stack = Stack<String>()
    repeat(postfix.size) {
        postfix.removeAt(0).run {
            if (isNumber()) stack.push(this)
            if (isOperation()) {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(calculate(a, b, this).toString())
            }
        }
    }
    return stack.pop()
}

private fun String.isNumber() = matches("""[-+]?\d+$""".toRegex())
private fun String.isLeftParenthesis() = this == "("
private fun String.isRightParenthesis() = this == ")"
private fun String.isOperation() = matches("""\++|\-+|\*|\/|\^""".toRegex())
private fun String.isCommand() = elementAt(0) == '/'
private fun String.isVariableName() = matches("""[a-zA-Z]+""".toRegex())
private fun String.isExpression() = matches("""([-+]?[(]*(\d+|[a-zA-Z]+)[)]*)((\++|\-+|\*|\/|\^)[(]*(\d+|[a-zA-Z]+)[)]*)*""".toRegex())
private fun String.isAssignment() = matches("""(.+)=(.+)?""".toRegex())
private fun String.isValidAssignment() = matches("""[a-zA-Z]+=([-+]?\d+|[a-zA-Z]+)""".toRegex())
private fun String.isInvalidIdentifier() = matches("""^[^=]+=[-+]?\d+""".toRegex())


private fun String.cleanUp() = this
        .replace(" ", "")
        .replace("--", "+")
        .replace("""\++""".toRegex(), "+")
        .replace("+-", "-")

private fun String.toNumber() = toBigInteger() /*toInt()*/
private fun String.getPriority(): Int = when (this) {
    PLUS -> 1
    MINUS -> 1
    MULTIPLY -> 2
    DIVIDE -> 2
    POWER -> 3
    else -> 0
}

const val UNKNOWN_VARIABLE = "Unknown variable"
const val EXIT = """/exit"""
const val HELP = """/help"""
const val UNKNOWN_COMMAND = "Unknown command"
const val BYE = "Bye!"
const val HELP_MESSAGE = "Calculates the sum and difference of several numbers, support both unary and binary " +
        "minus operator."
const val INVALID_EXPRESSION = "Invalid expression"
const val INVALID_IDENTIFIER = "Invalid identifier"
const val INVALID_ASSIGNMENT = "Invalid assignment"
const val MINUS = "-"
const val PLUS = "+"
const val MULTIPLY = "*"
const val DIVIDE = "/"
const val POWER = "^"