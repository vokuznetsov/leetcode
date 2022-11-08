package com.leetcode.tasks.`344`.reverse.string

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */


private object Solution {

    fun reverseString(s: CharArray): Unit {
        var startPointer = 0
        var endPointer = s.lastIndex

        while (startPointer < endPointer) {
            val temp = s[startPointer]
            s[startPointer] = s[endPointer]
            s[endPointer] = temp
            startPointer++
            endPointer--
        }
    }
}

fun main() {

    val s1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    Solution.reverseString(s1)
    println(s1.contentEquals(charArrayOf('o', 'l', 'l', 'e', 'h')))

    val s2 = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    Solution.reverseString(s2)
    println(s2.contentEquals(charArrayOf('h', 'a', 'n', 'n', 'a', 'H')))

}
