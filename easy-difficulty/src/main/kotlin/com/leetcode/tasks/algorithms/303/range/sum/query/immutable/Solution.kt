package com.leetcode.tasks.algorithms.`303`.range.sum.query.immutable

/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */

class NumArray(val nums: IntArray) {

    val result: IntArray = IntArray(nums.size)

    init {
        result[0] = nums[0]
        for (i in 1 until nums.size)
            result[i] = nums[i] + result[i - 1]
    }

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        for (i in left..right)
            sum += nums[i]
        return sum
    }

    // O(1) memory and O(n) space
    fun sumRange1(left: Int, right: Int): Int {
        return if (left == 0) result[right] else result[right] - result[left - 1]
    }

}

fun main() {

    val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(numArray.sumRange1(0, 2) == 1)
    println(numArray.sumRange1(2, 5) == -1)
    println(numArray.sumRange1(0, 5) == -3)

}
