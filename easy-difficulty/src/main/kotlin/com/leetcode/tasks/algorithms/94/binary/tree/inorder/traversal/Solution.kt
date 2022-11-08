package com.leetcode.tasks.algorithms.`94`.binary.tree.inorder.traversal

import kotlin.random.Random

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {


    companion object {
        fun createFromList(list: List<Int>): TreeNode? =
            if (list.isEmpty()) {
                null
            } else {
                list.reversed().fold(null as? TreeNode) { acc, i ->
                    if (Random.nextBoolean()) {
                        TreeNode(i, acc)
                    } else {
                        TreeNode(i, right = acc)
                    }
                }
            }
    }
}

private object Solution {

    fun inorderTraversal1(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorderTraversal(root, result)
        return result
    }

    fun inorderTraversal(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return

        inorderTraversal(root.left, list)
        list.add(root.`val`)
        inorderTraversal(root.right, list)
    }

    /*fun inorderTraversal2(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val result = mutableListOf<Int>()

        var head = root

        while (head.left != null) {

        }

        return result
    }*/
}

fun main() {

    println(Solution.inorderTraversal1(TreeNode.createFromList(listOf(1, 5, 17, 8, 9, 10, 23))).size == 7)

}
