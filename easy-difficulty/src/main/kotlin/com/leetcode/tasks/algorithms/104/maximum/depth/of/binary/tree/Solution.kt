package com.leetcode.tasks.`104`.maximum.depth.of.binary.tree

import kotlin.math.max

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    var maxLevel: Int = 0

    fun maxDepth(root: TreeNode?): Int {
        if (root != null) maxDepth(root, 0)
        return maxLevel
    }

    fun maxDepth(root: TreeNode?, level: Int) {
        if (root == null) {
            if (level > maxLevel) maxLevel = level
            return
        }
        maxDepth(root.left, level + 1)
        maxDepth(root.right, level + 1)
    }

    fun maxDepthElegant(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}

fun main() {

    val t1 = TreeNode(1, TreeNode(2), TreeNode(3))
    println(Solution.maxDepthElegant(t1) == 2)

    val t2 = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(3), TreeNode(4)
        ),
        TreeNode(
            2,
            TreeNode(4), TreeNode(3)
        )
    )
    println(Solution.maxDepthElegant(t2) == 3)


}
