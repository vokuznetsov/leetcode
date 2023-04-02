package com.leetcode.tasks.algorithms.`1480`.running.sum.of.`1d`.array

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */

private object Solution {

    fun minStartValue(nums: IntArray): Int {
        var min = 0
        var sum = 0

        for (i in 0..nums.lastIndex) {
            sum += nums[i]
            min = Math.min(min, sum)
        }

        return -min + 1
    }
}

fun main() {

    println(Solution.minStartValue(intArrayOf(-3, 2, -3, 4, 2)) == 5)
    println(Solution.minStartValue(intArrayOf(1, 2)) == 1)
    println(Solution.minStartValue(intArrayOf(1, -2, -3)) == 5)
    println(Solution.minStartValue(intArrayOf(2, 3, 5, -5, -1)) == 1)
    println(Solution.minStartValue(intArrayOf(-3, 6, 2, 5, 8, 6)) == 4)

}
