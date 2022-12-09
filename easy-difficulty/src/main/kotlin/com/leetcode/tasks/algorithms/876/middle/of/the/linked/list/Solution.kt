package com.leetcode.tasks.algorithms.`876`.middle.of.the.linked.list

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */

private class ListNode(var `val`: Int, var next: ListNode? = null)

private object Solution {

    // O(n) - time and space
    fun middleNode(head: ListNode?): ListNode? {
        val arr = mutableListOf<ListNode>()
        var node = head
        var size = 0

        while (node != null) {
            arr.add(node)
            size++
            node = node.next
        }

        return arr[size / 2]
    }

    // O(n) - time, O(1) - space
    fun middleNode1(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {

    // --------- 1 ---------
    val l15 = ListNode(5)
    val l14 = ListNode(4, l15)
    val l13 = ListNode(3, l14)
    val l12 = ListNode(2, l13)
    val l11 = ListNode(1, l12)

    println(Solution.middleNode1(l11) == l13)

    // --------- 2 ---------
    val l25 = ListNode(6)
    val l24 = ListNode(5, l25)
    val l23 = ListNode(4, l24)
    val l22 = ListNode(3, l23)
    val l21 = ListNode(2, l22)
    val l20 = ListNode(1, l21)

    println(Solution.middleNode1(l20) == l23)

}
