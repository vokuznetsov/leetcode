package com.leetcode.tasks.algorithms.`1695`.maximum.erasure.value

/**
 * 1695. Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/
 */
private object Solution {

    // Two pointers approach
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var ans = 0
        var left = 0
        var curr = 0
        var set = mutableSetOf<Int>()

        for (num in nums) {
            while (set.contains(num)) {
                curr -= nums[left]
                set.remove(nums[left++])
            }
            curr += num
            ans = Math.max(ans, curr)
            set.add(num)
        }

        return ans
    }

    // prefix sum + HashMap
    fun maximumUniqueSubarray1(nums: IntArray): Int {
        var start = 0
        var ans = 0
        var curr: Int
        val lastIndexMap = mutableMapOf<Int, Int>()
        val prefixSum = IntArray(nums.size + 1) { 0 }

        for (i in 0..nums.lastIndex) {
            val elem = nums[i]
            prefixSum[i + 1] = prefixSum[i] + elem

            if (lastIndexMap.containsKey(elem)) {
                start = Math.max(start, lastIndexMap.getOrDefault(elem, -1) + 1)
            }

            curr = prefixSum[i + 1] - prefixSum[start]
            ans = Math.max(ans, curr)

            lastIndexMap[elem] = i
        }

        return ans
    }

}

fun main() {

    println(Solution.maximumUniqueSubarray1(intArrayOf(4, 2, 4, 5, 6)) == 17)
    println(Solution.maximumUniqueSubarray1(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)) == 8)
}