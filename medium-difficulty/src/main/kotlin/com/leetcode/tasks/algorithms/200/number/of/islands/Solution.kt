package com.leetcode.tasks.algorithms.`200`.number.of.islands

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
private object Solution {

    private var count = 0
    private val visitedElement = mutableSetOf<Pair<Int, Int>>()

    fun numIslands1(grid: Array<CharArray>): Int {
        count = 0
        visitedElement.clear()
        val m = grid.lastIndex
        val n = grid[0].lastIndex

        for (x in 0..m) {
            for (y in 0..n) {
                if (grid[x][y] == '0') visitedElement.add(x to y)
                else if (!visitedElement.contains(x to y) && isIsland(x, y, m, n, grid)) {
                    count++
                }
            }
        }

        return count
    }

    private fun isIsland(x: Int, y: Int, m: Int, n: Int, grid: Array<CharArray>): Boolean {
        if (x > m || y > n || x < 0 || y < 0 || grid[x][y] == '0' || visitedElement.contains(x to y)) return true
        else {
            visitedElement.add(x to y)

            return isIsland(x - 1, y, m, n, grid)
                    && isIsland(x + 1, y, m, n, grid)
                    && isIsland(x, y - 1, m, n, grid)
                    && isIsland(x, y + 1, m, n, grid)
        }
    }


    // DFS search, time - O(M×N), space - O(M×N)
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.lastIndex
        val n = grid[0].lastIndex
        var count = 0

        for (x in 0..m)
            for (y in 0..n) {
                if (grid[x][y] == '1') {
                    count++
                    dfs(x, y, grid)
                }
            }

        return count
    }

    private fun dfs(x: Int, y: Int, grid: Array<CharArray>) {
        val m = grid.lastIndex
        val n = grid[0].lastIndex

        if (x > m || y > n || x < 0 || y < 0 || grid[x][y] == '0') return

        grid[x][y] = '0'
        dfs(x - 1, y, grid)
        dfs(x + 1, y, grid)
        dfs(x, y - 1, grid)
        dfs(x, y + 1, grid)
    }
}

fun main() {

    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '0', '1'),
                charArrayOf('1', '1', '1')
            )
        ) == 1
    )


    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '0', '1'),
                charArrayOf('1', '1', '0')
            )
        ) == 2
    )

    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        ) == 1
    )

    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '0'),
                charArrayOf('0', '1')
            )
        ) == 2
    )

    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('0', '0', '1', '0'),
                charArrayOf('0', '0', '0', '1')
            )
        ) == 3
    )

    println(
        Solution.numIslands(
            arrayOf(

                charArrayOf('1', '0', '0'),
                charArrayOf('0', '1', '1')
            )
        ) == 2
    )

    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        ) == 3
    )

}