package com.leetcode.tasks.algorithms.`746`.min.cost.climbing.stairs

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */


private object Solution {

    // for Top-Down approach
    var cache = IntArray(1000) { -1 }

    // space O(1), Bottom-Up
    fun minCostClimbingStairs(cost: IntArray): Int {
        var first = cost[0]
        var second = cost[1]

        for (i in 2..cost.lastIndex) {
            val temp = Math.min(first, second) + cost[i]
            if (i != 2) second = first
            first = temp
        }

        return Math.min(first, second)
    }

    // space O(n), Bottom-Up Dynamic Programming
    fun minCostClimbingStairs1(cost: IntArray): Int {
        val dp = IntArray(cost.size)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for (i in 2..cost.lastIndex) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i]
        }

        return Math.min(dp[dp.lastIndex], dp[dp.lastIndex - 1])
    }

    // space O(n), Top-Down Dynamic Programming
    fun minCostClimbingStairs2(cost: IntArray): Int {
        cache = IntArray(1000) { -1 }
        return minCost(cost.size, cost)
    }

    private fun minCost(i: Int, cost: IntArray): Int {
        if (i == 0) return cost[0]
        if (i == 1) return cost[1]

        if (cache[i] > -1) return cache[i]

        val min = Math.min(minCost(i - 1, cost), minCost(i - 2, cost))
        cache[i] = if (i == cost.size) min else min + cost[i]
        return cache[i]
    }

}

fun main() {

    println(Solution.minCostClimbingStairs2(intArrayOf(10, 15, 20)) == 15)
    println(Solution.minCostClimbingStairs2(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)) == 6)
    println(Solution.minCostClimbingStairs2(intArrayOf(10, 15)) == 10)
    println(Solution.minCostClimbingStairs2(intArrayOf(20, 7)) == 7)

}
