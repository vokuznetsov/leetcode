package com.leetcode.tasks.algorithms.`11`.container.with.most.water

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
private object Solution {

    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.lastIndex

        while (left < right) {
            val x = Math.min(height[left], height[right])
            val y = right - left
            max = Math.max(max, x * y)

            if (height[left] <= height[right]) left++ else right--

        }

        return max
    }
}

fun main() {

    println(Solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    println(Solution.maxArea(intArrayOf(1, 2, 1, 1, 100, 100, 1, 1, 2, 1)) == 100)
    println(Solution.maxArea(intArrayOf(4, 8, 8, 4, 4, 4, 4, 3)) == 24)
    println(Solution.maxArea(intArrayOf(5, 100, 100, 2, 3, 4)) == 100)
    println(Solution.maxArea(intArrayOf(1, 1)) == 1)

}