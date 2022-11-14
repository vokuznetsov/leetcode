package com.leetcode.tasks.algorithms.`405`.convert.a.number.to.`hexadecimal `

/**
 * 405. Convert a Number to Hexadecimal
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */


private object Solution {

    fun toHex(num: Int): String {
        val deque = ArrayDeque<Int>()
        var value = num

        var additionalDigit = if (num < 0) 1 else 0
        while (value != 0) {
            val reminder = Math.abs(value % 16)
            if (reminder == 0 && num < 0 && additionalDigit == 1) {
                additionalDigit = 1
                deque.addFirst(15)
            } else {
                deque.addFirst(reminder - additionalDigit)
                additionalDigit = 0
            }

            value /= 16
        }

        if (num < 0) {
            while (deque.size < 8) {
                if (additionalDigit == 1) deque.addFirst(additionalDigit) else deque.addFirst(0)
                additionalDigit = 0
            }
        }

        val sb = StringBuilder()

        for (i in deque) {
            val hexDigit = when (val temp = if (num >= 0) i else 15 - i) {
                15 -> "f"
                14 -> "e"
                13 -> "d"
                12 -> "c"
                11 -> "b"
                10 -> "a"
                else -> temp.toString()
            }
            sb.append(hexDigit)
        }

        return if (deque.isEmpty()) "0" else sb.toString()
    }

    // explanation
    fun toHex1(num: Int): String {
        val map = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

        var value = num
        if (value == 0) return "0"
        var result = ""
        while (value != 0) {
            result = map[value and 15].toString() + result
            value = value ushr 4
        }
        return result
    }
}

fun main() {

    println(Solution.toHex1(0) == "0")
    println(Solution.toHex1(26) == "1a")
    println(Solution.toHex1(-1) == "ffffffff")
    println(Solution.toHex1(-7) == "fffffff9")
    println(Solution.toHex1(-111110) == "fffe4dfa")
    println(Solution.toHex1(-10000) == "ffffd8f0")
    println(Solution.toHex1(-100000) == "fffe7960")
    println(Solution.toHex1(-2147483648) == "80000000")

    // convert to binary String
    // if value is negative we get 2's complement representation (without `-` before value)
    // Integer.toBinaryString(-111110)

}
