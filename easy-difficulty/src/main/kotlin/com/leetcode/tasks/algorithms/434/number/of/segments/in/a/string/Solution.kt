package com.leetcode.tasks.algorithms.`434`.number.of.segments.`in`.a.string

/**
 * 434. Number of Segments in a String
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */


private object Solution {

    fun countSegments(s: String): Int {
        var inWord = false
        var count = 0

        for (i in 0..s.lastIndex) {
            if (s[i] == ' ') inWord = false
            else if (!inWord) {
                count++
                inWord = true
            }
        }

        return count
    }
}

fun main() {

    println(Solution.countSegments("Hello, my name is John") == 5)
    println(Solution.countSegments("   Hello,  my   name   is   John   ") == 5)
    println(Solution.countSegments("Hello") == 1)
    println(Solution.countSegments("") == 0)
    println(Solution.countSegments(" ") == 0)

}
