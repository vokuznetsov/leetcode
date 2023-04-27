package com.leetcode.tasks.algorithms.`2130`.maximum.twin.sum.of.a.linked.list

import com.leetcode.utility.ListNode


/**
 * 2130. Maximum Twin Sum of a Linked List
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
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

    fun pairSum(head: ListNode?): Int {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var prev: ListNode? = null

        while (slow != null) {
            val nextNode = slow?.next
            slow?.next = prev
            prev = slow
            slow = nextNode
        }

        var curr = head
        var max = Int.MIN_VALUE
        while (prev != null && curr != null) {
            max = Math.max(max, prev?.`val` + curr?.`val`)
            prev = prev?.next
            curr = curr?.next
        }

        return max
    }
}

fun main() {

}