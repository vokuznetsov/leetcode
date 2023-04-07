package com.leetcode.system.design

/**
 * 9999999. Maximum Average Subarray I
 * https://link.com/
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
