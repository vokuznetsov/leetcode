package com.leetcode.tasks.algorithms.`232`.implement.queue.using.stacks

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

        return stack2.removeLast()
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
    val myQueue1 = MyQueue()
    myQueue1.push(1) // queue is: [1]
    myQueue1.push(2) // queue is: [1, 2] (leftmost is front of the queue)
    println(myQueue1.peek() == 1) // return 1
    println(myQueue1.pop() == 1) // return 1, queue is [2]
    println(!myQueue1.empty()) // return false

    // --------- 2 ---------
    val myQueue2 = MyQueue()
    myQueue2.push(1) // queue is: [1]
    myQueue2.push(2) // queue is: [1, 2] (leftmost is front of the queue)
    println(myQueue2.pop() == 1) // return 1
    println(myQueue2.peek() == 2) // return 2
    println(!myQueue2.empty()) // return false

    // --------- 3 ---------
    val myQueue3 = MyQueue()
    myQueue3.push(1) // queue is: [1]
    myQueue3.push(2) // queue is: [1, 2] (leftmost is front of the queue)
    println(myQueue3.pop() == 1) // return 1
    myQueue3.push(3) // queue is: [2, 3]
    myQueue3.push(4) // queue is: [2, 3, 4] (leftmost is front of the queue)
    println(myQueue3.pop() == 2) // return 2
    println(myQueue3.peek() == 3) // return 3

}
