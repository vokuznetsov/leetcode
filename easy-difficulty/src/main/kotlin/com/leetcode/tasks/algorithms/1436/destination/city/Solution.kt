package com.leetcode.tasks.algorithms.`1436`.destination.city

/**
 * 1436. Destination City
 * https://leetcode.com/problems/destination-city/
 */

private object Solution {

    fun destCity(paths: List<List<String>>): String {
        val ends = mutableSetOf<String>()

        for (path in paths) ends.add(path[1])
        for (path in paths) ends.remove(path[0])

        return ends.first()
    }
}

fun main() {

    println(
        Solution.destCity(
            listOf(
                listOf("London", "New York"),
                listOf("New York", "Lima"),
                listOf("Lima", "Sao Paulo")
            )
        ) == "Sao Paulo"
    )

    println(
        Solution.destCity(
            listOf(
                listOf("B", "C"),
                listOf("D", "B"),
                listOf("C", "A")
            )
        ) == "A"
    )

    println(
        Solution.destCity(
            listOf(
                listOf("A", "Z")
            )
        ) == "Z"
    )

}
