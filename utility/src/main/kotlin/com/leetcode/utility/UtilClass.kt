package com.leetcode.utility

data class ListNode(var `val`: Int, var next: ListNode? = null) {

    companion object {
        fun create(intArray: IntArray): ListNode {
            val head = ListNode(intArray[0])
            var next = head

            for (i in 1..intArray.lastIndex) {
                next.next = ListNode(intArray[i])
                next = next.next!!
            }
            return head
        }
    }
}

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {

    companion object {
        fun create(intArray: Array<Int?>): TreeNode? {
            if (intArray.isEmpty()) return null
            val headTree = TreeNode(intArray[0]!!)

            val stack = ArrayDeque<TreeNode>()
            stack.addLast(headTree)

            var index = 1

            while (index != intArray.size) {
                val tree = if (index % 2 == 0) stack.removeFirst() else stack.first()

                val node = intArray[index]?.let {
                    val n = TreeNode(it)
                    stack.addLast(n)
                    n
                }

                if (index % 2 != 0) tree.left = node else tree.right = node

                index++
            }

            return headTree
        }
    }
}