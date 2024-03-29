package com.leetcode.tasks.algorithms.`268`.missing.number

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 */


private object Solution {

    fun missingNumber(nums: IntArray): Int {
        var sum = nums.size
        for (i in nums.indices) {
            sum = sum + i - nums[i]
        }
        return sum
    }

    // using hash set
    fun missingNumber1(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (i in 0..nums.size) set.add(i)
        for (num in nums) set.remove(num)

        return set.first()
    }
}

fun main() {

    println(Solution.missingNumber(intArrayOf(1, 2)) == 0)
    println(Solution.missingNumber(intArrayOf(2, 0)) == 1)
    println(Solution.missingNumber(intArrayOf(3, 0, 1)) == 2)
    println(Solution.missingNumber(intArrayOf(0, 1)) == 2)
    println(Solution.missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)) == 8)

}
