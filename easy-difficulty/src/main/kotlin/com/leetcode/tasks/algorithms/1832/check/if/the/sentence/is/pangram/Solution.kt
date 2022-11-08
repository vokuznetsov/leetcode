package com.leetcode.tasks.`1832`.check.`if`.the.sentence.`is`.pangram

/**
 * 1832. Check if the Sentence Is Pangram
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

private object Solution {

    fun checkIfPangram(sentence: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        ('a'..'z').forEach { c -> map[c] = 0 }

        for (c in sentence) {
            map[c] = map.getValue(c) + 1
        }

        return !map.filter { entry -> entry.value == 0 }.any()
    }

    fun checkIfPangram1(sentence: String): Boolean {
        for (i in (0..25)) {
            val currChar = 'a' + i

            if (!sentence.contains(currChar)) return false
        }
        return true
    }
}

fun main() {

    println(Solution.checkIfPangram1("thequickbrownfoxjumpsoverthelazydog"))
    println(Solution.checkIfPangram1("leetcode"))

}
