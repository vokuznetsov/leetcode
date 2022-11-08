package com.leetcode.tasks.algorithms.`67`.add.binary

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 */
private object Solution {

    fun addBinary(a: String, b: String): String {
        var additionalDigit = 0

        val size = if (a.length >= b.length) a.lastIndex else b.lastIndex
        var sb = StringBuilder("")

        val aReversed = a.reversed()
        val bReversed = b.reversed()

        for (i in 0..size) {
            when (aReversed.getOrElse(i) { '0' }.digitToInt()
                    + bReversed.getOrElse(i) { '0' }.toString().toInt()
                    + additionalDigit
            ) {
                0 -> {
                    sb.insert(0, "0")
                    additionalDigit = 0
                }
                1 -> {
                    sb.insert(0, "1")
                    additionalDigit = 0
                }
                2 -> {
                    sb.insert(0, "0")
                    additionalDigit = 1
                }
                3 -> {
                    sb.insert(0, "1")
                    additionalDigit = 1
                }
            }
        }

        if (additionalDigit == 1) sb.insert(0, "1")

        return sb.toString()
    }
}

fun main() {

    println(Solution.addBinary("11", "1") == "100")
    println(Solution.addBinary("10", "0") == "10")
    println(Solution.addBinary("1010", "10110") == "10101")

}
