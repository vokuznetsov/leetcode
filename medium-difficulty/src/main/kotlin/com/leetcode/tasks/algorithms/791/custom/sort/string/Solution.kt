package com.leetcode.tasks.algorithms.`791`.custom.sort.string

/**
 * 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/
 */
private object Solution {

    fun customSortString(order: String, s: String): String {
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val sb = StringBuilder()
        for (c in order) {
            if (map.containsKey(c)) {
                var count = map.getOrDefault(c, 0)
                while (count-- > 0) {
                    sb.append(c)
                }
                map.remove(c)
            }
        }

        for ((key, value) in map) {
            for (i in 1..value) sb.append(key)
        }

        return sb.toString()
    }
}

fun main() {

    println(Solution.customSortString("cba", "abcd") == "cbad")
    println(Solution.customSortString("cbafg", "abcd") == "cbad")
    println(Solution.customSortString("kqep", "pekeq") == "kqeep")

}