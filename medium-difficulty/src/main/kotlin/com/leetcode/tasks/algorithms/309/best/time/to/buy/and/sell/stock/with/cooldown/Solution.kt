package com.leetcode.tasks.algorithms.`309`.best.time.to.buy.and.sell.stock.with.cooldown

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
private object Solution {

    fun maxProfit(prices: IntArray): Int {
        var sold = Int.MIN_VALUE
        var held = Int.MIN_VALUE
        var reset = 0

        for (price in prices) {
            var tempSold = held + price
            held = Math.max(held, reset - price)
            reset = Math.max(reset, sold)
            sold = tempSold
        }

        return Math.max(sold, Math.max(held, reset))
    }
}

fun main() {

    println(Solution.maxProfit(intArrayOf(1, 2, 3, 0, 2)) == 3)
    println(Solution.maxProfit(intArrayOf(1)) == 0)
    println(Solution.maxProfit(intArrayOf(1, 2, 2, 2, 2, 10)) == 9)
    println(Solution.maxProfit(intArrayOf(1, 2, 3)) == 2)

}