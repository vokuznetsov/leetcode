package com.leetcode.tasks.algorithms.`70`.climbing.stairs

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */

private object Solution {

    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 1
        for (i in 0 until n - 1) {
            var temp = one
            one += two
            two = temp
        }
        return one
    }

}

fun main() {

    println(Solution.climbStairs(2) == 2)
    println(Solution.climbStairs(3) == 3)
    println(Solution.climbStairs(5) == 8)

}
