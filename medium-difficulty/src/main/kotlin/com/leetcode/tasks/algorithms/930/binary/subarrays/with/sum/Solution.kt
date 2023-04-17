package com.leetcode.tasks.algorithms.`930`.binary.subarrays.with.sum

/**
 * 930. Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
private object Solution {

    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        var ans = 0
        var curr = 0
        val map = mutableMapOf<Int, Int>()
        map[0] = 1

        for (num in nums) {
            curr += num
            ans += map.getOrDefault(curr - goal, 0)

            map[curr] = map.getOrDefault(curr, 0) + 1
        }

        return ans
    }
}

fun main() {

    println(Solution.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2) == 4)
    println(Solution.numSubarraysWithSum(intArrayOf(0, 0, 0, 0, 0), 0) == 15)
}