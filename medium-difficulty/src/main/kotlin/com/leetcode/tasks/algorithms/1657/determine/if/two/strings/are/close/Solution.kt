package com.leetcode.tasks.algorithms.`1657`.determine.`if`.two.strings.are.close

/**
 * 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
private object Solution {

    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val map1 = mutableMapOf<Char, Int>()
        val map2 = mutableMapOf<Char, Int>()

        for (c in word1) {
            map1[c] = map1.getOrDefault(c, 0) + 1
        }
        for (c in word2) {
            map2[c] = map2.getOrDefault(c, 0) + 1
        }

        if (map1.keys != map2.keys) return false

        for ((key, value) in map1) {
            if (map2[key] == value) map2.remove(key)
            else {
                map2.entries.find { it.value == value }?.let { map2.remove(it.key) } ?: return false
            }
        }

        return map2.isEmpty()
    }
}

fun main() {

    println(Solution.closeStrings("abc", "bca"))
    println(!Solution.closeStrings("a", "aa"))
    println(Solution.closeStrings("cabbba", "abbccc"))
    println(Solution.closeStrings("abbzzca", "babzzcz"))
    println(Solution.closeStrings("uau", "ssx"))

}