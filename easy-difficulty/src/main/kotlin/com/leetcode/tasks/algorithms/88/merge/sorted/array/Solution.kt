package com.leetcode.tasks.algorithms.`88`.merge.sorted.array

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
private object Solution {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var lastIndex = nums1.lastIndex
        var last1 = m - 1
        var last2 = n - 1

        while (lastIndex >= 0) {
            if (last2 < 0) return

            if (last1 >= 0 && nums1[last1] >= nums2[last2]) {
                nums1[lastIndex] = nums1[last1]
                last1--
            } else {
                nums1[lastIndex] = nums2[last2]
                last2--
            }
            lastIndex--
        }
    }
}

fun main() {

    val nums11 = intArrayOf(1, 2, 3, 0, 0, 0)
    Solution.merge(nums11, 3, intArrayOf(2, 5, 6), 3)
    println(nums11.contentEquals(intArrayOf(1, 2, 2, 3, 5, 6)))


    val nums12 = intArrayOf(1)
    Solution.merge(nums12, 1, intArrayOf(), 0)
    println(nums12.contentEquals(intArrayOf(1)))

    val nums13 = intArrayOf(0)
    Solution.merge(nums13, 0, intArrayOf(1), 1)
    println(nums13.contentEquals(intArrayOf(1)))

    val nums14 = intArrayOf(4, 5, 6, 0, 0, 0)
    Solution.merge(nums14, 3, intArrayOf(1, 2, 3), 3)
    println(nums14.contentEquals(intArrayOf(1, 2, 3, 4, 5, 6)))


}
