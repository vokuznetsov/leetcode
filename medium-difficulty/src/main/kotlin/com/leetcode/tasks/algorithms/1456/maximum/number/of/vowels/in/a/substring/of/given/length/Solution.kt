package com.leetcode.tasks.algorithms.`1456`.maximum.number.of.vowels.`in`.a.substring.of.given.length

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */

private object Solution {

    fun maxVowels(s: String, k: Int): Int {
        var left = 0
        var curr = 0

        for (i in 0 until k) {
            if (isVowel(s[i])) curr++
        }
        var ans = curr

        for (i in k..s.lastIndex) {
            if (isVowel(s[i])) curr++
            if (isVowel(s[left++])) curr--
            ans = Math.max(ans, curr)

            if (ans == k) return ans
        }

        return ans
    }

    private fun isVowel(c: Char): Boolean {
        return c == 'u' || c == 'e' || c == 'o' || c == 'a' || c == 'i'
    }
}

fun main() {

    println(Solution.maxVowels("abciiidef", 3) == 3)
    println(Solution.maxVowels("aeiou", 2) == 2)
    println(Solution.maxVowels("leetcode", 3) == 2)
    println(Solution.maxVowels("zpuerktejfp", 3) == 2)

}