package com.leetcode.tasks.algorithms.`168`.excel.sheet.column.title


/**
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/
 */

private object Solution {

    fun convertToTitle(columnNumber: Int): String {
        var x = columnNumber
        val result = StringBuilder("")

        while (x != 0) {
            x--
            result.append((65 + x % 26).toChar())
            x /= 26
        }

        return result.reverse().toString()
    }
}

fun main() {

    println(Solution.convertToTitle(1) == "A")
    println(Solution.convertToTitle(28) == "AB")
    println(Solution.convertToTitle(51))
    println(Solution.convertToTitle(52))
    println(Solution.convertToTitle(701) == "ZY")

}
