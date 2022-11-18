package com.leetcode.tasks.algorithms.`2235`.add.two.integers

/**
 * 2235. Add Two Integers
 * https://leetcode.com/problems/add-two-integers/
 */

private object Solution {

    fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

fun main() {

    println(Solution.sum(1, 2) == 3)
    println(Solution.sum(12, 5) == 17)
    println(Solution.sum(-10, 4) == -6)

}
