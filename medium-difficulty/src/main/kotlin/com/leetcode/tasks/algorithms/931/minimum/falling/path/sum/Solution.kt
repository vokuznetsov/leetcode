package com.leetcode.tasks.algorithms.`931`.minimum.falling.path.sum

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
private object Solution {

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        for (x in 1..matrix.lastIndex) {
            for (y in 0..matrix.lastIndex) {
                val path1 = if (y > 0) matrix[x - 1][y - 1] + matrix[x][y] else Int.MAX_VALUE
                val path2 = matrix[x - 1][y] + matrix[x][y]
                val path3 = if (y < matrix.lastIndex) matrix[x - 1][y + 1] + matrix[x][y] else Int.MAX_VALUE

                matrix[x][y] = minOf(path1, path2, path3)
            }
        }

        var min = Int.MAX_VALUE
        for (i in matrix.last()) {
            min = Math.min(min, i)
        }

        return min
    }
}

fun main() {

    println(
        Solution.minFallingPathSum(
            arrayOf(
                intArrayOf(2, 1, 3),
                intArrayOf(6, 5, 4),
                intArrayOf(7, 8, 9)
            )
        ) == 13
    )

    println(
        Solution.minFallingPathSum(
            arrayOf(
                intArrayOf(-19, 57),
                intArrayOf(-40, -5)
            )
        ) == -59
    )

    println(
        Solution.minFallingPathSum(
            arrayOf(
                intArrayOf(1, 10, 10, 10, 10),
                intArrayOf(1, 10, 10, 10, 10),
                intArrayOf(1, 10, 10, 10, 10),
                intArrayOf(1, 10, 10, 10, 10),
                intArrayOf(100, 10, 10, 10, 1),
            )
        ) == 14
    )

    println(
        Solution.minFallingPathSum(
            arrayOf(
                intArrayOf(100, -42, -46, -41),
                intArrayOf(31, 97, 10, -10),
                intArrayOf(-58, -51, 82, 89),
                intArrayOf(51, 81, 69, -51),
            )
        ) == -36
    )
}