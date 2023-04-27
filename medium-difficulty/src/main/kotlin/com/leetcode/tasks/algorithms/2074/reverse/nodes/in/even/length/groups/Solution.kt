package com.leetcode.tasks.algorithms.`2074`.reverse.nodes.`in`.even.length.groups

import com.leetcode.utility.ListNode

/**
 * 2074. Reverse Nodes in Even Length Groups
 * https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 */
private object Solution {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        var lastGroup = head
        var start = 1
        var end = 1
        var count = 1
        var group = 1
        var curr = head

        var startNode = curr

        while (curr != null) {
            if (count == end) lastGroup = curr
            if (count > end) {
                group++
                start = end + 1
                end = end + group
            }

            if (group % 2 == 0) {
                var prev: ListNode? = null
                startNode = curr
                var nextNode: ListNode? = null
                while (curr != null && count <= end) {
                    nextNode = curr?.next
                    curr?.next = prev
                    prev = curr
                    curr = nextNode
                    count++
                }
                startNode?.next = curr
                lastGroup?.next = prev

                if (count <= end) startNode = prev else lastGroup = startNode
            } else {
                curr = curr?.next
                count++
            }
        }

        val even = (count - start) % 2 == 0
        val evenGroup = group % 2 == 0

        if ((evenGroup && !even) || (!evenGroup && even)) {
            curr = if (evenGroup) startNode else lastGroup?.next
            var prev: ListNode? = null
            while (curr != null) {
                var nextNode = curr?.next
                curr?.next = prev
                prev = curr
                curr = nextNode
            }
            lastGroup?.next = prev
        }
        return head
    }
}

fun main() {

    println(
        Solution.reverseEvenLengthGroups(ListNode.create(intArrayOf(5, 2, 6, 3, 9, 1, 7, 3, 8, 4)))
                == ListNode.create(intArrayOf(5, 6, 2, 3, 9, 1, 4, 8, 3, 7))
    )

    println(
        Solution.reverseEvenLengthGroups(ListNode.create(intArrayOf(1, 1, 0, 6)))
                == ListNode.create(intArrayOf(1, 0, 1, 6))
    )

    println(
        Solution.reverseEvenLengthGroups(ListNode.create(intArrayOf(1, 1, 0, 6, 5)))
                == ListNode.create(intArrayOf(1, 0, 1, 5, 6))
    )

    println(
        Solution.reverseEvenLengthGroups(ListNode.create(intArrayOf(4, 3, 0, 5, 1, 2, 7, 8, 6)))
                == ListNode.create(intArrayOf(4, 0, 3, 5, 1, 2, 7, 8, 6))
    )

}
