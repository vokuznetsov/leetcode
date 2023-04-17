package com.leetcode.tasks.algorithms.`1748`.sum.of.unique.elements

/**
 * 1748. Sum of Unique Elements
 * https://leetcode.com/problems/sum-of-unique-elements/
 */
private object Solution {

    fun sumOfUnique(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        var ans = 0
        for ((key, value) in map) {
            if (value == 1) ans += key
        }
        return ans
    }
}

fun main() {

    println(Solution.sumOfUnique(intArrayOf(1, 2, 3, 2)) == 4)
    println(Solution.sumOfUnique(intArrayOf(1, 1, 1, 1, 1)) == 0)
    println(Solution.sumOfUnique(intArrayOf(1, 2, 3, 4, 5)) == 15)

}
