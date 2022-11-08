package com.leetcode.tasks.algorithms.`136`.single.number

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */

private object Solution {

    fun singleNumber(nums: IntArray): Int {
        var result = 0

        for (num in nums) {
            result = result.xor(num)
        }

        return result
    }
}

fun main() {

    println(Solution.singleNumber(intArrayOf(2, 2, 1)))
    println(Solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(Solution.singleNumber(intArrayOf(1)))
    println(Solution.singleNumber(intArrayOf(-4)))

}
