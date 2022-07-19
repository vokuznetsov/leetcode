package com.leetcode.tasks.`26`.remove.duplicates.from.sorted.array

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
private object Solution {

    fun removeDuplicates1(nums: IntArray): Int {
        var k = 0

        for ((i, v) in nums.withIndex()) {
            if (i == nums.lastIndex) k++ else {
                if (v == nums[i + 1]) nums[i] = 200 + i else k++
            }
        }

        if (k != nums.size) nums.sort()
        return k
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var k = 1

        if (nums.size > 1) {
            for (i in 1..nums.lastIndex) {
                if (nums[i] != nums[i - 1]) {
                    nums[k] = nums[i]
                    k++
                }
            }
        }

        return k
    }
}

fun main() {

    println(Solution.removeDuplicates2(intArrayOf(1, 1, 2)) == 2)
    println(Solution.removeDuplicates2(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)) == 5)

}
