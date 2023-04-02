package com.leetcode.tasks.algorithms.`557`.reverse.words.`in`.a.string.iii

/**
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/
 */

private object Solution {

    fun reverseWords(s: String): String {
        var start = 0

        val chArr = s.toCharArray()

        for (i in 0..s.lastIndex) {
            if (s[i] == ' ') {
                reverse(chArr, start, i - 1)
                start = i + 1
            }

            if (i == s.lastIndex) {
                reverse(chArr, start, i)
            }
        }

        return String(chArr)
    }

    private fun reverse(array: CharArray, start: Int, end: Int) {
        var left = start
        var right = end

        while (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
}

fun main() {

    println(Solution.reverseWords("Let's take LeetCode contest") == "s'teL ekat edoCteeL tsetnoc")
    println(Solution.reverseWords("God Ding") == "doG gniD")

}
