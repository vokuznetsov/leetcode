package com.leetcode.tasks.algorithms.`2000`.reverse.prefix.of.word

/**
 * 2000. Reverse Prefix of Word
 * https://leetcode.com/problems/reverse-prefix-of-word/
 */

private object Solution {

    fun reversePrefix(word: String, ch: Char): String {
        val index = word.indexOf(ch)
        if (index == -1) return word

        val charArray = word.toCharArray()
        var left = 0
        var right = index

        while (left < right) {
            val tmp = charArray[left]
            charArray[left++] = charArray[right]
            charArray[right--] = tmp
        }

        return String(charArray)
    }
}

fun main() {

    println(Solution.reversePrefix("abcdefd", 'd') == "dcbaefd")
    println(Solution.reversePrefix("xyxzxe", 'z') == "zxyxxe")
    println(Solution.reversePrefix("abcd", 'z') == "abcd")

}
