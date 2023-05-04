package com.leetcode.tasks.algorithms.`946`.validate.stack.sequences

/**
 * 946. Validate Stack Sequences
 * https://leetcode.com/problems/validate-stack-sequences/
 */
private object Solution {

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = ArrayDeque<Int>()
        var i = 0
        var j = 0

        while (i < pushed.size) {
            stack.addFirst(pushed[i++])
            while (j < popped.size && stack.isNotEmpty() && popped[j] == stack.first()) {
                stack.removeFirst()
                j++
            }
        }

        return stack.isEmpty()
    }
}

fun main() {

}