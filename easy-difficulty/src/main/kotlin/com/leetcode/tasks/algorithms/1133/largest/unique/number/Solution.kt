package com.leetcode.tasks.algorithms.`1133`.largest.unique.number

/**
 * 1133. Largest Unique Number
 * https://leetcode.com/problems/largest-unique-number
 */

private object Solution {

    fun largestUniqueNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        val onlyOnce = mutableSetOf<Int>()
        for (num in nums) {
            val value = map.getOrDefault(num, 0) + 1
            map[num] = value
            if (value == 1) onlyOnce.add(num) else onlyOnce.remove(num)
        }

        return if (onlyOnce.isEmpty()) -1
        else {
            var max = -1
            for (value in onlyOnce) {
                max = Math.max(max, value)
            }
            max
        }
    }
}

fun main() {

    println(Solution.largestUniqueNumber(intArrayOf(5, 7, 3, 9, 4, 9, 8, 3, 1)) == 8)
    println(Solution.largestUniqueNumber(intArrayOf(9, 9, 8, 8)) == -1)

}
