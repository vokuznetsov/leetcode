package com.leetcode.tasks.algorithms.`1137`.`n-th`.tribonacci.number

/**
 * 1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

private object Solution {

    val cache = mutableMapOf<Int, Int>()

    // Top-Down approach: Recursion with Memoization
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1 || n == 2) return 1
        cache[n]?.let { return it }

        val result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
        cache[n] = result

        return result
    }

    // Bottom-UP approach: Performance Optimisation : Dynamic Programming
    fun tribonacci1(n: Int): Int {
        if (n == 0 || n == 1) return n
        if (n == 2) return 1

        val dp = IntArray(38)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1

        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }

        return dp[n]
    }

    // Space Optimisation : Dynamic Programming
    // space O(1)
    fun tribonacci2(n: Int): Int {
        if (n == 0 || n == 1) return n
        if (n == 2) return 1

        var x = 0
        var y = 1
        var z = 1

        for (i in 3..n) {
            val temp = x + y + z
            x = y
            y = z
            z = temp
        }

        return z
    }
}

fun main() {

    println(Solution.tribonacci2(4) == 4)
    println(Solution.tribonacci2(25) == 1389537)

}
