package com.leetcode.tasks.algorithms.`886`.possible.bipartition

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/
 */
private object Solution {

    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val adj = mutableMapOf<Int, MutableList<Int>>()
        for (dislike in dislikes) {
            val first = dislike[0]
            val second = dislike[1]
            adj.computeIfAbsent(first) { mutableListOf() }.add(second)
            adj.computeIfAbsent(second) { mutableListOf() }.add(first)
        }

        val colors = IntArray(n + 1) { -1 }

        for (i in 1..colors.lastIndex) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, adj, colors)) return false
            }
        }

        return true
    }

    private fun dfs(i: Int, nodeColor: Int, adj: MutableMap<Int, MutableList<Int>>, colors: IntArray): Boolean {
        colors[i] = nodeColor
        if (adj.containsKey(i)) {
            for (neighbor in adj[i]!!) {
                if (colors[neighbor] == colors[i])
                    return false
                else if (colors[neighbor] == -1) {
                    dfs(neighbor, 1 - nodeColor, adj, colors)
                }
            }
        }
        return true
    }
}

fun main() {

    println(Solution.possibleBipartition(4, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))))
    println(!Solution.possibleBipartition(4, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))))
    println(
        !Solution.possibleBipartition(
            5,
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(1, 5))
        )
    )
}