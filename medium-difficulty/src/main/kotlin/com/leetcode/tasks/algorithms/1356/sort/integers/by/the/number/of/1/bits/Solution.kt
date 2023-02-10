package com.leetcode.tasks.algorithms.`1356`.sort.integers.by.the.number.of.`1`.bits

/**
 * 1356. Sort Integers by The Number of 1 Bits
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */

private object Solution {

    fun sortByBits(arr: IntArray): IntArray {
        val map = mutableMapOf<Int, MutableList<Int>>()

        for (value in arr) {
            val oneCount = Integer.bitCount(value)
            val list = map.getOrDefault(oneCount, mutableListOf())
            list.add(value)
            map[oneCount] = list
        }

        return map.entries.sortedBy { (key, _) -> key }.map { it.value }
            .map {
                it.sort()
                it
            }.flatten().toIntArray()
    }
}

fun main() {

    println(
        Solution.sortByBits(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)).contentEquals(intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7))
    )

    println(
        Solution.sortByBits(intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1))
            .contentEquals(intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024))
    )

}