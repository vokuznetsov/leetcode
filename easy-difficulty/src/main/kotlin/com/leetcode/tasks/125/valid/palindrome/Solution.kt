package com.leetcode.tasks.`125`.valid.palindrome

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
}

fun main() {

    println(Solution.isPalindrome("A man, a plan, a canal: Panama"))
    println(Solution.isPalindrome("race a car"))
    println(Solution.isPalindrome(" "))

}
