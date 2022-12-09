package com.leetcode.tasks.algorithms.`346`.moving.average.from.data.stream

import java.util.ArrayDeque

/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */


private class MovingAverage(val size: Int) {

    val deque = ArrayDeque<Int>(size)
    var sum = 0

    fun next(`val`: Int): Double {
        val lastElem = if (deque.size == size) deque.removeFirst() else 0
        deque.addLast(`val`)
        sum += `val` - lastElem

        return sum.toDouble() / deque.size
    }

}

// another variant
private class MovingAverage1(var size: Int) {
    var head = 0
    var windowSum = 0
    var count = 0
    var queue: IntArray = IntArray(size)

    fun next(`val`: Int): Double {
        ++count
        // calculate the new sum by shifting the window
        val tail = (head + 1) % size
        windowSum = windowSum - queue[tail] + `val`
        // move on to the next head
        head = (head + 1) % size
        queue[head] = `val`
        return windowSum * 1.0 / Math.min(size, count)
    }
}

fun main() {

    val movingAverage = MovingAverage1(3)
    println(movingAverage.next(1)) // return 1.0 = 1 / 1
    println(movingAverage.next(10)) // return 5.5 = (1 + 10) / 2
    println(movingAverage.next(3)) // return 4.66667 = (1 + 10 + 3) / 3
    println(movingAverage.next(5)) // return 6.0 = (10 + 3 + 5) / 3
}
