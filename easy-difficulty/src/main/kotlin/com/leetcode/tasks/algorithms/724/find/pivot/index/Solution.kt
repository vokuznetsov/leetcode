package com.leetcode.tasks.algorithms.`724`.find.pivot.index

/**
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 */

private object Solution {

    fun pivotIndex(nums: IntArray): Int {
        var total = 0
        for (num in nums) total += num

        var prefix = 0
        for (i in 0..nums.lastIndex) {
            if (prefix == total - nums[i] - prefix) return i
            else prefix += nums[i]
        }

        return -1
    }

}

fun main() {

    println(Solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)) == 3)
    println(Solution.pivotIndex(intArrayOf(1, 2, 3)) == -1)
    println(Solution.pivotIndex(intArrayOf(2, 1, -1)) == 0)

}
