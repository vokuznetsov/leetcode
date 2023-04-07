package com.leetcode.tasks.algorithms.`1832`.check.`if`.the.sentence.`is`.pangram

/**
 * 1832. Check if the Sentence Is Pangram
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

private object Solution {

    fun checkIfPangram(sentence: String): Boolean {
        val set = mutableSetOf<Char>()
        for (i in 97..122) set.add(i.toChar())

        for (c in sentence) {
            set.remove(c)
        }
        return set.size == 0
    }
}

fun main() {

    println(Solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
    println(!Solution.checkIfPangram("leetcode"))

}
