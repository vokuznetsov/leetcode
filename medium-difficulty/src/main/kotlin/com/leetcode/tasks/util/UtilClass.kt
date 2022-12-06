package com.leetcode.tasks.util

class ListNode(var `val`: Int, var next: ListNode? = null) {

    companion object {
        fun create(intArray: IntArray): ListNode {
            val head = ListNode(intArray[0])
            var next = head

            for (i in 1..intArray.lastIndex) {
                next.next = ListNode(intArray[i])
                next = next.next!!
            }
            return head
        }
    }
}