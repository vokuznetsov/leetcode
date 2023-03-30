package com.leetcode.tasks.algorithms.`643`.maximum.average.subarray.i

/**
 * 643. Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
private object Solution {

    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0
        var left = 0
        var ans = 0.0

        for (i in 0 until k) {
            sum += nums[i]
        }
        ans = sum * 1.0 / k

        for (i in k..nums.lastIndex) {
            sum = sum + nums[i] - nums[i - k]
            left++
            ans = Math.max(ans, sum * 1.0 / k)
        }

        return ans
    }
}

fun main() {

    println(Solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4) == 12.75)
    println(Solution.findMaxAverage(intArrayOf(5), 1) == 5.0)
}
