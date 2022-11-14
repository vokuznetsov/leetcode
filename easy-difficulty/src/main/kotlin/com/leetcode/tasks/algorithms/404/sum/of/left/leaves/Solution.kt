package com.leetcode.tasks.algorithms.`404`.sum.of.left.leaves

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
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

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0

        val leftSum = if (isLeaf(root.left)) root.left!!.`val` else sumOfLeftLeaves(root.left)
        return leftSum + sumOfLeftLeaves(root.right)
    }

    private fun isLeaf(node: TreeNode?): Boolean = node != null && node.left == null && node.right == null
}

fun main() {

    val tree1 = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    println(Solution.sumOfLeftLeaves(tree1) == 24)

    val tree2 = TreeNode(1)
    println(Solution.sumOfLeftLeaves(tree2) == 0)

}
