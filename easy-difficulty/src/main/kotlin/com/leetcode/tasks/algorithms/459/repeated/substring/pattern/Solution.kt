package com.leetcode.tasks.algorithms.`459`.repeated.substring.pattern

/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 */

private object Solution {

    fun repeatedSubstringPattern(s: String): Boolean {
        val length = s.length

        for (i in length / 2 downTo 1) {
            if (length % i == 0) {

                val times = length / i
                val subStr = s.substring(0, i)

                val sb = StringBuilder()
                for (j in 0 until times) sb.append(subStr)

                if (sb.toString() == s) return true
            }
        }

        return false
    }
}

fun main() {

    println(!Solution.repeatedSubstringPattern("ababba"))
    println(!Solution.repeatedSubstringPattern("ab"))
    println(!Solution.repeatedSubstringPattern("a"))
    println(Solution.repeatedSubstringPattern("abab"))
    println(!Solution.repeatedSubstringPattern("aba"))
    println(Solution.repeatedSubstringPattern("abcabcabcabc"))

}
