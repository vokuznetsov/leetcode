package com.leetcode.tasks.algorithms.`977`.squares.of.a.sorted.array

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
private object Solution {

    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = nums.lastIndex

        var count = nums.lastIndex
        val result = IntArray(nums.size) { 0 }

        while (left <= right) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                result[count--] = nums[right] * nums[right]
                right--
            } else {
                result[count--] = nums[left] * nums[left]
                left++
            }
        }
        return result
    }
}

fun main() {

    println(Solution.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentEquals(intArrayOf(0, 1, 9, 16, 100)))
    println(Solution.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)).contentEquals(intArrayOf(4, 9, 9, 49, 121)))
}
