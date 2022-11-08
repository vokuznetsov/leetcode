package com.leetcode.tasks.algorithms.`383`.ransom.note

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 */

private object Solution {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val mapMagazine = mutableMapOf<Int, Int>()

        for (c in magazine.chars()) {
            mapMagazine[c] = mapMagazine.getOrDefault(c, 0) + 1
        }

        for (c in ransomNote.chars()) {
            val charCount = mapMagazine[c]
            if (charCount == null || charCount == 0) return false
            else mapMagazine[c] = charCount - 1
        }

        return true
    }

}

fun main() {

    println(Solution.canConstruct("a", "b"))
    println(Solution.canConstruct("aa", "ab"))
    println(Solution.canConstruct("aa", "aab"))

}
