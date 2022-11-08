package com.leetcode.tasks.algorithms.`14`.longest.common.prefix

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
private object Solution {

    fun longestCommonPrefix1(strs: Array<String>): String {
        var newString = ""

        for (i in 0 until strs[0].length) {
            val set = strs.map { if (i < it.length) it[i] else null }.toSet()
            if (set.size == 1) newString += set.first() else return newString
        }

        return newString
    }
}

fun main() {

    println(Solution.longestCommonPrefix1(arrayOf("flower", "flow", "flight")) == "fl")
    println(Solution.longestCommonPrefix1(arrayOf("dog", "racecar", "car")) == "")
    println(Solution.longestCommonPrefix1(arrayOf("aac", "aa", "aa")) == "aa")

}
