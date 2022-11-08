package com.leetcode.tasks.`263`.ugly.`number `

/**
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/
 */


private object Solution {

    fun isUgly(n: Int): Boolean {
        if (n <= 0) return false
        var value = n

        while (value != 1) {
            value /= if (value % 2 == 0) 2
            else if (value % 3 == 0) 3
            else if (value % 5 == 0) 5
            else return false
        }
        return true
    }
}

fun main() {

    println(Solution.isUgly(0))
    println(Solution.isUgly(6))
    println(Solution.isUgly(1))
    println(Solution.isUgly(2))
    println(Solution.isUgly(14))

}
