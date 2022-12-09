package com.leetcode.tasks.algorithms.`1704`.determine.`if`.string.halves.are.alike

/**
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 */

private object Solution {

    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

        var start = 0
        var end = s.lastIndex

        var firstHalf = 0
        var secondHalf = 0

        while (start < end) {
            if (vowels.contains(s[start])) firstHalf++
            if (vowels.contains(s[end])) secondHalf++
            start++
            end--
        }

        return firstHalf == secondHalf
    }
}

fun main() {

    println(Solution.halvesAreAlike("book"))
    println(!Solution.halvesAreAlike("textbook"))

}
