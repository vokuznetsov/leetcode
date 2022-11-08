package com.leetcode.tasks.algorithms.`111`.minimum.depth.of.binary.tree

import kotlin.math.min

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        if (root.left == null) return 1 + minDepth(root.right)
        if (root.right == null) return 1 + minDepth(root.left)
        return 1 + min(minDepth(root.left), minDepth(root.right))
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
    println(Solution.minDepth(t1) == 2)

    val t2 = TreeNode(
        2,
        left = null,
        right = TreeNode(
            3,
            left = null,
            right = TreeNode(
                4,
                left = null,
                right = TreeNode(
                    5,
                    left = null,
                    right = TreeNode(6)
                )
            )
        )
    )
    println(Solution.minDepth(t2))
}
