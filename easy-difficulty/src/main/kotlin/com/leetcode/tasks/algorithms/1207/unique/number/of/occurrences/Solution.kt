package com.leetcode.tasks.algorithms.`1207`.unique.number.of.occurrences

/**
 * 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */

private object Solution {

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        val set = mutableSetOf<Int>()

        for (i in arr) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        for ((_, value) in map) {
            if (set.contains(value)) return false
            else set.add(value)
        }

        return true
    }
}

fun main() {

    println(Solution.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    println(!Solution.uniqueOccurrences(intArrayOf(1, 2)))
    println(Solution.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)))

}
