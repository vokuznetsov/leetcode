package com.leetcode.tasks.`169`.majority.element

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */

private object Solution {

    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (value in nums) {
            map[value] = map.getOrDefault(value, 0) + 1
            if (map.getOrDefault(value, 0) > nums.size / 2) return value
        }

        return 0
    }

    // Approach 6: Boyer-Moore Voting Algorithm
    // Time complexity : O(n)
    // Boyer-Moore performs constant work exactly nn times, so the algorithm runs in linear time.
    // Space complexity : O(1)
    // Boyer-Moore allocates only constant additional memory.
    fun majorityElementFastest(nums: IntArray): Int {
        var count = 0
        var candidate = nums[0]

        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }

        return candidate
    }
}

fun main() {

    println(Solution.majorityElementFastest(intArrayOf(3, 2, 3)) == 3)
    println(Solution.majorityElementFastest(intArrayOf(2, 2, 1, 1, 1, 2, 2)) == 2)

}
