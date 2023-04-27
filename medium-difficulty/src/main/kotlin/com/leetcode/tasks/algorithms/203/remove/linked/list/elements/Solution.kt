package com.leetcode.tasks.algorithms.`203`.remove.linked.list.elements

import com.leetcode.utility.ListNode

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
private object Solution {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val sentinel = ListNode(0)
        sentinel.next = head
        var previous = sentinel
        var curr = head

        while (curr != null) {
            if (curr.`val` == `val`)
                previous?.next = curr?.next
            else
                previous = curr
            curr = curr?.next
        }

        return sentinel.next
    }
}

fun main() {


}