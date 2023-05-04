package com.leetcode.tasks.algorithms.`735`.asteroid.collision

import java.util.LinkedList


/**
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision
 */

private object Solution {

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = ArrayDeque<Int>()

        for (curr in asteroids) {
            if (stack.isNotEmpty()) {
                if (isSameDirection(stack.first(), curr) || (curr > 0 && stack.first() < 0)) {
                    stack.addFirst(curr)
                } else {
                    var destroyed = false
                    while (stack.isNotEmpty() && Math.abs(stack.first()) <= Math.abs(curr)
                        && !isSameDirection(stack.first(), curr) && !destroyed
                    ) {
                        if (Math.abs(stack.first()) == Math.abs(curr)) destroyed = true
                        stack.removeFirst()
                    }

                    if (!destroyed) {
                        if (stack.isEmpty() || isSameDirection(stack.first(), curr)) stack.addFirst(curr)
                    }
                }
            } else stack.addFirst(curr)
        }

        val result = IntArray(stack.size) { 0 }

        var index = stack.size - 1
        while (stack.isNotEmpty()) {
            result[index--] = stack.removeFirst()
        }

        return result
    }

    fun asteroidCollision1(asteroids: IntArray): IntArray {
        val stack = LinkedList<Int>() // use LinkedList to simulate stack so that we don't need to reverse at end.

        for (curr in asteroids) {
            while (!stack.isEmpty() && stack.last > 0 && stack.last < -curr)
                stack.pollLast()
            if (stack.isEmpty() || curr > 0 || stack.last < 0)
                stack.add(curr)
            else if (curr < 0 && stack.last == -curr)
                stack.pollLast()
        }
        return stack.stream().mapToInt { i: Int? -> i!! }.toArray()
    }

    private fun isSameDirection(a: Int, b: Int) = a * b > 0
}

fun main() {

    println(Solution.asteroidCollision1(intArrayOf(5, 10, -5)).contentEquals(intArrayOf(5, 10)))
    println(Solution.asteroidCollision1(intArrayOf(8, -8)).contentEquals(intArrayOf()))
    println(Solution.asteroidCollision1(intArrayOf(10, 2, -5)).contentEquals(intArrayOf(10)))
    println(Solution.asteroidCollision1(intArrayOf(2, 1, -1, -2)).contentEquals(intArrayOf()))
    println(Solution.asteroidCollision1(intArrayOf(-2, -1, 1, 2)).contentEquals(intArrayOf(-2, -1, 1, 2)))
    println(Solution.asteroidCollision1(intArrayOf(-2, -2, 1, -2)).contentEquals(intArrayOf(-2, -2, -2)))
    println(Solution.asteroidCollision1(intArrayOf(-2, -2, 2, 1)).contentEquals(intArrayOf(-2, -2, 2, 1)))
    println(Solution.asteroidCollision1(intArrayOf(10, 1, 2, 3, 4, -5)).contentEquals(intArrayOf(10)))

}