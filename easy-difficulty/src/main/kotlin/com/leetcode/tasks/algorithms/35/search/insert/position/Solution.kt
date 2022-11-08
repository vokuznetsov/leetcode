package com.leetcode.tasks.`35`.search.insert.position

import kotlin.math.roundToInt

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
private object Solution {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var previous = nums.size - 1
        var vertex = nums.size / 2

        do {
            if (nums[vertex] == target) return vertex
            else if (nums[vertex] < target) {
                vertex += ((previous - vertex) / 2.0).roundToInt()
            } else {
                previous = vertex
                vertex /= 2
            }
        } while (vertex < previous)

        return if (nums[vertex] < target) vertex + 1 else vertex
    }
}

fun main() {

    println(Solution.searchInsert(intArrayOf(1), 0) == 0)
    println(Solution.searchInsert(intArrayOf(1), 1) == 0)
    println(Solution.searchInsert(intArrayOf(1), 3) == 1)
    println(Solution.searchInsert(intArrayOf(1, 3), 3) == 1)
    println(Solution.searchInsert(intArrayOf(1, 3), 4) == 2)
    println(Solution.searchInsert(intArrayOf(1, 3), 0) == 0)
    println(Solution.searchInsert(intArrayOf(1, 3, 5, 6), 0) == 0)
    println(Solution.searchInsert(intArrayOf(1, 3, 5, 6), 5) == 2)
    println(Solution.searchInsert(intArrayOf(1, 3, 5, 6), 2) == 1)
    println(Solution.searchInsert(intArrayOf(1, 3, 5, 6), 7) == 4)
    println(Solution.searchInsert(intArrayOf(1, 2, 4, 6, 8, 9, 10), 5) == 3)
    println(Solution.searchInsert(intArrayOf(1, 2, 4, 6, 8, 9, 10), 10) == 6)
    println(Solution.searchInsert(intArrayOf(1, 2, 4, 6, 8, 9, 10), 15) == 7)

}
