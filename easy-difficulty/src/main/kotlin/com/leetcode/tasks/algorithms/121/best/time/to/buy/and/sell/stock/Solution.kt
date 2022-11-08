package com.leetcode.tasks.`121`.best.time.to.buy.and.sell.stock

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

private object Solution {

    fun maxProfit(prices: IntArray): Int {

        return 1
    }
}

fun main() {

    println(Solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    println(Solution.maxProfit(intArrayOf(7, 1, 9, 3, 6, 4)) == 8)
    println(Solution.maxProfit(intArrayOf(7, 9, 9, 3, 6, 4)) == 3)
    println(Solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)

}
