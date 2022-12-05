package com.leetcode.tasks.algorithms.`2256`.minimum.average.difference

/**
 * 2256. Minimum Average Difference
 * https://leetcode.com/problems/minimum-average-difference/
 */
private object Solution {

    fun minimumAverageDifference(nums: IntArray): Int {
        var prefixSum: Long = 0

        var sum: Long = 0
        for (num in nums) {
            sum += num
        }

        var minAverageDifference = Long.MAX_VALUE
        var minIndex = -1

        for (index in nums.indices) {
            prefixSum += nums[index]
            val firstTerm = (prefixSum / (index + 1))
            val secondTerm = if (nums.size - index - 1 == 0) 0 else (sum - prefixSum) / (nums.size - index - 1)
            val averageDifference = Math.abs(firstTerm - secondTerm)
            if (minAverageDifference > averageDifference) {
                minAverageDifference = averageDifference
                minIndex = index
            }
        }

        return minIndex
    }
}

fun main() {

    println(Solution.minimumAverageDifference(intArrayOf(2, 5, 3, 9, 5, 3)) == 3)
    println(Solution.minimumAverageDifference(intArrayOf(0)) == 0)

}