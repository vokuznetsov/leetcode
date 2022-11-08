package com.leetcode.tasks.algorithms.`766`.toeplitz.matrix

/**
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/
 */

private object Solution {

    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var x = 0
        var y = 0


        // iterate by 0 row
        while (y < matrix[0].size) {
            var next = 0
            var elem = matrix[x][y]
            while (x + next < m && y + next < n) {
                if (elem != matrix[x + next][y + next]) return false
                next++
            }
            y++
        }
        x++
        y = 0

        while (x < m) {
            var next = 0
            var elem = matrix[x][y]
            while (x + next < m && y + next < n) {
                if (elem != matrix[x + next][y + next]) return false
                next++
            }
            x++
            y = 0
        }

        return true
    }

    // the same as previous but more readable solution
    fun isToeplitzMatrix1(matrix: Array<IntArray>): Boolean {
        for (x in 1 until matrix.size) {
            for (y in 1 until matrix[x].size) {
                if (matrix[x - 1][y - 1] != matrix[x][y]) return false
            }
        }

        return true
    }

}

fun main() {

    println(
        Solution.isToeplitzMatrix1(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 1, 2, 3),
                intArrayOf(9, 5, 1, 2)
            )
        )
    )

    println(
        Solution.isToeplitzMatrix1(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 2),
            )
        )
    )
}
