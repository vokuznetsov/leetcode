package com.leetcode.tasks.algorithms.`283`.move.zeroes

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */


private object Solution {

    fun moveZeroes(nums: IntArray): Unit {
        var startZeroPosition = -1
        for ((index, value) in nums.withIndex()) {
            if (value == 0 && startZeroPosition < 0) {
                startZeroPosition = index
            } else if (value != 0 && startZeroPosition >= 0) {
                nums[startZeroPosition] = value
                nums[index] = 0
                startZeroPosition++
            }
        }
    }
}

fun main() {

    val nums1 = intArrayOf(0, 1, 0, 3, 12)
    Solution.moveZeroes(nums1)
    print("Result: ")
    nums1.forEach { print("$it ") }

    println()

    val nums2 = intArrayOf(0, 0, 1, 3, 12)
    Solution.moveZeroes(nums2)
    print("Result: ")
    nums2.forEach { print("$it ") }

}
