package com.leetcode.tasks.`234`.palindrome.linked.list

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
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

    fun isPalindrome(head: ListNode?): Boolean {
        val stack = ArrayDeque<Int>()
        fulfillStack(head, stack)

        while (stack.size > 1) {
            if (stack.removeFirst() != stack.removeLast()) return false
        }

        return true
    }

    fun fulfillStack(head: ListNode?, stack: ArrayDeque<Int>) {
        if (head == null) return
        else {
            stack.add(head.`val`)
            fulfillStack(head.next, stack)
        }
    }
}

fun main() {

    println(Solution.isPalindrome(ListNode.createFromList(listOf(1))))
    println(Solution.isPalindrome(ListNode.createFromList(listOf(1, 2))))
    println(Solution.isPalindrome(ListNode.createFromList(listOf(1, 2, 2, 1))))
    println(Solution.isPalindrome(ListNode.createFromList(listOf(1, 2, 3, 2, 1))))
    println(Solution.isPalindrome(ListNode.createFromList(listOf(1, 2, 3, 5, 1))))

}
