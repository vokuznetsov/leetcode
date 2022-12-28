package com.leetcode.tasks.algorithms.`2279`.maximum.bags.with.full.capacity.of.rocks

/**
 * 2279. Maximum Bags With Full Capacity of Rocks
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 */
private object Solution {

    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        for (i in 0..capacity.lastIndex) {
            capacity[i] = capacity[i] - rocks[i]
        }

        capacity.sort()
        var count = 0
        var additional = additionalRocks
        for (value in capacity) {
            if (additional - value < 0) return count else {
                additional -= value
                count++
            }
        }
        return count
    }
}

fun main() {

    println(Solution.maximumBags(intArrayOf(2, 3, 4, 5), intArrayOf(1, 2, 4, 4), 2) == 3)
    println(Solution.maximumBags(intArrayOf(10, 2, 2), intArrayOf(2, 2, 0), 100) == 3)
    println(Solution.maximumBags(intArrayOf(10), intArrayOf(10), 100) == 1)
    println(Solution.maximumBags(intArrayOf(10), intArrayOf(2), 100) == 1)
    println(Solution.maximumBags(intArrayOf(10), intArrayOf(2), 0) == 0)

}