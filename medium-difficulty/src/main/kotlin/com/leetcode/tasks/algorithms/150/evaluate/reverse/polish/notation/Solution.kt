package com.leetcode.tasks.algorithms.`150`.evaluate.reverse.polish.notation

import java.util.ArrayDeque

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
private object Solution {

    val operands = listOf("+", "-", "*", "/")

    fun evalRPN(tokens: Array<String>): Int {

        val stack = ArrayDeque<String>()
        var count = 0

        do {
            val symbol = tokens[count]
            if (isDigit(symbol))
                stack.addLast(symbol)
            else calculate(symbol, stack)

            count++
        } while (tokens.size != count)

        return stack.removeLast().toInt()
    }

    private fun isDigit(symbol: String): Boolean = !operands.contains(symbol)

    private fun calculate(operand: String, stack: ArrayDeque<String>) {
        val y: Int = stack.removeLast().toInt()
        val x: Int = stack.removeLast().toInt()
        val result = when (operand) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            "/" -> x / y
            else -> 0
        }
        stack.addLast(result.toString())
    }
}

fun main() {

    println(Solution.evalRPN(arrayOf("2", "1", "+", "3", "*")) == 9)
    println(Solution.evalRPN(arrayOf("4", "13", "5", "/", "+")) == 6)
    println(Solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)

}