package com.leetcode.tasks.`119`.pascal.triangle.ii

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */

private object Solution {

    fun getRow(rowIndex: Int): List<Int> {
        val previousRows = mutableListOf<List<Int>>()

        for (i in 0..rowIndex) {
            var row = mutableListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) row.add(1)
                else row.add(previousRows[i - 1][j - 1] + previousRows[i - 1][j])
            }
            if (i == rowIndex) return row else previousRows.add(row)
        }
        return emptyList()
    }
}

fun main() {

    println(Solution.getRow(0) == listOf(1))
    println(Solution.getRow(1) == listOf(1, 1))
    println(Solution.getRow(3) == listOf(1, 3, 3, 1))

}
