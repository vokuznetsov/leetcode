package com.leetcode.tasks.algorithms.`841`.keys.and.rooms

import java.util.ArrayDeque

/**
 * 841. Keys and Rooms
 * https://leetcode.com/problems/keys-and-rooms/
 */
private object Solution {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visitedRooms = mutableSetOf<Int>()
        val queue = ArrayDeque<Int>()
        rooms[0].forEach { queue.addLast(it) }
        visitedRooms.add(0)

        while (queue.isNotEmpty() && visitedRooms.size != rooms.size) {
            val room = queue.removeFirst()
            visitedRooms.add(room)
            rooms[room].forEach {
                if (!visitedRooms.contains(it)) queue.addLast(it)
            }
        }

        return visitedRooms.size == rooms.size
    }
}

fun main() {

    println(Solution.canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    println(!Solution.canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))


}