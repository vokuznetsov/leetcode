package com.leetcode.tasks.`66`.plus.one

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */

private object Solution {

    fun plusOne(digits: IntArray): IntArray {
        var additionalDigest = 0

        for (i in digits.lastIndex downTo 0) {
            val d = if (i == digits.lastIndex) digits[i] + 1 else digits[i] + additionalDigest
            additionalDigest = 0

            if (d > 9) {
                digits[i] = (d % 10)
                additionalDigest++
            } else digits[i] = d
        }

        return if (additionalDigest != 0) intArrayOf(additionalDigest, *digits) else digits
    }

}

fun main() {

    println(Solution.plusOne(intArrayOf(1, 2, 3)).contentEquals(intArrayOf(1, 2, 4)))
    println(Solution.plusOne(intArrayOf(4, 3, 2, 1)).contentEquals(intArrayOf(4, 3, 2, 2)))
    println(Solution.plusOne(intArrayOf(9)).contentEquals(intArrayOf(1, 0)))
    println(Solution.plusOne(intArrayOf(9, 9)).contentEquals(intArrayOf(1, 0, 0)))

}
