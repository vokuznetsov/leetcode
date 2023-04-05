package com.leetcode.tasks.algorithms.`283`.move.zeroes

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */

private object Solution {

    // First approach
    fun moveZeroes(nums: IntArray) {
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

    // Second approach
    fun moveZeroes1(nums: IntArray) {
        var left = 0
        var right = 0

        while (right <= nums.lastIndex) {
            if (nums[left] == 0) {
                while (right < nums.lastIndex && nums[right] == 0) right++
                nums[left] = nums[right]
                nums[right] = 0
            }

            left++
            right++
        }
    }
}

fun main() {

    val nums1 = intArrayOf(0, 1, 0, 3, 12)
    Solution.moveZeroes(nums1)
    print("Result: ")
    nums1.forEach { print("$it ") }

    println(nums1.contentEquals(intArrayOf(1, 3, 12, 0, 0)))

    val nums2 = intArrayOf(0, 0, 1, 3, 12)
    Solution.moveZeroes(nums2)
    print("Result: ")
    nums2.forEach { print("$it ") }

    println(nums2.contentEquals(intArrayOf(1, 3, 12, 0, 0)))

}
