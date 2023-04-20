package com.leetcode.tasks.algorithms.`1496`.path.crossing

/**
 * 1496. Path Crossing
 * https://leetcode.com/problems/path-crossing/
 */

private object Solution {

    fun isPathCrossing(path: String): Boolean {
        val map = mutableMapOf<Int, MutableSet<Int>>()
        var x = 0
        var y = 0

        map[0] = mutableSetOf(0)

        for (c in path) {
            when (c) {
                'N' -> y += 1
                'S' -> y -= 1
                'E' -> x += 1
                'W' -> x -= 1
                else -> return false
            }

            val set = map.getOrDefault(x, mutableSetOf())
            if (set.contains(y)) return true
            else set.add(y)

            map[x] = set
        }

        return false
    }
}

fun main() {

    println(!Solution.isPathCrossing("NES"))
    println(Solution.isPathCrossing("NESWW"))
    println(!Solution.isPathCrossing("NNWW"))
    println(Solution.isPathCrossing("NESW"))

}
