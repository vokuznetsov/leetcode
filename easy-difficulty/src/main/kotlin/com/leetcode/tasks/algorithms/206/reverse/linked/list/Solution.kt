package com.leetcode.tasks.algorithms.`206`.reverse.linked.list

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
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

private data class ListNode(var `val`: Int, var next: ListNode? = null)

private object Solution {

    private var reverseHead: ListNode? = null

    // recursion
    fun reverseList(head: ListNode?): ListNode? {
        reverse(head)
        return reverseHead
    }

    fun reverse(head: ListNode?): ListNode? {
        if (head?.next != null) {
            val node = reverse(head.next)
            head.next = null
            node?.next = head
        } else reverseHead = head

        return head
    }

    // iteratively
    fun reverseList1(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null

        while (current?.next != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        current?.next = previous
        return current
    }
}

fun main() {

    // --------- 1 ---------
    val l15 = ListNode(5)
    val l14 = ListNode(4, l15)
    val l13 = ListNode(3, l14)
    val l12 = ListNode(2, l13)
    val l11 = ListNode(1, l12)

    val result11 = ListNode(1)
    val result12 = ListNode(2, result11)
    val result13 = ListNode(3, result12)
    val result14 = ListNode(4, result13)
    val result15 = ListNode(5, result14)

    val result = Solution.reverseList1(l11)
    println(result == result15)

    // --------- 2 ---------
    val l22 = ListNode(2)
    val l21 = ListNode(1, l22)

    val result21 = ListNode(2)
    val result22 = ListNode(1, result21)
    println(Solution.reverseList1(l21) == result22)

    // --------- 3 ---------
    println(Solution.reverseList1(null))

}
