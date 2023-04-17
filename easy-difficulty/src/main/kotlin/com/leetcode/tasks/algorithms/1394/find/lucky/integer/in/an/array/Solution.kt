package com.leetcode.tasks.algorithms.`1394`.find.lucky.integer.`in`.an.array

/**
 * 1394. Find Lucky Integer in an Array
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */

private object Solution {

    fun findLucky(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (value in arr) {
            map[value] = map.getOrDefault(value, 0) + 1
        }

        var ans = -1
        for ((key, value) in map) {
            if (key == value) ans = Math.max(ans, value)
        }

        return ans
    }
}

fun main() {

    println(Solution.findLucky(intArrayOf(2, 2, 3, 4)) == 2)
    println(Solution.findLucky(intArrayOf(1, 2, 2, 3, 3, 3)) == 3)
    println(Solution.findLucky(intArrayOf(2, 2, 2, 3, 3)) == -1)

}
