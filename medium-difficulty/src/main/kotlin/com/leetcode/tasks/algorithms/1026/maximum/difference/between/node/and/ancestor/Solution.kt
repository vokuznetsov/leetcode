package com.leetcode.tasks.algorithms.`1026`.maximum.difference.between.node.and.ancestor

import com.leetcode.utility.TreeNode

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
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

    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0

        return maxAncestorDiff(root, root.`val`, root.`val`)
    }

    private fun maxAncestorDiff(root: TreeNode?, min: Int, max: Int): Int {
        if (root == null) return Math.abs(max - min)

        val currMin = if (root.`val` < min) root.`val` else min
        val currMax = if (root.`val` > max) root.`val` else max

        return Math.max(maxAncestorDiff(root.left, currMin, currMax), maxAncestorDiff(root.right, currMin, currMax))
    }
}

fun main() {

    println(Solution.maxAncestorDiff(TreeNode.create(arrayOf(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13))) == 7)
    println(Solution.maxAncestorDiff(TreeNode.create(arrayOf(1, null, 2, null, 0, 3))) == 3)
    println(Solution.maxAncestorDiff(null) == 0)

}