package com.leetcode.tasks.algorithms.`901`.online.stock.span

/**
 * 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 */
private class StockSpanner() {

    val stockQueue = ArrayDeque<Int>()
    val dayQueue = ArrayDeque<Int>()
    var day = 0

    fun next(price: Int): Int {
        day++
        while(stockQueue.isNotEmpty() && price >= stockQueue.last()) {
            stockQueue.removeLast()
            dayQueue.removeLast()
        }

        val result =  if (dayQueue.isEmpty()) day else day - dayQueue.last()
        stockQueue.add(price)
        dayQueue.add(day)

        return result
    }

}

fun main() {

}