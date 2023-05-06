package com.leetcode.tasks.algorithms.`104`.maximum.depth.of.binary.tree

import com.leetcode.utility.TreeNode

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
private object Solution {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}

fun main() {

    println(Solution.maxDepth(TreeNode.create(arrayOf(1, 2, 3))) == 2)
    println(Solution.maxDepth(TreeNode.create(arrayOf(1, 2, 2, 3, 4, 4, 3))) == 3)

}
