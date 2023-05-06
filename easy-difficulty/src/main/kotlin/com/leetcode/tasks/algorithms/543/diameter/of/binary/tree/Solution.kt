package com.leetcode.tasks.algorithms.`543`.diameter.of.binary.tree

import com.leetcode.utility.TreeNode

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
private object Solution {

    var max = Int.MIN_VALUE

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        caclculateDiameter(root)
        return max
    }

    fun caclculateDiameter(root: TreeNode?): Int {
        if (root == null) return -1

        var left = caclculateDiameter(root.left) + 1
        var right = caclculateDiameter(root.right) + 1

        max = Math.max(max, left + right)
        return Math.max(left, right)
    }
}

fun main() {

}
