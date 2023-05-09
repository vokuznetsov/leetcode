package com.leetcode.tasks.algorithms.`933`.number.of.recent.calls

/**
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 */

private class RecentCounter() {

    val deque = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        deque.addLast(t)
        while (deque.first() < t - 3000) {
            deque.removeFirst()
        }

        return deque.size
    }

}

fun main() {

    test1()
}

private fun test1() {
    val counter = RecentCounter()
    println(counter.ping(1) == 1)
    println(counter.ping(100) == 2)
    println(counter.ping(3001) == 3)
    println(counter.ping(3002) == 3)
}

