package com.leetcode.tasks.algorithms.`160`.intersection.of.two.linked.lists


/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
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

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val headASize = listSize(headA)
        val headBSize = listSize(headB)
        var diff = Math.abs(headASize.minus(headBSize))

        var startA = headA
        var startB = headB

        if (headASize > headBSize) {
            while (diff != 0) {
                startA = startA?.next
                diff--
            }
        } else if (headASize < headBSize) {
            while (diff != 0) {
                startB = startB?.next
                diff--
            }
        }

        return getResultNode(startA, startB)
    }

    private fun getResultNode(headA: ListNode?, headB: ListNode?): ListNode? {
        return if (headA == headB) headA else getResultNode(headA?.next, headB?.next)
    }

    private fun listSize(head: ListNode?): Int {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        return size
    }

    // more elegant solution - https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/?orderBy=most_votes
    fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
        //boundary check
        if (headA == null || headB == null) return null

        var a = headA
        var b = headB

        //if a & b have different len, then we will stop the loop after second iteration
        while (a !== b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = if (a == null) headB else a.next
            b = if (b == null) headA else b.next
        }

        return a
    }
}

fun main() {

    // --------- 1 ---------
    val l33 = ListNode(5)
    val l32 = ListNode(4, l33)
    val l31 = ListNode(8, l32)

    val l23 = ListNode(1, l31)
    val l22 = ListNode(6, l23)
    val headB = ListNode(5, l22)

    val l12 = ListNode(1, l31)
    val headA = ListNode(2, l12)

    println(Solution.getIntersectionNode1(headA, headB)?.`val`)

}
