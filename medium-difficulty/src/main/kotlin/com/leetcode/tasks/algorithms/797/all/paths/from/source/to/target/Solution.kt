package com.leetcode.tasks.algorithms.`797`.all.paths.from.source.to.target

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
private object Solution {

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = resultPath(graph, 0)
        result.forEach { it.reverse() }
        return result
    }

    private fun resultPath(
        graph: Array<IntArray>,
        index: Int
    ): MutableList<MutableList<Int>> {
        if (index == graph.lastIndex) return mutableListOf(mutableListOf(index))
        if (graph[index].isEmpty()) return mutableListOf()

        val result: MutableList<MutableList<Int>> = mutableListOf()
        for (nextStep in graph[index]) {
            val path = resultPath(graph, nextStep)
            path.forEach { it.add(index) }
            result.addAll(path)
        }
        return result
    }

}

fun main() {

    println(
        Solution.allPathsSourceTarget(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3),
                intArrayOf(3),
                intArrayOf()
            )
        ) == listOf(
            listOf(0, 1, 3),
            listOf(0, 2, 3)
        )
    )

    println(
        Solution.allPathsSourceTarget(
            arrayOf(
                intArrayOf(4, 3, 1),
                intArrayOf(3, 2, 4),
                intArrayOf(3),
                intArrayOf(4),
                intArrayOf()
            )
        ) == listOf(
            listOf(0, 4),
            listOf(0, 3, 4),
            listOf(0, 1, 3, 4),
            listOf(0, 1, 2, 3, 4),
            listOf(0, 1, 4)
        )
    )
}