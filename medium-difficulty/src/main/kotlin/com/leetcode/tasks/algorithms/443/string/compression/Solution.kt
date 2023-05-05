package com.leetcode.tasks.algorithms.`443`.string.compression


/**
 * 443. String Compression
 * https://leetcode.com/problems/string-compression/
 */

private object Solution {

    fun compress(chars: CharArray): Int {
        var left = 0
        var right = 0
        var lastPosition = 0

        while (left < chars.size) {
            while (right < chars.size && chars[left] == chars[right]) {
                right++
            }

            chars[lastPosition] = chars[left]

            if (right - left > 1) {
                val charsOfInt = (right - left).toString().toCharArray()
                for (c in charsOfInt) {
                    chars[++lastPosition] = c
                }
                lastPosition++
                left = right
            } else {
                left++
                right++
                lastPosition++
            }
        }

        return lastPosition
    }
}

fun main() {

    println(Solution.compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')) == 6)
    println(Solution.compress(charArrayOf('a')) == 1)
    println(Solution.compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')) == 4)
    println(Solution.compress(charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a')) == 6)
    println(Solution.compress(charArrayOf('a', 'b', 'c')) == 3)
    println(Solution.compress(charArrayOf('a', 'a', 'a', 'a', 'a', 'b')) == 3)

}