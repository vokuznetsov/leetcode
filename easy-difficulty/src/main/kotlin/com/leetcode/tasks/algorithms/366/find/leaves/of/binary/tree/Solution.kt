package com.leetcode.tasks.algorithms.`366`.find.leaves.of.binary.tree

import com.leetcode.utility.TreeNode

/**
 * 366. Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
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

private object Solution {

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val head = root
        val result = mutableListOf<List<Int>>()

        while (!isLeaf(head)) {
            val leaves = mutableListOf<Int>()
            traversal(head, leaves)
            result.add(leaves)
        }

        result.add(listOf(head.`val`))
        return result
    }

    private fun traversal(root: TreeNode, leaves: MutableList<Int>) {


        root.left?.let {
            if (isLeaf(it)) {
                leaves.add(it.`val`)
                root.left = null
            } else traversal(it, leaves)
        }

        root.right?.let {
            if (isLeaf(it)) {
                leaves.add(it.`val`)
                root.right = null
            } else traversal(it, leaves)
        }
    }

    private fun isLeaf(root: TreeNode): Boolean = root.left == null && root.right == null

}

fun main() {

    println(
        Solution.findLeaves(TreeNode.create(arrayOf(1, 2, 3, 4, 5))) == listOf(listOf(4, 5, 3), listOf(2), listOf(1))
    )

    println(Solution.findLeaves(TreeNode.create(arrayOf(1))) == listOf(listOf(1)))

}
