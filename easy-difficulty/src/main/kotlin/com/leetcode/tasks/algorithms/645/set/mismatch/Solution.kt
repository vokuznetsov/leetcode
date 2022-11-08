package com.leetcode.tasks.`645`.set.mismatch

/**
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/
 */


private object Solution {

    // O(n) - time complexity, O(n) - space complexity
    fun findErrorNums(nums: IntArray): IntArray {
        val set = mutableSetOf<Int>()
        val result = IntArray(2)
        var lostValue = 0

        for ((index, value) in nums.withIndex()) {
            if (!set.add(value)) {
                result[0] = value
                lostValue = lostValue xor (index + 1)
            } else lostValue = lostValue xor (index + 1) xor value
        }

        result[1] = lostValue
        return result
    }

    // O(n) - time complexity, O(1) - space complexity
    fun findErrorNums1(nums: IntArray): IntArray {
        var duplicates = 0
        var missing = 0

        for (n in nums) {
            if (nums[Math.abs(n) - 1] < 0) duplicates = Math.abs(n)
            else nums[Math.abs(n) - 1] *= -1
        }

        for (index in nums.indices) {
            if (nums[index] > 0) missing = index + 1
        }

        return intArrayOf(duplicates, missing)
    }

}

fun main() {

    println(Solution.findErrorNums1(intArrayOf(1, 2, 2, 4)).contentEquals(intArrayOf(2, 3)))
    println(Solution.findErrorNums1(intArrayOf(1, 2, 3, 3, 4, 6, 7)).contentEquals(intArrayOf(3, 5)))
    println(Solution.findErrorNums1(intArrayOf(2, 2)).contentEquals(intArrayOf(2, 1)))
    println(Solution.findErrorNums1(intArrayOf(3, 2, 2)).contentEquals(intArrayOf(2, 1)))

}
