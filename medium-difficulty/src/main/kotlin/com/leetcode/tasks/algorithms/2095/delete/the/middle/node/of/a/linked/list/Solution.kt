package com.leetcode.tasks.algorithms.`2095`.delete.the.middle.node.of.a.linked.list

import com.leetcode.utility.ListNode


/**
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
private object Solution {

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var slow = head
        var fast = head
        var previous: ListNode? = null

        while (fast?.next != null) {
            previous = slow
            slow = slow?.next
            fast = fast.next?.next
        }

        previous?.next = slow?.next

        return head
    }
}

fun main() {

}