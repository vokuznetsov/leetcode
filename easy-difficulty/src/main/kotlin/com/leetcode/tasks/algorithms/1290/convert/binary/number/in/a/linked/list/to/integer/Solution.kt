package com.leetcode.tasks.algorithms.`1290`.convert.binary.number.`in`.a.linked.list.to.integer

import com.leetcode.utility.ListNode

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
private object Solution {

    fun getDecimalValue(head: ListNode?): Int {
        var curr = head
        var num = 0

        while(curr != null) {
            num = num*2 + curr?.`val`
            curr = curr?.next
        }

        return num
    }
}

fun main() {

}