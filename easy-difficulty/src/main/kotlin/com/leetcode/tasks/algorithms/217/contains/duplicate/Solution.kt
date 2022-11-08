package com.leetcode.tasks.algorithms.`217`.contains.duplicate

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */

private object Solution {

    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}

fun main() {

    println(Solution.containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(Solution.containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(Solution.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))

}
