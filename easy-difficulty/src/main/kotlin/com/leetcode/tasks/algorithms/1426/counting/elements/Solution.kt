package com.leetcode.tasks.algorithms.`1426`.counting.elements

/**
 * 1426. Counting Elements
 * https://leetcode.com/problems/counting-elements/
 */

private object Solution {

    fun countElements(arr: IntArray): Int {
        var ans = 0
        val set = arr.toSet()
        for (num in arr) {
            if (set.contains(num + 1)) ans++
        }
        return ans
    }
}

fun main() {

    println(Solution.countElements(intArrayOf(1, 2, 3)) == 2)
    println(Solution.countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)) == 0)


}
