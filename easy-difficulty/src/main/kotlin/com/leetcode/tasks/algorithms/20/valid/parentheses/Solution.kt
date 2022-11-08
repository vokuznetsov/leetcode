package com.leetcode.tasks.algorithms.`20`.valid.parentheses

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
private object Solution {

    fun isValid(s: String): Boolean {

        val stack = ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(', '[', '{' -> stack.addLast(c)
                ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
                ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
                '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
            }
        }

        return stack.isEmpty()
    }
}

fun main() {

    println(Solution.isValid("()"))
    println(Solution.isValid("()[]{}"))
    println(Solution.isValid("(]"))
    println(Solution.isValid("(()"))
    println(Solution.isValid("]"))

}
