package com.leetcode.tasks.algorithms.`234`.palindrome.linked.list

import com.leetcode.utility.ListNode

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */
private object Solution {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true

        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var middle = if (fast == null) reverseList(slow) else reverseList(slow?.next)

        var start = head
        while (middle != null) {
            if (start?.`val` != middle?.`val`) return false
            middle = middle?.next
            start = start?.next
        }

        return true
    }

    private fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var previous: ListNode? = null
        var curr = head
        var nextNode: ListNode? = null

        while (curr != null) {
            nextNode = curr?.next
            curr?.next = previous
            previous = curr
            curr = nextNode
        }
        return previous
    }
}

fun main() {

    println(
        Solution.isPalindrome(ListNode.create(intArrayOf(1,2,2,1)))
    )

    println(
        !Solution.isPalindrome(ListNode.create(intArrayOf(1,2)))
    )

}