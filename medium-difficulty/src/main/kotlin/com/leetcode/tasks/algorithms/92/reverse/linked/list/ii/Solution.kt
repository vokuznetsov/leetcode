package com.leetcode.tasks.algorithms.`92`.reverse.linked.list.ii

import com.leetcode.utility.ListNode

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii
 */
private object Solution {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head

        var count = 1
        var node = head

        var leftNode: ListNode? = null
        while (count < left) {
            leftNode = node
            node = node?.next
            count++
        }

        val endNode: ListNode? = node

        var prev: ListNode? = null
        var nextNode: ListNode?

        while (count <= right) {
            nextNode = node?.next
            node?.next = prev
            prev = node
            node = nextNode
            count++
        }

        leftNode?.let { it.next = prev }
        endNode?.next = node

        return if (leftNode == null) prev else head
    }
}

fun main() {

    println(
        Solution.reverseBetween(ListNode.create(intArrayOf(1, 2, 3, 4, 5)), 2, 4)
                == ListNode.create(intArrayOf(1, 4, 3, 2, 5))
    )
    println(
        Solution.reverseBetween(ListNode.create(intArrayOf(1, 2, 3, 4, 5)), 3, 4)
                == ListNode.create(intArrayOf(1, 2, 4, 3, 5))
    )
    println(
        Solution.reverseBetween(ListNode.create(intArrayOf(5)), 1, 1) == ListNode.create(intArrayOf(5))
    )
    println(
        Solution.reverseBetween(ListNode.create(intArrayOf(3, 5)), 1, 2) == ListNode.create(intArrayOf(5, 3))
    )
    println(
        Solution.reverseBetween(ListNode.create(intArrayOf(3, 5, 4)), 1, 2) == ListNode.create(intArrayOf(5, 3, 4))
    )
}