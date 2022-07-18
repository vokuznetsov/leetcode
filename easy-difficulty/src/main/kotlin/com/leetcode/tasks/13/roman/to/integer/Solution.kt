package com.leetcode.tasks.`13`.roman.to.integer

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */
private object Solution {

    fun romanToInt1(s: String): Int {
        val romanLettersMap = mapOf(
            "I" to 1,
            "V" to 5,
            "X" to 10,
            "L" to 50,
            "C" to 100,
            "D" to 500,
            "M" to 1000
        )
        val romanCombinationMap = mapOf(
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
        )

        val first = romanCombinationMap.entries.fold(s) { acc, entry -> acc.replace(entry.key, "${entry.value} ") }
        val second = romanLettersMap.entries.fold(first) { acc, entry -> acc.replace(entry.key, "${entry.value} ") }

        return second.trim().split(" ").map { it.toInt() }.sum()
    }

    fun romanToInt2(s: String): Int {
        val romanLettersMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        val romanCombinationMap = mapOf(
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
        )

        var sum = 0
        var index = 0

        while (index < s.length) {
            if (index + 1 < s.length) {
                val combination = romanCombinationMap["${s[index]}${s[index + 1]}"]

                if (combination == null) {
                    sum += romanLettersMap[s[index]]!!
                    index += 1
                } else {
                    index += 2
                    sum += combination
                }
            } else {
                sum += romanLettersMap[s[index]]!!
                index += 1
            }
        }

        return sum
    }

    fun romanToInt3(s: String): Int {
        var sum = 0
        var last: Char? = null

        for (c in s) {
            when (c) {
                'I' -> sum += 1
                'V' -> sum += if (last == 'I') 4 - 1 else 5
                'X' -> sum += if (last == 'I') 9 - 1 else 10
                'L' -> sum += if (last == 'X') 40 - 10 else 50
                'C' -> sum += if (last == 'X') 90 - 10 else 100
                'D' -> sum += if (last == 'C') 400 - 100 else 500
                'M' -> sum += if (last == 'C') 900 - 100 else 1000
            }
            last = c
        }

        return sum
    }
}

fun main() {

    println(Solution.romanToInt3(s = "III") == 3)
    println(Solution.romanToInt3(s = "LVIII") == 58)
    println(Solution.romanToInt3(s = "CMXCIV") == 994)
    println(Solution.romanToInt3(s = "MCMXCIV") == 1994)

}