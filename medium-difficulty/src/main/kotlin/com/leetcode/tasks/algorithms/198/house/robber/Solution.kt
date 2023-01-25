package com.leetcode.tasks.algorithms.`198`.house.robber

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
private object Solution {

    val cache = IntArray(100) { -1 }

    // iterative way
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var first = nums[0]
        var second = Math.max(nums[0], nums[1])

        for (i in 2..nums.lastIndex) {
            val temp = Math.max(second, first + nums[i])
            first = second
            second = temp
        }

        return second
    }

    // recursion way
    fun rob1(nums: IntArray): Int {

        return robFrom(nums.lastIndex, nums)
    }

    private fun robFrom(index: Int, nums: IntArray): Int {
        if (index < 0) return 0
        if (cache[index] > -1) return cache[index]

        val result = Math.max(robFrom(index - 1, nums), robFrom(index - 2, nums) + nums[index])
        cache[index] = result
        return result
    }
}

fun main() {

    println(Solution.rob1(intArrayOf(7)) == 7)
    println(Solution.rob1(intArrayOf(2, 1, 1, 2)) == 4)
    println(Solution.rob1(intArrayOf(3, 1, 1, 9, 2)) == 12)
    println(Solution.rob1(intArrayOf(9, 1, 1, 1, 1, 9)) == 19)
    println(Solution.rob1(intArrayOf(1, 2, 3, 1)) == 4)
    println(Solution.rob1(intArrayOf(2, 7, 9, 3, 1)) == 12)

}