package com.leetcode.tasks.algorithms.`141`.linked.list.cycle

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
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

private class ListNode(var `val`: Int, var next: ListNode? = null)

private object Solution {

    // complexity - O(n),  memory - O(n)
    fun hasCycle(head: ListNode?): Boolean {
        val markedSet = mutableSetOf<ListNode>()
        var node = head

        while (node != null) {
            if (markedSet.contains(node)) return true
            markedSet.add(node)
            node = node.next
        }

        return false
    }

    // complexity - O(n),  memory - O(1)
    fun hasCycle1(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (slow != null && fast?.next != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) return true
        }

        return false
    }

}

fun main() {

    // --------- 1 ---------
    val l14 = ListNode(-4)
    val l13 = ListNode(0, l14)
    val l12 = ListNode(2, l13)
    val l11 = ListNode(3, l12)
    l14.next = l12
    println(Solution.hasCycle1(l11))

    // --------- 2 ---------
    val l22 = ListNode(2)
    val l21 = ListNode(1, l22)
    l22.next = l21
    println(Solution.hasCycle1(l21))

    // --------- 3 ---------
    val l31 = ListNode(1)
    println(Solution.hasCycle1(l31))

}
