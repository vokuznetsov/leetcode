package com.leetcode.tasks.algorithms.`980`.unique.paths.iii


/**
 * 980. Unique Paths III
 * https://leetcode.com/problems/unique-paths-iii/
 */

private object Solution {

    private var count = 0
    private var numberOfEmptySquares = 0
    private var m = 0
    private var n = 0

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        count = 0
        numberOfEmptySquares = 0
        var startX = 0
        var startY = 0

        for (i in 0..grid.lastIndex) {
            for (j in 0..grid.first().lastIndex) {
                if (grid[i][j] == 1) {
                    startX = i
                    startY = j
                }
                if (grid[i][j] == 0) numberOfEmptySquares++
            }
        }
        m = grid.lastIndex
        n = grid.first().lastIndex

        findPath(grid, startX, startY, HashSet())

        return count
    }

    private fun findPath(grid: Array<IntArray>, x: Int, y: Int, visitedEmptySquares: HashSet<Pair<Int, Int>>) {
        if (x > m || y > n
            || x < 0 || y < 0
            || visitedEmptySquares.contains(Pair(x, y))
            || grid[x][y] == -1
            || (grid[x][y] == 2 && visitedEmptySquares.size - 1 != numberOfEmptySquares)
        ) return
        else if (grid[x][y] == 2 && visitedEmptySquares.size - 1 == numberOfEmptySquares) {
            count++
            return
        } else {
            visitedEmptySquares.add(Pair(x, y))
            findPath(grid, x, y + 1, HashSet(visitedEmptySquares))
            findPath(grid, x + 1, y, HashSet(visitedEmptySquares))
            findPath(grid, x - 1, y, HashSet(visitedEmptySquares))
            findPath(grid, x, y - 1, HashSet(visitedEmptySquares))
        }
    }
}

fun main() {


    println(
        Solution.uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 2, -1)
            )
        ) == 2
    )

    println(
        Solution.uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 2)
            )
        ) == 4
    )

    println(
        Solution.uniquePathsIII(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(2, 0)
            )
        ) == 0
    )
}