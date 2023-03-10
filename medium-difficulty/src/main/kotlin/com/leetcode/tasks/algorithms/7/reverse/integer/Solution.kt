package com.leetcode.tasks.algorithms.`7`.reverse.integer

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
private object Solution {

    fun reverse(x: Int): Int {
        var value = x
        var result = 0

        val maxValue = Int.MAX_VALUE
        val minValue = Int.MIN_VALUE

        while (value != 0) {
            val remainder = value % 10
            if (result > maxValue / 10 || (result == maxValue / 10 && remainder > maxValue % 10)) return 0
            if (result < minValue / 10 || (result == minValue / 10 && remainder < minValue % 10)) return 0

            result = result * 10 + remainder
            value /= 10
        }

        return result
    }
}

fun main() {

    println(Solution.reverse(0) == 0)
    println(Solution.reverse(123) == 321)
    println(Solution.reverse(-123) == -321)
    println(Solution.reverse(123) == 321)
    println(Solution.reverse(Int.MIN_VALUE) == 0)
    println(Solution.reverse(Int.MAX_VALUE) == 0)

}