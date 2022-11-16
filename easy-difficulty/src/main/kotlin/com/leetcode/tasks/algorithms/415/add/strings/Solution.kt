package com.leetcode.tasks.algorithms.`415`.add.strings

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 */


private object Solution {

    fun addStrings(num1: String, num2: String): String {
        var p1 = num1.lastIndex
        var p2 = num2.lastIndex

        val sb = StringBuilder()
        var additionalDigit = 0
        while (p1 >= 0 || p2 >= 0) {
            val digit1 = if (p1 >= 0) num1[p1] - '0' else 0
            val digit2 = if (p2 >= 0) num2[p2] - '0' else 0

            val sum = digit1 + digit2 + additionalDigit
            sb.append(sum % 10)
            additionalDigit = sum / 10

            p1--
            p2--
        }
        if (additionalDigit == 1) sb.append(additionalDigit)

        return sb.reverse().toString()
    }
}

fun main() {

    println(Solution.addStrings(num1 = "11", num2 = "123") == "134")
    println(Solution.addStrings(num1 = "456", num2 = "77") == "533")
    println(Solution.addStrings(num1 = "0", num2 = "0") == "0")

}
