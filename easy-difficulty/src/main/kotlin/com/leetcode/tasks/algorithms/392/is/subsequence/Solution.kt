package com.leetcode.tasks.algorithms.`392`.`is`.subsequence

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */


private object Solution {

    fun isSubsequence(s: String, t: String): Boolean {
        val charPositions = mutableMapOf<Char, MutableList<Int>>()

        for ((index, char) in t.withIndex()) {
            charPositions.getOrPut(char) { mutableListOf() }.add(index)
        }

        val charLastPosition = mutableMapOf<Char, Int>()
        var lastPosition = 0

        for (c in s) {
            var nextIndexInList = charLastPosition.getOrDefault(c, -1) + 1
            if (charPositions[c] == null || charPositions[c]!!.lastIndex < nextIndexInList) return false

            while (charPositions[c]?.get(nextIndexInList)!! < lastPosition) {
                if (nextIndexInList == charPositions[c]!!.lastIndex) return false
                nextIndexInList++
            }

            charLastPosition[c] = nextIndexInList
            lastPosition = charPositions[c]?.get(nextIndexInList)!!
        }
        return true
    }

    // elegant solution for only one string `s` as parameter
    fun isSubsequence1(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0

        while (tIndex < t.length && sIndex < s.length) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
                tIndex++
            } else {
                tIndex++
            }
        }

        return sIndex == s.length
    }
}

fun main() {

    println(Solution.isSubsequence1("ab", "baab"))
    println(!Solution.isSubsequence1("aaaaaa", "bbaaaa"))
    println(!Solution.isSubsequence1("b", "c"))
    println(Solution.isSubsequence1("", "ahbgdc"))
    println(Solution.isSubsequence1("", ""))
    println(Solution.isSubsequence1("abc", "ahbgdc"))
    println(!Solution.isSubsequence1("acb", "ahbgdc"))
    println(!Solution.isSubsequence1("axc", "ahbgdc"))
    println(Solution.isSubsequence1("leeeeetcode", "yylyyeeeeeyytyycyyoyydyyeyy"))
}
