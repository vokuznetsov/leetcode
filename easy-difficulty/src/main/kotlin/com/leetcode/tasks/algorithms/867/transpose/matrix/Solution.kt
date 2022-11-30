package com.leetcode.tasks.algorithms.`867`.transpose.matrix

/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 */

private object Solution {

    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix[0].size) { IntArray(matrix.size) }

        for (x in 0..matrix.lastIndex) {
            for (y in 0..matrix[x].lastIndex) {
                result[y][x] = matrix[x][y]
            }
        }

        return result
    }
}

fun main() {

    // right answer but `contentEquals(..)` return incorrect result, 2d dimensional array should compare somehow different
    println(
        Solution.transpose(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            )
        ).contentEquals(
            arrayOf(
                intArrayOf(1, 4, 7),
                intArrayOf(2, 5, 8),
                intArrayOf(3, 6, 9)
            )
        )
    )

    println(
        Solution.transpose(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6)
            )
        ).contentEquals(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 5),
                intArrayOf(3, 6)
            )
        )
    )
}
