package com.leetcode.tasks.algorithms.`82`.remove.duplicates.from.sorted.list.ii

import com.leetcode.utility.ListNode

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
private object Solution {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var prev: ListNode? = dummy
        var curr = head

        while (curr != null) {
            var hasDuplicates = false
            while(curr?.`val` == curr?.next?.`val`) {
                curr = curr?.next
                hasDuplicates = true
            }
            if (!hasDuplicates) {
                prev?.next = curr
                prev = curr
                curr = curr?.next
            } else {
                curr = curr?.next
                prev?.next = curr
            }
        }

        return dummy.next
    }
}

fun main() {


}