package com.leetcode.tasks.algorithms.`53`.maximum.subarray

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
private object Solution {

    // time - O(n^2), space - O(1)
    fun maxSubArray1(nums: IntArray): Int {

        var result = Int.MIN_VALUE

        for (i in 0..nums.lastIndex) {
            val sum = subArray(i, nums)
            if (sum > result) result = sum
        }

        return result
    }


    private fun subArray(startPosition: Int, nums: IntArray): Int {
        var left = startPosition - 1
        var right = startPosition + 1

        var maxLeftSubarraySum = 0
        var currentLeftSum = 0
        var maxRightSubarraySum = 0
        var currentRightSum = 0

        while (left >= 0 || right < nums.size) {
            if (left >= 0) {
                currentLeftSum += nums[left]
                maxLeftSubarraySum = Math.max(maxLeftSubarraySum, currentLeftSum)
                left--
            }

            if (right < nums.size) {
                currentRightSum += nums[right]
                maxRightSubarraySum = Math.max(maxRightSubarraySum, currentRightSum)
                right++
            }
        }

        return Math.max(nums[startPosition], nums[startPosition] + maxLeftSubarraySum + maxRightSubarraySum)
    }

    // time - O(n^2), space - O(1)
    fun maxSubArray(nums: IntArray): Int {
        var maxSubarraySum = nums[0]
        var currentSubarraySum = nums[0]

        for (i in 1..nums.lastIndex) {
            currentSubarraySum = Math.max(currentSubarraySum, 0) + nums[i]
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum)
        }

        return maxSubarraySum
    }

    // time - O(N * logN), space - O(logN)
    // Divide and Conquer algorithm
    fun maxSubArrayOtherApproach(nums: IntArray): Int {
        return bestSubArray(0, nums.lastIndex, nums)
    }

    private fun bestSubArray(start: Int, end: Int, nums: IntArray): Int {
        if (start > end) return Int.MIN_VALUE

        var bestLeftArray = 0
        var currentLeftArray = 0
        var bestRightArray = 0
        var currentRightArray = 0

        val middle = (end - start) / 2 + start

        for (i in middle - 1 downTo start) {
            currentLeftArray += nums[i]
            bestLeftArray = Math.max(bestLeftArray, currentLeftArray)
        }

        for (i in middle + 1..end) {
            currentRightArray += nums[i]
            bestRightArray = Math.max(bestRightArray, currentRightArray)
        }

        val allArray = bestLeftArray + nums[middle] + bestRightArray

        val bestLeftPart = bestSubArray(start, middle - 1, nums)
        val bestRightPart = bestSubArray(middle + 1, end, nums)

        return Math.max(allArray, Math.max(bestLeftPart, bestRightPart))
    }

}

fun main() {

    println(Solution.maxSubArrayOtherApproach(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)) == 6)
    println(Solution.maxSubArrayOtherApproach(intArrayOf(1)) == 1)
    println(Solution.maxSubArrayOtherApproach(intArrayOf(5, 4, -1, 7, 8)) == 23)

}