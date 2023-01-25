package com.leetcode.tasks.sql.`124`.binary.tree.maximum.path.sum

import com.leetcode.utility.TreeNode


/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
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

    var maximum = -2000

    fun maxPathSum(root: TreeNode?): Int {
        maximum = -2000
        maxSum(root)
        return maximum
    }

    private fun maxSum(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxSum(root.left).let { if (it < 0) 0 else it }
        val right = maxSum(root.right).let { if (it < 0) 0 else it }

        maximum = Math.max(maximum, root.`val` + left + right)

        return Math.max(left + root.`val`, right + root.`val`)
    }

}

fun main() {

    println(Solution.maxPathSum(TreeNode.create(arrayOf(5))) == 5)
    println(Solution.maxPathSum(TreeNode.create(arrayOf(2, -1))) == 2)
    println(Solution.maxPathSum(TreeNode.create(arrayOf(1, 2, 3))) == 6)
    println(Solution.maxPathSum(TreeNode.create(arrayOf(-10, 9, 20, null, null, 15, 7))) == 42)
    println(Solution.maxPathSum(TreeNode.create(arrayOf(-10, 9, 20, null, null, 15, 35, null, null, null, -100))) == 70)
    println(
        Solution.maxPathSum(
            TreeNode.create(
                arrayOf(100, 0, -10, null, null, 10, 20, null, null, 15, 35, null, null, null, -100)
            )
        ) == 145
    )
    println(
        Solution.maxPathSum(
            TreeNode.create(arrayOf(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6))
        ) == 16
    )
}