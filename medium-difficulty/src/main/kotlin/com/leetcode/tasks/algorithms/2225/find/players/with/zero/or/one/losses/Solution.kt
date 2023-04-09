package com.leetcode.tasks.algorithms.`2225`.find.players.with.zero.or.one.losses

/**
 * 2225. Find Players With Zero or One Losses
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
private object Solution {

    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = mutableListOf<Int>()
        val winnersWithOneLose = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()

        for (match in matches) {
            map[match[0]] = map.getOrDefault(match[0], 0)
            map[match[1]] = map.getOrDefault(match[1], 0) + 1
        }

        for ((key, value) in map) {
            if (value == 0) winners.add(key)
            if (value == 1) winnersWithOneLose.add(key)
        }

        return listOf(winners.sorted(), winnersWithOneLose.sorted())
    }
}

fun main() {

    println(
        Solution.findWinners(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 6),
                intArrayOf(5, 6),
                intArrayOf(5, 7),
                intArrayOf(4, 5),
                intArrayOf(4, 8),
                intArrayOf(4, 9),
                intArrayOf(10, 4),
                intArrayOf(10, 9)
            )
        ) == listOf(listOf(1, 2, 10), listOf(4, 5, 7, 8))
    )

    println(
        Solution.findWinners(
            arrayOf(
                intArrayOf(2, 3),
                intArrayOf(1, 3),
                intArrayOf(5, 4),
                intArrayOf(6, 4)
            )
        ) == listOf(listOf(1, 2, 5, 6), listOf())
    )

}