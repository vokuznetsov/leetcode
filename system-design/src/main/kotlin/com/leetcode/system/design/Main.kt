package com.leetcode.system.design


/**
 * 9999999. Maximum Average Subarray I
 * https://link.com/
 */
private object Solution {

    fun countElements(arr: IntArray): Int {
        var ans = 0
        val set = arr.toSet()
        for (num in set) {
            if (set.contains(num + 1)) ans++
        }
        return ans
    }
}

fun main() {

    println(Solution.countElements(intArrayOf(1, 2, 3)) == 2)
    println(Solution.countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)) == 0)

}
