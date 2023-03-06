package com.leetcode.tasks.algorithms.`448`.find.all.numbers.disappeared.`in`.an.array

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

private object Solution {


    // time - O(N), space O(N)
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val temp = IntArray(nums.size) { 0 }

        for (i in 0..nums.lastIndex) {
            temp[nums[i] - 1] = nums[i]
        }

        val result = mutableListOf<Int>()
        for (i in 0..temp.lastIndex) {
            if (temp[i] == 0) result.add(i + 1)
        }

        return result
    }

    fun findDisappearedNumbers1(nums: IntArray): List<Int> {

        for (i in 0..nums.lastIndex) {
            var value = nums[i]
            while (nums[value - 1] != value) {
                val temp = nums[value - 1]
                nums[value - 1] = value
                value = temp
            }
        }

        val result = mutableListOf<Int>()

        for (i in 0..nums.lastIndex) {
            if (nums[i] != i + 1) {
                result.add(i + 1)
            }
        }

        return result
    }
}

fun main() {

    println(Solution.findDisappearedNumbers1(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)) == listOf(5, 6))
    println(Solution.findDisappearedNumbers1(intArrayOf(1, 1)) == listOf(2))

}
