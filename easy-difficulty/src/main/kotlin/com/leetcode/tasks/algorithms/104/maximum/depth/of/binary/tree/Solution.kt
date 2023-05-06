package com.leetcode.tasks.algorithms.`104`.maximum.depth.of.binary.tree

import com.leetcode.utility.TreeNode
import kotlin.math.max

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */


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

    println(Solution.maxDepthElegant(TreeNode.create(arrayOf(1, 2, 3))) == 2)
    println(Solution.maxDepthElegant(TreeNode.create(arrayOf(1, 2, 2, 3, 4, 4, 3))) == 3)


}
