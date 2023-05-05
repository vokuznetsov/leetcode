package com.leetcode.tasks.algorithms.`443`.string.compression

private object Additional {

    fun compress(str: String): String {
        var left = 0
        var right = 0

        val sb = StringBuilder()

        while (left < str.length) {
            while (right < str.length && str[left] == str[right]) {
                right++
            }

            if (right - left > 1) {
                sb.append("${str[left]}${right - left}")
                left = right
            } else {
                sb.append("${str[left]}")
                left++
                right++
            }
        }

        return sb.toString()
    }
}


fun main() {

    println(Additional.compress("aabbccc") == "a2b2c3")
    println(Additional.compress("a") == "a")
    println(Additional.compress("abbbbbbbbbbbb") == "ab12")
    println(Additional.compress("aaabbaa") == "a3b2a2")
    println(Additional.compress("abc") == "abc")
    println(Additional.compress("aaaaab") == "a5b")
    println(Additional.compress("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB") == "A4B3C2XYZD4E3F3A6B28")

}