package com.leetcode.tasks.algorithms.`2389`.longest.subsequence.with.limited.sum

/**
 * 2235. Add Two Integers
 * https://leetcode.com/problems/add-two-integers/
 */

private object Solution {

    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        nums.sort()

        val result = IntArray(queries.size)

        for (i in 0..queries.lastIndex) {
            val elem = queries[i]
            var sum = 0
            var count = 0

            for (j in 0..nums.lastIndex) {
                if (sum + nums[j] > elem) break
                else {
                    sum += nums[j]
                    count++
                }
            }
            result[i] = count
        }

        return result
    }
}

fun main() {

    println(Solution.answerQueries(intArrayOf(4, 5, 2, 1), intArrayOf(3, 10, 21)).contentEquals(intArrayOf(2, 3, 4)))
    println(Solution.answerQueries(intArrayOf(2, 3, 4, 5), intArrayOf(1)).contentEquals(intArrayOf(0)))

}
