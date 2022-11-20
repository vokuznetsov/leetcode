package com.leetcode.tasks.algorithms.`1672`.richest.customer.wealth

/**
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 */

private object Solution {

    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = 0

        for (account in accounts) {
            val sum = account.sum()
            if (max < sum) max = sum
        }

        return max
    }
}

fun main() {

    println(Solution.maximumWealth(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))) == 6)
    println(Solution.maximumWealth(arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))) == 10)
    println(Solution.maximumWealth(arrayOf(intArrayOf(2, 8, 7), intArrayOf(7, 1, 3), intArrayOf(1, 9, 5))) == 17)

}
