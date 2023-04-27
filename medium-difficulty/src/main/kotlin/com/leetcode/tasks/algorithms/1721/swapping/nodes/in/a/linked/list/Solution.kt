package com.leetcode.tasks.algorithms.`1721`.swapping.nodes.`in`.a.linked.list

import com.leetcode.utility.ListNode

/**
 * 1721. Swapping Nodes in a Linked List
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
private object Solution {

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var startNode: ListNode? = dummy

        for (i in 1..k) {
            startNode = startNode?.next
        }

        var endNode: ListNode? = dummy
        var end: ListNode? = startNode

        while (end != null) {
            endNode = endNode?.next
            end = end?.next
        }

        val temp = startNode?.`val`
        startNode?.`val` = endNode?.`val`!!
        endNode?.`val` = temp!!

        return dummy.next
    }
}

fun main() {

    println(
        Solution.swapNodes(ListNode.create(intArrayOf(1, 2, 3, 4, 5)), 2) == ListNode.create(
            intArrayOf(
                1,
                4,
                3,
                2,
                5
            )
        )
    )
    println(
        Solution.swapNodes(ListNode.create(intArrayOf(7, 9, 6, 6, 7, 8, 3, 0, 9, 5)), 5) == ListNode.create(
            intArrayOf(7, 9, 6, 6, 8, 7, 3, 0, 9, 5)
        )
    )
}