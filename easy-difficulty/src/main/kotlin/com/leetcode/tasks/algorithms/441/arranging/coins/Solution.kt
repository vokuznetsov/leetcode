package com.leetcode.tasks.algorithms.`441`.arranging.coins

/**
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 */


private object Solution {

    fun arrangeCoins(n: Int): Int {
        var value = n
        var rows = 1

        while (rows <= value) {
            value -= rows
            rows++
        }

        return rows-1
    }
}

fun main() {

    println(Solution.arrangeCoins(1) == 1)
    println(Solution.arrangeCoins(5) == 2)
    println(Solution.arrangeCoins(8) == 3)

}
