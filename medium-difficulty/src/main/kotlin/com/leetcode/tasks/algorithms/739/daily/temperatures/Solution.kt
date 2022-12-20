package com.leetcode.tasks.algorithms.`739`.daily.temperatures

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 */
private object Solution {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }

        for (i in 0..temperatures.lastIndex) {
            val temperature = temperatures[i]
            for (j in i + 1..temperatures.lastIndex) {
                if (temperatures[j] > temperature) {
                    result[i] = j - i
                    break
                }
            }
        }

        return result
    }
}

fun main() {

    println(
        Solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
            .contentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0))
    )
    println(Solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)).contentEquals(intArrayOf(1, 1, 1, 0)))
    println(Solution.dailyTemperatures(intArrayOf(30, 60, 90)).contentEquals(intArrayOf(1, 1, 0)))

}