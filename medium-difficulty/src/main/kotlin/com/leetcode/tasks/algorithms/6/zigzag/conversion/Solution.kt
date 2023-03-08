package com.leetcode.tasks.algorithms.`6`.zigzag.conversion

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 */
private object Solution {

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val sbs = List(numRows) { StringBuilder() }

        var downDirection = true
        var lastIndex = -1

        for (char in s) {
            lastIndex = getStringNumber(downDirection, lastIndex)
            val sb = sbs.get(lastIndex)
            sb.append(char)

            if (lastIndex == numRows - 1) downDirection = false
            else if (lastIndex == 0) downDirection = true
        }

        return sbs.joinToString(separator = "", transform = { sb -> sb.toString() })
    }

    private fun getStringNumber(direction: Boolean, lastValue: Int): Int =
        if (direction) lastValue + 1 else lastValue - 1


}

fun main() {

    println(Solution.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
    println(Solution.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
    println(Solution.convert("ABC", 2) == "ACB")
    println(Solution.convert("QWERTY", 1) == "QWERTY")

}