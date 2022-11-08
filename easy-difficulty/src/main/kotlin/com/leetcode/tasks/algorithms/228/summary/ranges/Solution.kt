package com.leetcode.tasks.algorithms.`228`.summary.ranges

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 */

private object Solution {

    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i <= nums.size - 1) {
            var j = i + 1
            while (j <= nums.size - 1 && nums[j - 1] == nums[j] - 1) {
                j++
            }
            if (j - i > 1) result.add("${nums[i]}->${nums[j - 1]}") else result.add("${nums[j - 1]}")
            i = j
        }

        return result
    }
}

fun main() {

    println(Solution.summaryRanges(intArrayOf()) == emptyList<String>())
    println(Solution.summaryRanges(intArrayOf(1)) == listOf("1"))
    println(Solution.summaryRanges(intArrayOf(1, 3)) == listOf("1", "3"))
    println(Solution.summaryRanges(intArrayOf(0, 1, 2, 3, 5, 7)) == listOf("0->3", "5", "7"))
    println(Solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)) == listOf("0->2", "4->5", "7"))
    println(Solution.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)) == listOf("0", "2->4", "6", "8->9"))
    println(Solution.summaryRanges(intArrayOf(0, 2, 4, 6, 8, 10)) == listOf("0", "2", "4", "6", "8", "10"))

}
