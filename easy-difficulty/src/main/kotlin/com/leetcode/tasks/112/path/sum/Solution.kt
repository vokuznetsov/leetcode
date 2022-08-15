package com.leetcode.tasks.`112`.path.sum

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return hasPathSum(root, 0, targetSum)
    }

    fun hasPathSum(root: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
        if (root == null) return false
        val sum = currentSum + root.`val`
        if (sum == targetSum && root.left == null && root.right == null) return true
        return hasPathSum(root.left, sum, targetSum) || hasPathSum(root.right, sum, targetSum)
    }

}

fun main() {

    // [5,4,8,11,null,13,4,7,2,null,null,null,1]
    val t1 = TreeNode(
        5,
        left = TreeNode(
            4,
            left = TreeNode(
                11,
                left = TreeNode(7),
                right = TreeNode(2)
            ),
            right = null
        ),
        right = TreeNode(
            8,
            left = TreeNode(
                13
            ),
            right = TreeNode(
                4,
                left = null,
                right = TreeNode(1)
            )
        )
    )
    println(Solution.hasPathSum(t1, 22))

    val t2 = TreeNode(
        1,
        left = TreeNode(2)
    )
    println(Solution.hasPathSum(t2, 1))

}
