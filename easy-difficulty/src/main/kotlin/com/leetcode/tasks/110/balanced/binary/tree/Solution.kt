package com.leetcode.tasks.`110`.balanced.binary.tree

import kotlin.math.abs

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    private var result = true

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        else getTreeHeight(root)
        return result
    }

    fun getTreeHeight(root: TreeNode?): Int {
        if (root == null) return 0
        val left = getTreeHeight(root.left)
        val right = getTreeHeight(root.right)
        if (abs(left - right) > 1) result = false
        return 1 + maxOf(left, right)
    }

}

fun main() {
    val t1 = TreeNode(
        3,
        TreeNode(9),
        TreeNode(
            20,
            TreeNode(15), TreeNode(7)
        )
    )
    println(Solution.isBalanced(t1))

    val t2 = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(3, TreeNode(4), TreeNode(4)),
            TreeNode(3)
        ),
        TreeNode(2)
    )
    println(Solution.isBalanced(t2))


    val t3 = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(
                3,
                TreeNode(4)
            )
        ),
        TreeNode(
            2,
            null,
            TreeNode(
                3,
                null,
                TreeNode(4)
            )
        )
    )
    println(Solution.isBalanced(t3))
}
