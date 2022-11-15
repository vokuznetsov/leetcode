package com.leetcode.tasks.algorithms.`232`.implement.queue.using.stacks

import java.util.ArrayDeque

/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

class MyQueue {

    val stack1 = ArrayDeque<Int>()
    val stack2 = ArrayDeque<Int>()
    var top: Int? = null

    fun push(x: Int) {
        if (stack1.isEmpty()) top = x
        stack1.add(x)
    }

    fun pop(): Int {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast())
            }
        }

        val result = stack2.removeLast()
        if (!stack2.isEmpty()) top = stack2.last()
        return result
    }

    fun peek(): Int {
        return if (!stack2.isEmpty()) stack2.last() else top!!
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

}

fun main() {

    // --------- 1 ---------
    val myQueue = MyQueue()
    myQueue.push(1) // queue is: [1]
    myQueue.push(2) // queue is: [1, 2] (leftmost is front of the queue)
    println(myQueue.peek()) // return 1
    println(myQueue.pop()) // return 1, queue is [2]
    println(myQueue.empty()) // return false

}
