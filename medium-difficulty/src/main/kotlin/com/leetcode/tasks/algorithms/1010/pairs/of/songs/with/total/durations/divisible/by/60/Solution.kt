package com.leetcode.tasks.algorithms.`1010`.pairs.of.songs.with.total.durations.divisible.by.`60`

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
private object Solution {

    fun numPairsDivisibleBy601(time: IntArray): Int {
        val arr = IntArray(501) { 0 }

        for (i in time) {
            arr[i] += 1
        }

        var count = 0

        for (value in time) {
            arr[value] -= 1
            var diff = Math.abs((value - (value / 60 + 1) * 60))

            while (diff <= 500) {
                count += arr[diff]
                diff += 60
            }
        }

        return count
    }

    // more optimal solution, memory - O(n), space - O(1)
    fun numPairsDivisibleBy60(time: IntArray): Int {
        val percentage = IntArray(60) { 0 }
        var count = 0

        for (value in time) {
            val remains = value % 60
            count += if (remains == 0) percentage[0] else percentage[60 - remains]
            percentage[remains] += 1
        }

        return count
    }

}

fun main() {

    println(Solution.numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)) == 3)
    println(Solution.numPairsDivisibleBy60(intArrayOf(60, 60, 60)) == 3)

}