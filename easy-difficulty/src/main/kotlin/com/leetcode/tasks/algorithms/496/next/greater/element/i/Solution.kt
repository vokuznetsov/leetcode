package com.leetcode.tasks.algorithms.`496`.next.greater.element.i

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 */

private object Solution {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

        val queue = ArrayDeque<Int>()
        val map = mutableMapOf<Int, Int>()

        for (n in nums2) {
            while(queue.isNotEmpty() && n > queue.last()) {
                val value = queue.removeLast()
                map[value] = n
            }
            queue.add(n)
        }

        val result = IntArray(nums1.size) {-1}

        for (i in 0..nums1.lastIndex) {
            if (map.contains(nums1[i])) result[i] = map.getOrDefault(nums1[i], -1)
        }
        return result
    }
}

fun main() {


}
