package com.leetcode.tasks.algorithms.`1512`.number.of.good.pairs

/**
 * 1512. Number of Good Pairs
 * https://leetcode.com/problems/destination-city/
 */

private object Solution {

    fun numIdenticalPairs(nums: IntArray): Int {
        var ans = 0
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            val occurrence = map.getOrDefault(num, 0)
            map[num] = occurrence + 1
            if (occurrence != 0) ans += occurrence
        }

        return ans
    }
}

fun main() {

    println(Solution.numIdenticalPairs(intArrayOf(1, 2, 3, 1, 1, 3)) == 4)
    println(Solution.numIdenticalPairs(intArrayOf(1, 1, 1, 1)) == 6)
    println(Solution.numIdenticalPairs(intArrayOf(1, 2, 3)) == 0)

}
