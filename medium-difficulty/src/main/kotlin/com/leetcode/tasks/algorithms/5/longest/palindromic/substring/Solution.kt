package com.leetcode.tasks.algorithms.`5`.longest.palindromic.substring

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
private object Solution {

    fun longestPalindrome1(s: String): String {
        var maxPalindrome = s[0].toString()

        val map = mutableMapOf<Char, MutableList<Int>>()
        for ((index, char) in s.withIndex()) {
            val list = map.getOrDefault(char, mutableListOf())
            list.add(index)
            map[char] = list
        }

        for ((c, indexList) in map) {
            if (indexList.size > 1 && maxPalindrome.lastIndex < indexList[indexList.lastIndex] - indexList[0]) {
                for (i in 0 until indexList.lastIndex) {
                    for (j in indexList.lastIndex downTo 1) {
                        val startPosition = indexList[i]
                        val endPosition = indexList[j]
                        if (maxPalindrome.lastIndex < endPosition - startPosition
                            && isPalindrome(s, startPosition, endPosition)
                        ) {
                            maxPalindrome = s.substring(startPosition, endPosition + 1)
                        }
                    }
                }
            }
        }

        return maxPalindrome
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var x = start
        var y = end
        while (x < y) {
            if (s[x] != s[y]) return false
            x++
            y--
        }
        return true
    }

    // time - O(n2), space - O(1)
    fun longestPalindrome(s: String): String {
        var palindrome = s[0].toString()
        for (i in 0 until s.lastIndex) {
            val len1 = palindromeLength(i, i, s)
            val len2 = palindromeLength(i, i + 1, s)
            val max = Math.max(len1, len2)

            if (max > palindrome.length) {
                val start = i - ((max - 1) / 2)
                val end = i + max / 2 + 1
                palindrome = s.substring(start, end)
            }
        }

        return palindrome
    }

    private fun palindromeLength(left: Int, right: Int, s: String): Int {
        var l = left
        var r = right

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        return r - l - 1
    }
}

fun main() {

    println(Solution.longestPalindrome("babad") == "bab" || Solution.longestPalindrome("babad") == "aba")
    println(Solution.longestPalindrome("cbbd") == "bb")
    println(Solution.longestPalindrome("s") == "s")

    println(
        Solution.longestPalindrome(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        ) == "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    )

}