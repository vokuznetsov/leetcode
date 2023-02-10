package com.leetcode.tasks.algorithms.`1200`.minimum.absolute.difference

/**
 * 1200. Minimum Absolute Difference
 * https://leetcode.com/problems/minimum-absolute-difference/
 */

private object Solution {

    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val result = mutableListOf<List<Int>>()
        var minDiff = Int.MAX_VALUE

        for (i in 1..arr.lastIndex) {
            val diff = Math.abs(arr[i - 1] - arr[i])
            if (diff < minDiff) {
                minDiff = diff
                result.clear()
                result.add(listOf(arr[i - 1], arr[i]))
            } else if (diff == minDiff) {
                result.add(listOf(arr[i - 1], arr[i]))
            }
        }

        return result
    }
}

fun main() {

    println(
        Solution.minimumAbsDifference(intArrayOf(4, 2, 1, 3)) == listOf(listOf(1, 2), listOf(2, 3), listOf(3, 4))
    )

    println(
        Solution.minimumAbsDifference(intArrayOf(1, 3, 6, 10, 15)) == listOf(listOf(1, 3))
    )

    println(
        Solution.minimumAbsDifference(intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)) == listOf(
            listOf(-14, -10),
            listOf(19, 23),
            listOf(23, 27)
        )
    )

}
