package com.leetcode.tasks.algorithms.`125`.valid.palindrome

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 */

private object Solution {

    fun isPalindrome(s: String): Boolean {
        val str = s.toLowerCase().replace(Regex("[^a-z0-9]"), "")
        if (str.isEmpty()) return true

        var i = 0
        var j = str.length - 1

        while (i < j) {
            if (str[i] != str[j]) return false
            i++
            j--
        }

        return true
    }

    // more readable solution
    fun isPalindrome1(s: String): Boolean {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            if (s[left].isLetterOrDigit() && s[right].isLetterOrDigit()) {
                if (s[left++].toLowerCase() != s[right--].toLowerCase()) return false
            } else {
                if (!s[left].isLetterOrDigit()) left++
                if (!s[right].isLetterOrDigit()) right--
            }

        }

        return true
    }
}

fun main() {

    println(Solution.isPalindrome1("A man, a plan, a canal: Panama"))
    println(!Solution.isPalindrome1("race a car"))
    println(Solution.isPalindrome1(" "))

}
