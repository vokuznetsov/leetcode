package com.leetcode.tasks.algorithms.`414`.third.maximum.number

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 */


private object Solution {

    // space - O(n)
    fun thirdMax(nums: IntArray): Int {
        val set = nums.toSortedSet()
        return if (set.size < 3) set.last() else set.elementAt(set.size - 3)
    }

    fun thirdMax1(nums: IntArray): Int {
        var first = Pair(0, false)
        var second = Pair(0, false)
        var third = Pair(0, false)

        for (num in nums) {
            if ((first.second && first.first == num)
                || (second.second && second.first == num)
                || (third.second && third.first == num)
            ) {
                continue
            }

            if (!first.second || first.first < num) {
                third = second
                second = first
                first = Pair(num, true)
            } else if (!second.second || second.first < num) {
                third = second
                second = Pair(num, true)
            } else if (!third.second || third.first < num) {
                third = Pair(num, true)
            }
        }

        return if (third.second) third.first else first.first
    }
}

fun main() {

    println(Solution.thirdMax1(intArrayOf(3, 2, 1)) == 1)
    println(Solution.thirdMax1(intArrayOf(1, 2)) == 2)
    println(Solution.thirdMax1(intArrayOf(2, 2, 3, 1)) == 1)

}
