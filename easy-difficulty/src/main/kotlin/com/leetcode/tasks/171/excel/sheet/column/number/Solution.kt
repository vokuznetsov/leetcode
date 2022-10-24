package com.leetcode.tasks.`171`.excel.sheet.column.number


/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 */

private object Solution {

    fun titleToNumber(columnTitle: String): Int {
        var value = 0
        for ((i, c) in columnTitle.withIndex()) {
            // 64 - because it is the previous char before 'A' in ASCII
            val exp = columnTitle.length - 1 - i
            value += Math.pow(26.0, exp.toDouble()).toInt() * (c.toInt() - 64)
        }

        return value
    }
}

fun main() {

    println(Solution.titleToNumber("A") == 1)
    println(Solution.titleToNumber("AB") == 28)
    println(Solution.titleToNumber("AY") == 51)
    println(Solution.titleToNumber("AZ") == 52)
    println(Solution.titleToNumber("ZY") == 701)
}
