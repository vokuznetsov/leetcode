package com.leetcode.tasks.`1323`.maximum.`69`.number

import kotlin.math.log10

/**
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/
 */

private object Solution {

    fun maximum69Number(num: Int): Int {
        var value = num
        var ext = log10(num.toDouble()).toInt()

        var result = 0

        while (ext >= 0) {
            val pow = Math.pow(10.0, ext.toDouble()).toInt()

            val digit = value / pow
            if (digit == 6) {
                result += 9 * pow
                return if (ext == 0) result else result + num % pow
            }
            result += digit * pow
            value = num - result
            ext--
        }

        return result
    }
}

fun main() {

    println(Solution.maximum69Number(6) == 9)
    println(Solution.maximum69Number(9) == 9)
    println(Solution.maximum69Number(9669) == 9969)
    println(Solution.maximum69Number(9996) == 9999)
    println(Solution.maximum69Number(9999) == 9999)
    println(Solution.maximum69Number(6999) == 9999)
    println(Solution.maximum69Number(6666) == 9666)

}
