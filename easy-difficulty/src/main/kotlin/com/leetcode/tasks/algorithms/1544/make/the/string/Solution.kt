package com.leetcode.tasks.algorithms.`1544`.make.the.string

import java.util.ArrayDeque

/**
 * 1544. Make The String Great
 * https://leetcode.com/problems/make-the-string-great/
 */

private object Solution {

    fun makeGood(s: String): String {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            if (stack.isNotEmpty() && Math.abs(c - stack.last()) == 32) stack.removeLast()
            else stack.addLast(c)
        }

        return stack.joinToString("")
    }
}

fun main() {

    println(Solution.makeGood("leEeetcode") == "leetcode")
    println(Solution.makeGood("") == "")
    println(Solution.makeGood("abBAcC") == "")
    println(Solution.makeGood("abBAacC") == "a")
    println(Solution.makeGood("abBAacCA") == "")
    println(Solution.makeGood("RLlr") == "")
    println(Solution.makeGood("RLlr") == "")
    println(Solution.makeGood("Rr") == "")
    println(Solution.makeGood("RrL") == "L")

}
