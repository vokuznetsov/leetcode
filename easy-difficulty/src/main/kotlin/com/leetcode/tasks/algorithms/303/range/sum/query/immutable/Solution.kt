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

    val cache = IntArray(nums.size)

    init {
        cache[0] = nums[0]
        for (i in 1..nums.lastIndex) {
            cache[i] = cache[i - 1] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return cache[right] - cache[left] + nums[left]
    }

}

fun main() {

    val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(numArray.sumRange(0, 2) == 1)
    println(numArray.sumRange(2, 5) == -1)
    println(numArray.sumRange(0, 5) == -3)

}
