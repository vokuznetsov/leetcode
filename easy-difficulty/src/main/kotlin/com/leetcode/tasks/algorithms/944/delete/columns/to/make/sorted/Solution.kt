package com.leetcode.tasks.algorithms.`944`.delete.columns.to.make.sorted

/**
 * 944. Delete Columns to Make Sorted
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */

private object Solution {

    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs[0].lastIndex
        var deleted = 0

        for (i in 0..n) {
            var previous = 'a'
            for (str in strs) {
                if (str[i] >= previous) previous = str[i]
                else {
                    deleted++
                    break
                }
            }
        }

        return deleted
    }
}

fun main() {

    println(Solution.minDeletionSize(arrayOf("dbc", "ace", "yae")) == 2)
    println(Solution.minDeletionSize(arrayOf("abc", "bce", "cae")) == 1)
    println(Solution.minDeletionSize(arrayOf("cba", "daf", "ghi")) == 1)
    println(Solution.minDeletionSize(arrayOf("a", "b")) == 0)
    println(Solution.minDeletionSize(arrayOf("zyx", "wvu", "tsr")) == 3)

}
