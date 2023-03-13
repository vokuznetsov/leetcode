package com.leetcode.tasks.algorithms.`12`.integer.to.roman

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman
 */
private object Solution {

    val map = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
//    ).toSortedMap { a, b -> b.compareTo(a) }
    ).toSortedMap(Comparator { o1, o2 -> o2.compareTo(o1) })


    fun intToRoman(num: Int): String {
        var value = num
        val sb = StringBuilder()

        while (value != 0) {
            val divider = findClosestNumber(value)
            var times = value / divider
            value %= divider

            while (times > 0) {
                sb.append(map[divider])
                times--
            }
        }

        return sb.toString()
    }

    private fun findClosestNumber(num: Int) = map.keys.first { num >= it }
}

fun main() {

    println(Solution.intToRoman(1) == "I")
    println(Solution.intToRoman(3) == "III")
    println(Solution.intToRoman(58) == "LVIII")
    println(Solution.intToRoman(1994) == "MCMXCIV")


}