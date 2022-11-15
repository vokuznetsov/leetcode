package com.leetcode.tasks.algorithms.`145`.binary.tree.postorder.traversal

import java.util.ArrayDeque
import java.util.LinkedList

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return postorderTraversal(root.left) + postorderTraversal(root.right) + listOf(root.`val`)
    }

    fun postorderTraversalStack(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        val stack = ArrayDeque<TreeNode>()
        root?.let { stack.add(it) }

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            list.addFirst(node.`val`)

            node.left?.let { stack.add(it) }
            node.right?.let { stack.add(it) }
        }

        return list
    }
}

fun main() {

    val tree1 = TreeNode(1, TreeNode(2), TreeNode(3))
    println(Solution.postorderTraversalStack(tree1))

    val tree2 = TreeNode(1, null, TreeNode(2, TreeNode(3)))
    println(Solution.postorderTraversalStack(tree2))

    println(Solution.postorderTraversalStack(null))

    val tree3 = TreeNode(1)
    println(Solution.postorderTraversalStack(tree3))
}
