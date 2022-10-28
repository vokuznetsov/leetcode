package com.leetcode.tasks.`230`.power.of.two

/**
 * 230. Power of Two
 * https://leetcode.com/problems/power-of-two/
 */

private object Solution {

    fun isPowerOfTwo(n: Int): Boolean {
        return if (n <= 0) false else n.toString(2).filter { it == '1' }.length == 1
    }

    fun isPowerOfTwoRecursion(n: Int): Boolean {
        if (n == 1) return true
        return if (n > 0 && n % 2 == 0) isPowerOfTwoRecursion(n / 2) else false
    }

}

fun main() {

    println(Solution.isPowerOfTwoRecursion(1))
    println(Solution.isPowerOfTwoRecursion(4))
    println(Solution.isPowerOfTwoRecursion(3))
    println(Solution.isPowerOfTwoRecursion(-16))

}
