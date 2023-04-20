package com.leetcode.tasks.algorithms.`567`.permutation.`in`.string

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 */
private object Solution {

    fun checkInclusion(s1: String, s2: String): Boolean {
        var left = 0
        val map = mutableMapOf<Char, Int>()

        for (c in s1) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        for (i in 0..s2.lastIndex) {
            if (map.getOrDefault(s2[i], -1) >= 0) {
                val value = map.getOrDefault(s2[i], 0)
                map[s2[i]] = value - 1

                while (map.getOrDefault(s2[i], -1) < 0)
                    map[s2[left]] = map.getOrDefault(s2[left++], -1) + 1

                if (s1.length == i - left + 1) return true
            } else {
                while (left <= i) {
                    if (map.containsKey(s2[left]))
                        map[s2[left]] = map.getOrDefault(s2[left], 0) + 1
                    left++
                }
            }
        }

        return false
    }
}

fun main() {

    println(Solution.checkInclusion("ab", "eidbaooo"))
    println(!Solution.checkInclusion("ab", "eidboaoo"))
    println(Solution.checkInclusion("adc", "dcda"))
    println(Solution.checkInclusion("adc", "cddac"))
    println(!Solution.checkInclusion("hello", "ooolleoooleh"))

}