package com.leetcode.tasks.algorithms.`350`.intersection.of.two.arrays.ii

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

private object Solution {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map2 = mutableMapOf<Int, Int>()

        for (i in nums2) {
            map2[i] = map2.getOrDefault(i, 0) + 1
        }

        val result = mutableListOf<Int>()

        for (i in nums1) {
            if (map2.containsKey(i)) {
                result.add(i)

                map2[i]?.let {
                    if (it > 1) map2[i] = it - 1 else map2.remove(i)
                }
            }
        }

        return result.toIntArray()
    }
}

fun main() {

    println(Solution.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentEquals(intArrayOf(2, 2)))
    println(Solution.intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentEquals(intArrayOf(4, 9)))

}
