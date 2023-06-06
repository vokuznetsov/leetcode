package com.leetcode.tasks.algorithms.`356`.line.reflection


/**
 * 356. Line Reflection
 * https://leetcode.com/problems/line-reflection/
 */

private object Solution {

    fun isReflected(points: Array<IntArray>): Boolean {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val map = mutableMapOf<Int, MutableSet<Int>>()

        for (point in points) {
            min = Math.min(min, point[0])
            max = Math.max(max, point[0])

            val set = map.getOrDefault(point[1], mutableSetOf())
            set.add(point[0])
            map[point[1]] = set
        }

        val sum = max + min

        for (point in points) {
            val xPoints = map.getOrDefault(point[1], setOf())
            if (!xPoints.contains(sum - point[0])) return false
        }

        return true
    }

    fun isReflected1(points: Array<IntArray>): Boolean {
        val result = mutableSetOf<Double>()
        val map = mutableMapOf<Int, MutableSet<Int>>()

        for (point in points) {
            val list = map.getOrDefault(point[1], mutableSetOf())
            list.add(point[0])
            map[point[1]] = list
        }

        for ((_, set) in map) {
            val values = set.sorted()

            var left = 0
            var right = values.lastIndex
            while (left <= right) {
                if (left != right) {
                    val diff = values[right] - values[left++]
                    val middle = diff.toDouble() / 2
                    result.add(values[right--] - middle)
                } else {
                    result.add(values[left++].toDouble())
                    right--
                }
            }

            if (result.size > 1) return false
        }

        return result.size == 1
    }
}

fun main() {

    println(Solution.isReflected(arrayOf(intArrayOf(1, 1), intArrayOf(-1, 1))))

}