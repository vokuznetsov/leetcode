package com.leetcode.tasks.algorithms.`389`.find.the.difference

/**
 * 389. Find the Difference
 * https://leetcode.com/problems/find-the-difference/
 */


private object Solution {

    fun findTheDifference(s: String, t: String): Char {
        val array = IntArray('z' - 'a' + 1) { 0 }

        for (i in 0..s.lastIndex) {
            array[s[i] - 'a'] += 1
            array[t[i] - 'a'] -= 1
        }
        array[t[t.lastIndex] - 'a'] -= 1

        for ((index, value) in array.withIndex()) {
            if (value < 0) return (index + 'a'.toInt()).toChar()
        }

        return '!'
    }

    // more readable without array
    fun findTheDifference1(s: String, t: String): Char {
        var charCode = t[t.lastIndex].toInt()

        for (i in 0..s.lastIndex) {
            charCode -= s[i].toInt()
            charCode += t[i].toInt()
        }

        return charCode.toChar()
    }

}

fun main() {

    println(Solution.findTheDifference1("abcd", "abcde") == 'e')
    println(Solution.findTheDifference1("", "y") == 'y')
    println(Solution.findTheDifference1("a", "aa") == 'a')

}
