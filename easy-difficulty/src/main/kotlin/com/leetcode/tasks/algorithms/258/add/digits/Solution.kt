package com.leetcode.tasks.`258`.add.digits

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 */


private object Solution {

    fun addDigits(num: Int): Int {
        var value = num

        while (value / 10 != 0) {
            value = digitSum(value)
        }

        return value
    }

    private fun digitSum(num: Int): Int {
        var value = num
        var newValue = 0
        while (value != 0) {
            newValue += value % 10
            value /= 10
        }
        return newValue
    }

    // O(1) - time and space complexity
    // more information - https://leetcode.com/problems/add-digits/solutions/666062/add-digits/
    fun addDigits1(num: Int): Int {
        if (num == 0) return 0
        if (num % 9 == 0) return 9
        return num % 9
    }

}

fun main() {

    println(Solution.addDigits(38) == 2)
    println(Solution.addDigits(5) == 5)
    println(Solution.addDigits(0) == 0)

}
