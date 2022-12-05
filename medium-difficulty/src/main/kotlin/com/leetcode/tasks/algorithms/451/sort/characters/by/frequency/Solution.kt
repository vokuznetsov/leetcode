package com.leetcode.tasks.algorithms.`451`.sort.characters.by.frequency

/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
private object Solution {

    fun frequencySort(s: String): String {
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val sb = StringBuilder()

        for ((key, value) in map.entries.sortedByDescending { it.value }) {
            for (i in 0 until value) {
                sb.append(key)
            }
        }

        return sb.toString()
    }
}

fun main() {

    println(arrayOf("eert", "eetr").contains(Solution.frequencySort("tree")))
    println(arrayOf("aaaccc", "cccaaa").contains(Solution.frequencySort("cccaaa")))
    println(arrayOf("bbAa", "bbaA").contains(Solution.frequencySort("Aabb")))

}