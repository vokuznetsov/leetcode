package com.leetcode.tasks.algorithms.`1962`.remove.stones.to.minimize.the.total

import java.util.PriorityQueue

/**
 * 1962. Remove Stones to Minimize the Total
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/
 */
private object Solution {

    fun minStoneSum(piles: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }
        var sum: Long = 0
        for (pile in piles) {
            queue.add(pile)
            sum += pile
        }

        var count = k
        var removedSum: Long = 0
        while (count != 0) {
            val maxValue = queue.remove()
            val removed = Math.floorDiv(maxValue, 2)
            removedSum += removed
            queue.add(maxValue - removed)
            count--
        }
        return sum.minus(removedSum).toInt()
    }
}

fun main() {

    println(Solution.minStoneSum(intArrayOf(5, 4, 9), 2) == 12)
    println(Solution.minStoneSum(intArrayOf(4, 3, 6, 7), 3) == 12)

}