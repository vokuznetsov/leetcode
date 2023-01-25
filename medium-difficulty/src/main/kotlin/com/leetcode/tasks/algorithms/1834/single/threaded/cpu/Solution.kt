package com.leetcode.tasks.algorithms.`1834`.single.threaded.cpu

import java.util.PriorityQueue

/**
 * 1834. Single-Threaded CPU
 * https://leetcode.com/problems/single-threaded-cpu/
 */
private object Solution {

    fun getOrder(tasks: Array<IntArray>): IntArray {
        val tasksWithIndex =
            PriorityQueue<Pair<IntArray, Int>>(tasks.size) { o1, o2 -> o1.first[0].compareTo(o2.first[0]) }

        for (i in 0..tasks.lastIndex) {
            tasksWithIndex.add(Pair(tasks[i], i))
        }

        val queue = PriorityQueue<Pair<IntArray, Int>>(tasks.size) { o1, o2 ->
            compareValuesBy(
                o1,
                o2,
                { it.first[1] },
                { it.second })
        }

        val result = IntArray(tasks.size) { -1 }
        var count = 0

        var time = tasksWithIndex.peek().first[0]

        while (count <= tasks.lastIndex) {
            if (!tasksWithIndex.isEmpty() && tasksWithIndex.peek().first[0] <= time) {
                queue.add(tasksWithIndex.remove())
            } else if (!queue.isEmpty()) {
                val task = queue.remove()
                result[count] = task.second
                time += task.first[1]
                count++
            } else {
                val task = tasksWithIndex.remove()
                time = task.first[0]
                queue.add(task)
            }
        }

        return result
    }
}

fun main() {

    println(
        Solution.getOrder(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 4),
                intArrayOf(3, 2),
                intArrayOf(4, 1)
            )
        ).contentEquals(
            intArrayOf(0, 2, 3, 1)
        )
    )

    println(
        Solution.getOrder(
            arrayOf(
                intArrayOf(7, 10),
                intArrayOf(7, 12),
                intArrayOf(7, 5),
                intArrayOf(7, 4),
                intArrayOf(7, 2)
            )
        ).contentEquals(
            intArrayOf(4, 3, 2, 0, 1)
        )
    )

    println(
        Solution.getOrder(
            arrayOf(
                intArrayOf(3, 10),
                intArrayOf(100, 5),
                intArrayOf(4, 2)
            )
        ).contentEquals(
            intArrayOf(0, 2, 1)
        )
    )

}