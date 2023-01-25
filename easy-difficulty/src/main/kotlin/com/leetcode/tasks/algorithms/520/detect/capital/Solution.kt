package com.leetcode.tasks.algorithms.`520`.detect.capital

/**
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/
 */


private object Solution {

    fun detectCapitalUse(word: String): Boolean {
        if (word == word.toUpperCase() || word == word.toLowerCase()) return true
        if (word[0] == word[0].toUpperCase()) {
            for (i in 1..word.lastIndex) {
                if (word[i] != word[i].toLowerCase()) return false
            }
            return true
        }

        return false
    }
}

fun main() {

    println(Solution.detectCapitalUse("USA"))
    println(!Solution.detectCapitalUse("leetcode"))
    println(Solution.detectCapitalUse("Google"))
    println(!Solution.detectCapitalUse("FlaG"))
    println(Solution.detectCapitalUse("g"))

}
