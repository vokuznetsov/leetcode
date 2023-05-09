package com.leetcode.tasks.algorithms.`933`.number.of.recent.calls

/**
 * 933. Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/
 */

private data class Pair(val userId: Long, val time: Long)

private class UserStatistics(val k: Int, val limit: Int) {

    var count = 0
    val map = mutableMapOf<Long, Int>()
    val deque = ArrayDeque<Pair>()


    fun event(userId: Long, currentTs: Long) {
        //val currentTs = currentTimeInSeconds()
        // place your code here
        val userCount = map.getOrDefault(userId, 0)
        if (userCount + 1 == limit) count++
        map[userId] = userCount + 1
        deque.addLast(Pair(userId, currentTs))

        calculateActualCounts(currentTs)
        //println(count)
    }

    fun robotCount(currentTs: Long): Int {
        //val currentTs = currentTimeInSeconds()
        // place your code here
        calculateActualCounts(currentTs)
        return count
    }

    /*private fun currentTimeInSeconds(): Long {
        // do not need to implement
    }*/

    private fun calculateActualCounts(currentTs: Long) {
        while (deque.isNotEmpty() && deque.first().time < currentTs - k) {
            val pair = deque.removeFirst()
            val userRequests = map.getOrDefault(pair.userId, 0)

            if (userRequests == limit) count--

            if (userRequests == 1) map.remove(pair.userId)
            else map[pair.userId] = userRequests - 1
        }
    }
}

fun main() {

    test1()
    test2()
    test3()
}

private fun test1() {
    val stat = UserStatistics(3000, 2)

    stat.event(2, 1)
    stat.event(2, 2)
    stat.event(2, 3)

    stat.event(1, 102)
    stat.event(1, 103)
    stat.event(4, 103)
    stat.event(1, 104)
    stat.event(4, 105)

    stat.event(3, 201)
    stat.event(3, 202)
    stat.event(3, 203)
    stat.event(3, 204)
    stat.event(3, 205)

    stat.event(1, 3103)


    println(stat.robotCount(3104) == 2)
}

private fun test2() {
    val stat = UserStatistics(3000, 1)

    stat.event(2, 1)
    stat.event(2, 2)
    stat.event(2, 3)

    stat.event(1, 102)
    stat.event(1, 103)
    stat.event(4, 103)
    stat.event(1, 104)
    stat.event(4, 105)

    stat.event(3, 201)
    stat.event(3, 202)
    stat.event(3, 203)
    stat.event(3, 204)
    stat.event(3, 205)

    stat.event(1, 3103)


    println(stat.robotCount(3104) == 3)
}

private fun test3() {
    val stat = UserStatistics(100, 3)

    stat.event(2, 11)
    stat.event(2, 12)
    stat.event(2, 13)

    stat.event(1, 51)
    stat.event(1, 52)
    stat.event(1, 53)

    stat.event(4, 71)
    stat.event(4, 72)



    println(stat.robotCount(105) == 2)
}

