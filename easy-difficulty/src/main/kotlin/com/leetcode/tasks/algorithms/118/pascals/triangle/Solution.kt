package com.leetcode.tasks.`118`.pascals.triangle

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */

private object Solution {

    fun generate(numRows: Int): List<List<Int>> {
        val triangle = mutableListOf<List<Int>>()

        for (i in 0 until numRows) {
            val row = mutableListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) row.add(j, 1)
                else row.add(j, triangle[i - 1][j - 1] + triangle[i - 1][j])
            }
            triangle.add(row)
        }

        return triangle
    }
}

fun main() {

    println(Solution.generate(1))
    println(Solution.generate(5))

}
