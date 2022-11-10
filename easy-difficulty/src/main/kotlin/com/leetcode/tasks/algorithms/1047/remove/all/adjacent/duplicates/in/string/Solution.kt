package com.leetcode.tasks.algorithms.`1047`.remove.all.adjacent.duplicates.`in`.string

/**
 * 1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

private object Solution {

    fun removeDuplicates(s: String): String {
        val sb = StringBuilder()
        var sbLength = 0

        for (c in s) {
            if (sb.isNotEmpty() && sb[sbLength - 1] == c) {
                sb.deleteCharAt(sbLength - 1)
                sbLength--
            } else {
                sb.append(c)
                sbLength++
            }
        }

        return sb.toString()
    }
}

fun main() {

    println(Solution.removeDuplicates("abbaca") == "ca")
    println(Solution.removeDuplicates("azxxzy") == "ay")

}
