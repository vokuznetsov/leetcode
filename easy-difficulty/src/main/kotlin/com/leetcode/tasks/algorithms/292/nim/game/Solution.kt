package com.leetcode.tasks.algorithms.`292`.nim.game

/**
 * 292. Nim Game
 * https://leetcode.com/problems/nim-game/
 */

private object Solution {

    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }

}

fun main() {

    println(Solution.canWinNim(4))
    println(Solution.canWinNim(1))
    println(Solution.canWinNim(2))

}
