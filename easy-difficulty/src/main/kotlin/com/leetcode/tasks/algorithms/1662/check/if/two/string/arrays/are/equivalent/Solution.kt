package com.leetcode.tasks.algorithms.`1662`.check.`if`.two.string.arrays.are.equivalent

/**
 * 1662. Check If Two String Arrays are Equivalent
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */

private object Solution {

    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val sb1 = StringBuffer()
        val sb2 = StringBuffer()

        word1.forEach { sb1.append(it) }
        word2.forEach { sb2.append(it) }

        return sb1.toString() == sb2.toString()
    }

    // more optimal - O(1) space
    fun arrayStringsAreEqual1(word1: Array<String>, word2: Array<String>): Boolean {
        var w1 = 0
        var w2 = 0
        var p1 = 0
        var p2 = 0

        while (w1 < word1.size && w2 < word2.size) {
            var str1 = word1[w1]
            var str2 = word2[w2]

            if (str1[p1] != str2[p2]) return false

            if (p1 < str1.length - 1)
                p1++
            else {
                p1 = 0
                w1++
            }

            if (p2 < str2.length - 1)
                p2++
            else {
                p2 = 0
                w2++
            }
        }

        return w1 == word1.size && w2 == word2.size
    }
}

fun main() {

    println(Solution.arrayStringsAreEqual1(arrayOf("ab", "c"), arrayOf("a", "bc")))
    println(Solution.arrayStringsAreEqual1(arrayOf("a", "cb"), arrayOf("ab", "c")))
    println(Solution.arrayStringsAreEqual1(arrayOf("abc", "d", "defg"), arrayOf("abcddefg")))
    println(Solution.arrayStringsAreEqual1(arrayOf("abc"), arrayOf("abcd")))

}
