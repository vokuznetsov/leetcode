package com.leetcode.tasks.`144`.binary.tree.preorder.traversal

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
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

    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return listOf(root.`val`) + preorderTraversal(root.left) + preorderTraversal(root.right)
    }

    fun preorderTraversalStack(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        root?.let { stack.add(it) }

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            list.add(node.`val`)

            node.right?.let { stack.add(it) }
            node.left?.let { stack.add(it) }
        }

        return list
    }
}

fun main() {

    val tree1 = TreeNode(1, TreeNode(2), TreeNode(3))
    println(Solution.preorderTraversalStack(tree1))

    val tree2 = TreeNode(1, null, TreeNode(2, TreeNode(3)))
    println(Solution.preorderTraversalStack(tree2))

    println(Solution.preorderTraversalStack(null))

    val tree3 = TreeNode(1)
    println(Solution.preorderTraversalStack(tree3))
}
