package com.leetcode.tasks.algorithms.`680`.valid.palindrome.ii

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 */


private object Solution {

    fun validPalindrome(s: String): Boolean {
        var first = 0
        var last = s.lastIndex

        while (first < last) {
            if (s[first] != s[last]) {
                return checkPalindrome(s, first + 1, last) || checkPalindrome(s, first, last - 1)
            }
            first++
            last--
        }


        return true
    }

    private fun checkPalindrome(s: String, start: Int, end: Int): Boolean {
        var first = start
        var last = end
        while (first < last) {
            if (s[first] != s[last]) return false
            first++
            last--
        }
        return true
    }
}

fun main() {

    println(Solution.validPalindrome("a"))
    println(Solution.validPalindrome("ab"))
    println(Solution.validPalindrome("aba"))
    println(Solution.validPalindrome("abca"))
    println(Solution.validPalindrome("adbba"))
    println(!Solution.validPalindrome("abc"))
    println(Solution.validPalindrome("cuucu"))
    println(Solution.validPalindrome("cucu"))

}
