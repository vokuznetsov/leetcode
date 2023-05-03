package com.leetcode.tasks.algorithms.`2390`.removing.stars.from.a.string

/**
 * 2390. Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */
private object Solution {

    fun removeStars(s: String): String {
        val stack = StringBuilder()

        for (c in s) {
            if (c == '*' && stack.isNotEmpty()) {
                stack.deleteCharAt(stack.lastIndex)
            } else {
                stack.append(c)
            }
        }
        return stack.toString()
    }
}

fun main() {

}