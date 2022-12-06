package com.leetcode.tasks.algorithms.`328`.odd.even.linked.list

import com.leetcode.tasks.util.ListNode

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
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

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        val evenHead = head.next!!

        var next = evenHead.next
        var odd: ListNode = head
        var even: ListNode = evenHead
        var count = 1

        while (next != null) {
            if (count % 2 == 0) {
                even.next = next
                even = next
            } else {
                odd.next = next
                odd = next
            }
            next = next.next
            count++
        }

        even.next = null
        odd.next = evenHead
        return head
    }
}

fun main() {

    // --------- 1 ---------
    val l1 = ListNode.create(intArrayOf(1, 2, 3, 4, 5))
    println(Solution.oddEvenList(l1) == ListNode.create(intArrayOf(1, 3, 5, 2, 4)))

    // --------- 2 ---------
    val l2 = ListNode.create(intArrayOf(2, 1, 3, 5, 6, 4, 7))
    println(Solution.oddEvenList(l2) == ListNode.create(intArrayOf(2, 3, 6, 7, 1, 5, 4)))

}