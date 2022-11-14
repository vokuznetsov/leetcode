package com.leetcode.tasks.algorithms.`412`.fizz.buzz

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 */


private object Solution {

    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1..n) {
            when {
                i % 3 == 0 && i % 5 == 0 -> result.add("FizzBuzz")
                i % 3 == 0 -> result.add("Fizz")
                i % 5 == 0 -> result.add("Buzz")
                else -> result.add(i.toString())
            }
        }

        return result
    }
}

fun main() {

    println(Solution.fizzBuzz(3) == listOf("1", "2", "Fizz"))
    println(Solution.fizzBuzz(5) == listOf("1", "2", "Fizz", "4", "Buzz"))
    println(
        Solution.fizzBuzz(15) == listOf(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
        )
    )


}
