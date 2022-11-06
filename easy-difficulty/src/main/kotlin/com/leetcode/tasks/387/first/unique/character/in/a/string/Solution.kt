package com.leetcode.tasks.`387`.first.unique.character.`in`.a.string

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */


private object Solution {

    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }
        for ((index, char) in s.withIndex()) {
            map[char]?.let {
                if (it == 1) return index
            }
        }

        return -1
    }
}

fun main() {

    println(Solution.firstUniqChar("leetcode") == 0)
    println(Solution.firstUniqChar("a") == 0)
    println(Solution.firstUniqChar("loveleetcode") == 2)
    println(Solution.firstUniqChar("aabb") == -1)

}
