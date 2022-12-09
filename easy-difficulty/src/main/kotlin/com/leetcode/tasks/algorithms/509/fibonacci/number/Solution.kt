package com.leetcode.tasks.algorithms.`509`.fibonacci.number

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */


private object Solution {

    val cache = IntArray(31) { -1 }

    // O(1) space
    fun fib(n: Int): Int {
        if (n < 2) return n

        var first = 0
        var second = 1

        for (i in 2..n) {
            val temp = first + second
            first = second
            second = temp
        }

        return second
    }

    // recursion (Top-Down)
    fun fib1(n: Int): Int {
        if (n < 2) return n

        if (cache[n] > 0) {
            return cache[n]
        }

        val result = fib1(n - 1) + fib1(n - 2)
        cache[n] = result
        return result
    }

    // Bottom-Up
    fun fib2(n: Int): Int {
        if (n < 2) return n

        val dp = IntArray(31) { -1 }
        dp[0] = 0
        dp[1] = 1

        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}

fun main() {

    println(Solution.fib2(2) == 1)
    println(Solution.fib2(3) == 2)
    println(Solution.fib2(4) == 3)

}
