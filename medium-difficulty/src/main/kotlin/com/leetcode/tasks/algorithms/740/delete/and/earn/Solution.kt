package com.leetcode.tasks.algorithms.`740`.delete.and.earn

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/submissions/
 */
private object Solution {

    val points = mutableMapOf<Int, Int>()
    val cache = mutableMapOf<Int, Int>()

    // Top-Down approach of DP
    fun deleteAndEarn(nums: IntArray): Int {
        points.clear()
        cache.clear()
        var max = -1
        for (num in nums) {
            points[num] = points.getOrDefault(num, 0) + num
            if (num > max) max = num
        }

        return maxPoint(max)
    }

    private fun maxPoint(num: Int): Int {
        if (num == 0) return 0
        if (num == 1) return points.getOrDefault(num, 0)
        cache[num]?.let { return it }

        val gain = points.getOrDefault(num, 0)
        val result = Math.max(maxPoint(num - 1), maxPoint(num - 2) + gain)
        cache[num] = result
        return result
    }

    // Bottom-Up approach of DP
    fun deleteAndEarn1(nums: IntArray): Int {
        val points = mutableMapOf<Int, Int>()
        var max = -1
        for (num in nums) {
            points[num] = points.getOrDefault(num, 0) + num
            if (num > max) max = num
        }

        val dp = mutableMapOf<Int, Int>()
        dp[0] = 0
        dp[1] = points.getOrDefault(1, 0)

        for (i in 2..max) {
            val gain = points.getOrDefault(i, 0)
            dp[i] = Math.max(dp[i - 1]!!, dp[i - 2]!! + gain)
        }
        return dp[max]!!
    }
}

fun main() {

    println(Solution.deleteAndEarn1(intArrayOf(5)) == 5)
    println(Solution.deleteAndEarn1(intArrayOf(3, 4, 2)) == 6)
    println(Solution.deleteAndEarn1(intArrayOf(1, 2, 3, 4)) == 6)
    println(Solution.deleteAndEarn1(intArrayOf(2, 2, 3, 3, 3, 4)) == 9)
    println(Solution.deleteAndEarn1(intArrayOf(8, 9, 9, 9, 10, 10)) == 28)
    println(Solution.deleteAndEarn1(intArrayOf(8, 7, 3, 8, 1, 4, 10, 10, 10, 2)) == 52)
    println(Solution.deleteAndEarn1(intArrayOf(3, 7, 10, 5, 2, 4, 8, 9, 9, 4, 9, 2, 6, 4, 6, 5, 4, 7, 6, 10)) == 66)

//    [7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,7,6,10]
//    [7,10,5,8,9,9,4,9,2,6,4,6,5,7,6,10]
//    [7,10,8,9,9,4,9,2,6,4,6,5,7,6,10]
//    [7,10,8,9,9,4,9,2,6,4,6,7,6,10]
//    [7,10,8,9,9,4,9,6,6,7,6,10]
//    [7,10,8,9,9,9,6,6,7,6,10]
//    [10,8,9,9,9,6,6,6,10]
//    [8,9,9,9,10,10]

//    [8,7,3,8,1,4,10,10,10,2]
//    [1,4,8,7,3,8,2]
//    [1,4,8,3,8,2]
//    [1,4,8,3,2]
//    [1,4,3,2]

}