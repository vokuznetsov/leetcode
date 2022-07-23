package com.leetcode.tasks.`58`.length.of.last.word

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
private object Solution {

    fun lengthOfLastWord(s: String): Int {
        var lastWordEnd = false
        var length = 0

        for (i in s.lastIndex downTo 0) {
            // for any space use regex `([^\\s]+)`
            //if (s[i].toString().matches(Regex("([^\\s]+)"))) {
            if (s[i] != ' ') {
                length++
                lastWordEnd = true
            } else if (lastWordEnd) return length
        }

        return length
    }
}

fun main() {

    println(Solution.lengthOfLastWord("Hello World") == 5)
    println(Solution.lengthOfLastWord("   fly me   to   the moon  ") == 4)
    println(Solution.lengthOfLastWord("luffy is still joyboy") == 6)

}
