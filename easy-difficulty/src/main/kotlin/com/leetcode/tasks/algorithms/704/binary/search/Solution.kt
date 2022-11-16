package com.leetcode.tasks.algorithms.`704`.binary.search

/**
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/
 */


private object Solution {

    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        var middle: Int

        while (start <= end) {
            middle = start + (end - start) / 2
            if (nums[middle] == target) return middle
            else if (nums[middle] < target) start = middle + 1
            else end = middle - 1
        }

        return -1
    }

}

fun main() {

    println(Solution.search(intArrayOf(-1), 9) == -1)
    println(Solution.search(intArrayOf(-1), -1) == 0)
    println(Solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9) == 4)
    println(Solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2) == -1)

}
