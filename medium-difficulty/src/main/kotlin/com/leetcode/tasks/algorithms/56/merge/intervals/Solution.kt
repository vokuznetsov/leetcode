package com.leetcode.tasks.algorithms.`56`.merge.intervals

import java.util.LinkedList

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
private object Solution {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = LinkedList<IntArray>()
        intervals.sortWith(compareBy { it[0] })
        result.add(intervals[0])

        for (i in 1..intervals.lastIndex) {
            val interval = intervals[i]

            if (interval[0] <= result.last[1]) {
                result.last[1] = Math.max(result.last[1], interval[1])
            } else {
                result.add(interval)
            }
        }

        return result.toTypedArray()
    }
}

fun main() {

    println(
        Solution.merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ).contentDeepEquals(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        )
    )

    println(
        Solution.merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        ).contentDeepEquals(
            arrayOf(
                intArrayOf(1, 5)
            )
        )
    )

    println(
        Solution.merge(
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(4, 5)
            )
        ).contentDeepEquals(
            arrayOf(
                intArrayOf(1, 5)
            )
        )
    )
}