package com.leetcode.tasks.algorithms.`83`.remove.duplicates.from.sorted.list

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 */

private data class ListNode(var `val`: Int, var next: ListNode? = null) {

    companion object {
        fun createFromList(list: List<Int>): ListNode? =
            if (list.isEmpty()) {
                null
            } else {
                list.reversed().fold(null as? ListNode) { acc, i -> ListNode(i, acc) }
            }
    }
}


private object Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {

        var next = head
        while (next != null) {
            if (next.`val` == next.next?.`val`) {
                next.next = next.next?.next
            } else {
                next = next.next
            }
        }

        return head
    }

    fun deleteDuplicates1(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var slow = head
        var fast = head.next

        while (fast != null) {
            if (slow?.`val` == fast?.`val`) {
                slow.next = fast.next
            } else {
                slow = slow?.next
            }
            fast = fast.next
        }
        return head
    }
}

fun main() {
    // --------- 1 ---------
    val l11 = ListNode.createFromList(listOf(1, 2, 4))
    println(Solution.deleteDuplicates(l11) == ListNode.createFromList(listOf(1, 2, 4)))

    // --------- 2 ---------
    val l21 = ListNode.createFromList(emptyList())
    println(Solution.deleteDuplicates(l21) == ListNode.createFromList(listOf()))

    // --------- 3 ---------
    val l31 = ListNode.createFromList(listOf(1, 1, 2))
    println(Solution.deleteDuplicates(l31) == ListNode.createFromList(listOf(1, 2)))


    // --------- 4 ---------
    val l41 = ListNode.createFromList(listOf(1, 8, 8, 11, 12, 12, 16))
    println(Solution.deleteDuplicates(l41) == ListNode.createFromList(listOf(1, 8, 11, 12, 16)))

    // --------- 5 ---------
    val l51 = ListNode.createFromList(listOf(3, 4, 7, 11))
    println(Solution.deleteDuplicates(l51) == ListNode.createFromList(listOf(3, 4, 7, 11)))

    // --------- 6 ---------
    val l61 = ListNode.createFromList(listOf(3, 4, 7, 11, 11, 11))
    println(Solution.deleteDuplicates(l61) == ListNode.createFromList(listOf(3, 4, 7, 11)))

}

