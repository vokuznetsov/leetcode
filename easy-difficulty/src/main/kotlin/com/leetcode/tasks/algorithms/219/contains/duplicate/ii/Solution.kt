package com.leetcode.tasks.algorithms.`219`.contains.duplicate.ii

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 */

private object Solution {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        for (i in nums.indices) {
            val windowEnd = if (i + k >= nums.size) nums.size - 1 else i + k
            for (j in (i + 1..windowEnd)) {
                if (nums[i] == nums[j]) return true
            }
        }

        return false
    }

    // more optimal solution with O(n) runtime complexity
    fun containsNearbyDuplicate1(nums: IntArray, k: Int): Boolean {
        val set = mutableSetOf<Int>()

        for (i in nums.indices) {
            if (i > k) set.remove(nums[i - k - 1])
            if (!set.add(nums[i])) return true
        }

        return false
    }
}

fun main() {

    println(Solution.containsNearbyDuplicate1(intArrayOf(1, 2, 3, 1), 3))
    println(Solution.containsNearbyDuplicate1(intArrayOf(1, 0, 1, 1), 1))
    println(Solution.containsNearbyDuplicate1(intArrayOf(1, 0, 1, 1), 0))
    println(Solution.containsNearbyDuplicate1(intArrayOf(99, 99), 2))
    println(Solution.containsNearbyDuplicate1(intArrayOf(1, 2, 3, 1, 2, 3), 2))

}
