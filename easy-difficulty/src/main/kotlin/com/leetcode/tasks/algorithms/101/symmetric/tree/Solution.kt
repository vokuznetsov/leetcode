package com.leetcode.tasks.`101`.symmetric.tree

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun isSymmetric(root: TreeNode?): Boolean {
        return if (root == null) true else isSymmetric(root.left, root.right)
    }

    fun isSymmetric(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 == null || root2 == null) return false
        return if (root1.`val` == root2.`val`) isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left) else false
    }
}

fun main() {

    val tree1 = TreeNode(
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
    println(Solution.isSymmetric(tree1))

    val tree2 = TreeNode(
        1,
        TreeNode(
            2,
            null, TreeNode(3)
        ),
        TreeNode(
            2,
            null, TreeNode(3)
        )
    )
    println(Solution.isSymmetric(tree2))


}
