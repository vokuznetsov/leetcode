package com.leetcode.tasks.algorithms.`200`.number.of.islands

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */

private data class UnionFind(val grid: Array<CharArray>) {

    val m = grid.size
    val n = grid[0].size

    var count: Int = 0
    private val parent = IntArray(m * n) { 0 }
    private val rank = IntArray(m * n) { 0 }

    init {
        for (i in 0 until m) {
            for (j in 0 until n) {
                val pos = i * n + j
                if (grid[i][j] == '1') {
                    parent[pos] = pos
                    count++
                }
                rank[pos] = 0
            }
        }
    }

    fun find(x: Int): Int {
        return if (parent[x] == x) x
        else {
            parent[x] = find(parent[x])
            parent[x]
        }
    }

    fun union(x: Int, y: Int) {
        val parentX = find(x)
        val parentY = find(y)

        if (parentX != parentY) {
            if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY
            } else if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX
            } else if (rank[parentX] == rank[parentY]) {
                parent[parentY] = parentX
                rank[parentX] += 1
            }
            count--
        }

    }
}

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

private object UnionFindSolution {
    fun numIslands(grid: Array<CharArray>): Int {
        val union = UnionFind(grid)

        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0'
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union.union(i * n + j, (i - 1) * n + j)
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union.union(i * n + j, (i + 1) * n + j)
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union.union(i * n + j, i * n + j - 1)
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union.union(i * n + j, i * n + j + 1)
                    }
                }
            }
        }

        return union.count
    }
}

fun main() {

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '0', '1'),
                charArrayOf('1', '1', '1')
            )
        ) == 1
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '0', '1'),
                charArrayOf('1', '1', '0')
            )
        ) == 2
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        ) == 1
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '0'),
                charArrayOf('0', '1')
            )
        ) == 2
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('0', '0', '1', '0'),
                charArrayOf('0', '0', '0', '1')
            )
        ) == 3
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(

                charArrayOf('1', '0', '0'),
                charArrayOf('0', '1', '1')
            )
        ) == 2
    )

    println(
        UnionFindSolution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        ) == 3
    )

}