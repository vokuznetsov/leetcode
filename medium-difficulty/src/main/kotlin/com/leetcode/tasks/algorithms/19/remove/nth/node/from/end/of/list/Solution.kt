package com.leetcode.tasks.algorithms.`19`.remove.nth.node.from.end.of.list

import com.leetcode.utility.ListNode


/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
private object Solution {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var start: ListNode? = dummy
        var end: ListNode? = dummy

        for (i in 0..n) {
            end = end?.next
        }

        while (end != null) {
            start = start?.next
            end = end?.next
        }
        start?.next = start?.next?.next


        return dummy.next
    }
}

fun main() {

    println(
        Solution.removeNthFromEnd(
            ListNode.create(intArrayOf(1, 2, 3, 4, 5)),
            2
        ) == ListNode.create(intArrayOf(1, 2, 3, 5))
    )

    println(
        Solution.removeNthFromEnd(
            ListNode.create(intArrayOf(1)),
            1
        ) == null
    )

    println(
        Solution.removeNthFromEnd(
            ListNode.create(intArrayOf(1, 2)),
            1
        ) == ListNode.create(intArrayOf(1))
    )

    println(
        Solution.removeNthFromEnd(
            ListNode.create(intArrayOf(1, 2)),
            2
        ) == ListNode.create(intArrayOf(2))
    )
}