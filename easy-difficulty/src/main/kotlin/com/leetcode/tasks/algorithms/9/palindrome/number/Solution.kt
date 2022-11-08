package com.leetcode.tasks.algorithms.`9`.palindrome.number

import kotlin.math.log10
import kotlin.math.pow

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
private object Solution {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        val length = log10(x.toDouble()).toInt() + 1
        if (length == 1) return true

        var endNumber = x
        var startNumber = x

        for (i in 1..length / 2) {
            val end = endNumber % 10
            endNumber /= 10

            val starDivider = 10.toDouble().pow(length - i).toInt()
            val start = startNumber / starDivider
            startNumber -= starDivider * start

            if (start != end) return false
        }

        return true
    }
}

fun main() {

    println(Solution.isPalindrome(x = 9999))

}