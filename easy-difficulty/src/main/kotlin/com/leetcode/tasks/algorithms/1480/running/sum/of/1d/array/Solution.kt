package com.leetcode.tasks.algorithms.`1480`.running.sum.of.`1d`.array

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */

private object Solution {

    fun runningSum(nums: IntArray): IntArray {
        var prefix = 0
        val result = IntArray(nums.size)

        for ((index, value) in nums.withIndex()) {
            result[index] = prefix + value
            prefix = result[index]
        }

        return result
    }
}

fun main() {

    println(Solution.runningSum(intArrayOf(1, 2, 3, 4)).contentEquals(intArrayOf(1, 3, 6, 10)))
    println(Solution.runningSum(intArrayOf(1, 1, 1, 1, 1)).contentEquals(intArrayOf(1, 2, 3, 4, 5)))
    println(Solution.runningSum(intArrayOf(3, 1, 2, 10, 1)).contentEquals(intArrayOf(3, 4, 6, 16, 17)))

}
