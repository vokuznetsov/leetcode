package com.leetcode.tasks.`202`.happy.number

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 */


private object Solution {

    // memory - O(n)
    fun isHappy(n: Int): Boolean {
        var lastValue = n
        val set = mutableSetOf<Int>()

        while (lastValue != 1) {
            val value = toDigits(lastValue).map { it * it }.fold(0) { acc: Int, i: Int -> acc + i }
            if (set.contains(value)) return false
            set.add(value)
            lastValue = value
        }

        return true
    }

    private fun toDigits(n: Int): List<Int> {
        var value = n
        val digits = mutableListOf<Int>()
        while (value != 0) {
            digits.add(value % 10)
            value /= 10
        }
        return digits
    }

    // memory - O(1)
    fun isHappy1(n: Int): Boolean {
        var slow = n
        var fast = n

        do {
            slow = squareDigitsSum(slow)
            fast = squareDigitsSum(fast)
            fast = squareDigitsSum(fast)
        } while (slow != fast)

        if (slow == 1) return true
        return false
    }

    private fun squareDigitsSum(n: Int): Int {
        var sum = 0
        var value = n
        while (value != 0) {
            val remainder = value % 10
            sum += remainder * remainder
            value /= 10
        }
        return sum
    }
}

fun main() {

    println(Solution.isHappy1(19))
    println(Solution.isHappy1(2))

}
