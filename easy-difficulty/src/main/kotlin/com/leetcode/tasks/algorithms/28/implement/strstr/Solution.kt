package com.leetcode.tasks.`28`.implement.strstr

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 */

private object Solution {

    fun strStr1(haystack: String, needle: String): Int {
        return if (needle.isEmpty()) return 0 else haystack.indexOf(needle)
    }

    fun strStr2(haystack: String, needle: String): Int {
        var match: Boolean

        for ((i, c) in haystack.withIndex()) {
            if (c == needle[0] && i + needle.length <= haystack.length) {
                match = true
                for (j in 1..needle.lastIndex) {
                    if (haystack[i + j] != needle[j]) {
                        match = false
                        break
                    }
                }
                if (match) return i
            }
        }

        return -1
    }
}

fun main() {

    println(Solution.strStr2(haystack = "mississippi", needle = "issip") == 4)
    println(Solution.strStr2(haystack = "q", needle = "q") == 0)
    println(Solution.strStr2(haystack = "loolv", needle = "ll") == -1)
    println(Solution.strStr2(haystack = "lloov", needle = "ll") == 0)
    println(Solution.strStr2(haystack = "hell", needle = "ll") == 2)
    println(Solution.strStr2(haystack = "hello", needle = "ll") == 2)
    println(Solution.strStr2(haystack = "aaaaa", needle = "bba") == -1)

}
