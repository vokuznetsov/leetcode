package com.leetcode.tasks.algorithms.`2`.add.two.numbers

import com.leetcode.utility.ListNode

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
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

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var lastNode: ListNode? = head
        var list1 = l1
        var list2 = l2
        var additionalDigit = 0

        while (list1 != null || list2 != null) {
            val x = list1?.`val` ?: 0
            val y = list2?.`val` ?: 0
            val value = x + y + additionalDigit

            additionalDigit = value / 10
            lastNode?.next = ListNode(value % 10)
            lastNode = lastNode?.next

            list1 = list1?.next
            list2 = list2?.next
        }

        if (additionalDigit == 1) {
            lastNode?.next = ListNode(additionalDigit)
        }

        return head.next
    }
}

fun main() {

    println(
        Solution.addTwoNumbers(
            ListNode.create(intArrayOf(2, 4, 3)),
            ListNode.create(intArrayOf(5, 6, 4))
        ) == ListNode.create(intArrayOf(7, 0, 8))
    )

    println(
        Solution.addTwoNumbers(
            ListNode.create(intArrayOf(0)),
            ListNode.create(intArrayOf(0))
        ) == ListNode.create(intArrayOf(0))
    )

    println(
        Solution.addTwoNumbers(
            ListNode.create(intArrayOf(9, 9, 9, 9, 9, 9, 9)),
            ListNode.create(intArrayOf(9, 9, 9, 9))
        ) == ListNode.create(intArrayOf(8, 9, 9, 9, 0, 0, 0, 1))
    )

}