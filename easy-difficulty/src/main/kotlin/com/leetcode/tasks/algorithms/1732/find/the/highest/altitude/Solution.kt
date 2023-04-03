package com.leetcode.tasks.algorithms.`1732`.find.the.highest.altitude

/**
 * 1732. Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
private object Solution {

    fun largestAltitude(gain: IntArray): Int {
        var ans = 0
        var sum = 0

        for (i in 0..gain.lastIndex) {
            sum += gain[i]
            ans = Math.max(ans, sum)
        }

        return ans
    }
}

fun main() {

    println(Solution.largestAltitude(intArrayOf(-5, 1, 5, 0, -7)) == 1)
    println(Solution.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)) == 0)

}
