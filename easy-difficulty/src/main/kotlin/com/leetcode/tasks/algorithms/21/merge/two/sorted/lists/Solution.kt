package com.leetcode.tasks.algorithms.`21`.merge.two.sorted.lists

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` <= list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }

}

fun main() {
    // --------- 1 ---------
    val l11 = ListNode.createFromList(listOf(1, 2, 4))
    val l12 = ListNode.createFromList(listOf(1, 3, 4))
    println(Solution.mergeTwoLists(l11, l12) == ListNode.createFromList(listOf(1, 1, 2, 3, 4, 4)))

    // --------- 2 ---------
    val l21 = ListNode.createFromList(emptyList())
    val l22 = ListNode.createFromList(emptyList())
    println(Solution.mergeTwoLists(l21, l22) == ListNode.createFromList(listOf()))

    // --------- 3 ---------
    val l31 = ListNode.createFromList(emptyList())
    val l32 = ListNode.createFromList(listOf(0))
    println(Solution.mergeTwoLists(l31, l32) == ListNode.createFromList(listOf(0)))


    // --------- 4 ---------
    val l41 = ListNode.createFromList(listOf(1, 8))
    val l42 = ListNode.createFromList(listOf(3, 4, 7, 11))
    println(Solution.mergeTwoLists(l41, l42) == ListNode.createFromList(listOf(1, 3, 4, 7, 8, 11)))

    // --------- 5 ---------
    val l51 = ListNode.createFromList(listOf(3, 4, 7, 11))
    val l52 = ListNode.createFromList(listOf(1, 8))
    println(Solution.mergeTwoLists(l51, l52) == ListNode.createFromList(listOf(1, 3, 4, 7, 8, 11)))

}

