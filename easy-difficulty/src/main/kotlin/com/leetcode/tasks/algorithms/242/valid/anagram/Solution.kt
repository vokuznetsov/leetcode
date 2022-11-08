package com.leetcode.tasks.algorithms.`242`.valid.anagram

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */


private object Solution {

    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()

        s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        t.forEach {
            if (!map.containsKey(it)) return false
            val value = map[it]
            if (value != null && value > 1) map[it] = value - 1 else map.remove(it)
        }

        return map.isEmpty()
    }
}

fun main() {

    println(Solution.isAnagram("anagram", "nagaram"))
    println(Solution.isAnagram("rat", "car"))

}
