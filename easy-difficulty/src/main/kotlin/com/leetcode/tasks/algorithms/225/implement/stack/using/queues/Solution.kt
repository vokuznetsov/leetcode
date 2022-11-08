package com.leetcode.tasks.algorithms.`225`.implement.stack.using.queues

import java.util.LinkedList

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */

private class MyStack {

    private var queue1 = LinkedList<Int>()
    private var queue2 = LinkedList<Int>()
    private var last: Int? = null

    fun push(x: Int) {
        queue1.add(x)
        last = x
    }

    fun pop(): Int {
        while (queue1.size > 1) {
            val pop = queue1.pop()
            queue2.add(pop)
            last = pop
        }
        val result = queue1.pop()
        queue1 = queue2
        queue2 = LinkedList()
        return result
    }

    fun top(): Int {
        return last ?: throw NoSuchElementException("")
    }

    fun empty(): Boolean {
        return queue1.isEmpty()
    }
}

fun main() {
    // --------- 1 ---------
    val myStack1 = MyStack()
    myStack1.push(1)
    myStack1.push(2)
    println(myStack1.top()) // return 2
    println(myStack1.pop()) // return 2
    println(myStack1.empty()) // return False

    // --------- 2 ---------
    val myStack2 = MyStack()
    myStack2.push(1)
    println(myStack2.pop()) // return 1
    println(myStack2.empty()) // return True
}
