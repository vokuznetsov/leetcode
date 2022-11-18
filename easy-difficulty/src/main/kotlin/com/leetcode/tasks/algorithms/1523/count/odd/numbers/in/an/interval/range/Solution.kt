package com.leetcode.tasks.algorithms.`1523`.count.odd.numbers.`in`.an.interval.range

/**
 * 1523. Count Odd Numbers in an Interval Range
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */

private object Solution {

    fun countOdds(low: Int, high: Int): Int {
        return if (low % 2 == 0 && high % 2 == 0) (high - low) / 2 else (high - low) / 2 + 1
    }

}

fun main() {

    println(Solution.countOdds(3, 7) == 3)
    println(Solution.countOdds(8, 10) == 1)
    println(Solution.countOdds(1, 1) == 1)
    println(Solution.countOdds(0, 1) == 1)
    println(Solution.countOdds(0, 0) == 0)

}
