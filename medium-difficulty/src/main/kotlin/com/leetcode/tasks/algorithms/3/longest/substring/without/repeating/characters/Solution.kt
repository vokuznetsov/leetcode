package com.leetcode.tasks.algorithms.`3`.longest.substring.without.repeating.characters

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
private object Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val previousChars = mutableMapOf<Char, Int>()

        for ((index, c) in s.withIndex()) {
            if (previousChars.contains(c)) {
                maxLength = Math.max(maxLength, previousChars.size)

                val repeatingIndex = previousChars[c]!!
                val start = index - previousChars.size
                for (i in start..repeatingIndex) previousChars.remove(s[i])

            }
            previousChars[c] = index
        }

        return Math.max(maxLength, previousChars.size)
    }
}

fun main() {

    println(Solution.lengthOfLongestSubstring("") == 0)
    println(Solution.lengthOfLongestSubstring("cbbd") == 2)
    println(Solution.lengthOfLongestSubstring("abcabcbb") == 3)
    println(Solution.lengthOfLongestSubstring("bbbbb") == 1)
    println(Solution.lengthOfLongestSubstring("pwwkew") == 3)
    println(Solution.lengthOfLongestSubstring("dvdf") == 3)

}