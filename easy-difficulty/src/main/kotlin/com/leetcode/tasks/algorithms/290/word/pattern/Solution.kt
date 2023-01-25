package com.leetcode.tasks.algorithms.`290`.word.pattern

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */

private object Solution {

    fun wordPattern(pattern: String, s: String): Boolean {
        val arr = MutableList(26) { "" }
        var wordStartIndex = 0

        for (c in pattern) {
            if (wordStartIndex >= s.length) return false

            var wordEndIndex = wordStartIndex
            while (wordEndIndex != s.length && s[wordEndIndex] != ' ') {
                wordEndIndex++
            }

            val word = s.substring(wordStartIndex, wordEndIndex)
            wordStartIndex = if (wordEndIndex == s.length) wordEndIndex else wordEndIndex + 1

            if (arr[c - 'a'].isEmpty()) {
                if (arr.contains(word))
                    return false
                else arr[c - 'a'] = word
            } else if (arr[c - 'a'] != word) return false
        }

        return wordStartIndex == s.length
    }

}

fun main() {

    println(Solution.wordPattern("abba", "dog cat cat dog"))
    println(!Solution.wordPattern("abba", "dog dog dog dog"))
    println(!Solution.wordPattern("abba", "dog cat cat fish"))
    println(!Solution.wordPattern("aaaa", "dog cat cat dog"))
    println(!Solution.wordPattern("aaa", "aa aa aa aa"))
    println(!Solution.wordPattern("aaaaa", "aa aa"))

}
