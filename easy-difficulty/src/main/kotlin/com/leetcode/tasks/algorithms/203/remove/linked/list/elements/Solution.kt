package com.leetcode.tasks.algorithms.`203`.remove.linked.list.elements

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
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

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        head.next = removeElements(head?.next, `val`)
        return if (head.`val` == `val`) head.next else head
    }
}

fun main() {

    // --------- 1 ---------
    val l17 = ListNode(6)
    val l16 = ListNode(5, l17)
    val l15 = ListNode(4, l16)
    val l14 = ListNode(3, l15)
    val l13 = ListNode(6, l14)
    val l12 = ListNode(2, l13)
    val l11 = ListNode(1, l12)

    val l115 = ListNode(5)
    val l114 = ListNode(4, l115)
    val l113 = ListNode(3, l114)
    val l112 = ListNode(2, l113)
    val l111 = ListNode(1, l112)

    println(Solution.removeElements(l11, 6) == l111)

    // --------- 2 ---------
    println(Solution.removeElements(null, 1) == null)

    // --------- 3 ---------
    val l34 = ListNode(7)
    val l33 = ListNode(7, l34)
    val l32 = ListNode(7, l33)
    val l31 = ListNode(7, l32)
    println(Solution.removeElements(l31, 7) == null)

}
