package com.leetcode.tasks.algorithms.`1004`.max.consecutive.ones.iii

/**
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
private object Solution1 {

    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var curr = 0
        var ans = 0

        for (i in 0..nums.lastIndex) {
            if (nums[i] == 0) curr++

            while (curr > k) {
                if (nums[left] == 0) curr--
                left++
            }

            ans = Math.max(ans, i - left + 1)
        }

        return ans
    }
}

fun main() {

    println(Solution1.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2) == 6)
    println(Solution1.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3) == 10)
}
