package com.leetcode.tasks.`349`.intersection.of.two.arrays

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */

private object Solution {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set2 = nums2.toSet()
        val result = mutableSetOf<Int>()

        nums1.forEach {
            if (set2.contains(it)) result.add(it)
        }

        return result.toIntArray()
    }
}

fun main() {

    println(Solution.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentEquals(intArrayOf(2)))
    println(Solution.intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentEquals(intArrayOf(4, 9)))

}
