package com.leetcode.tasks.algorithms.`209`.minimum.size.subarray.sum

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
private object Solution {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var min = Int.MAX_VALUE

        for (right in 0..nums.lastIndex) {
            sum += nums[right]

            while (left <= right && sum >= target) {
                min = Math.min(min, right - left + 1)
                sum -= nums[left]
                left++
            }
        }

        return if (min == Int.MAX_VALUE) 0 else min
    }
}


fun main() {

    println(Solution.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) == 2)
    println(Solution.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 100)) == 1)
    println(Solution.minSubArrayLen(4, intArrayOf(1, 4, 4)) == 1)
    println(Solution.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) == 0)
    println(Solution.minSubArrayLen(6, intArrayOf(10, 2, 3)) == 1)
    println(Solution.minSubArrayLen(0, intArrayOf(0, 0, 0)) == 1)

}