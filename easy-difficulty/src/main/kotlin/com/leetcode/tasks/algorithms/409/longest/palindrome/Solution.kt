package com.leetcode.tasks.algorithms.`409`.longest.palindrome

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 */


private object Solution {

    fun longestPalindrome(s: String): Int {
        if (s.length == 1) return 1
        val letterAppearanceMap = mutableMapOf<Char, Int>()

        for (c in s) {
            letterAppearanceMap[c] = letterAppearanceMap.getOrDefault(c, 0) + 1
        }

        var result = 0
        var odd = false
        for ((_, value) in letterAppearanceMap) {
            result += if (value % 2 == 1) {
                odd = true
                value - 1
            } else value
        }

        return if (odd) result + 1 else result
    }
}

fun main() {

    println(Solution.longestPalindrome("abccccdd") == 7)
    println(Solution.longestPalindrome("a") == 1)


}
