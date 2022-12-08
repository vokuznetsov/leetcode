package com.leetcode.tasks.algorithms.`938`.range.sum.of.bst

import com.leetcode.utility.TreeNode

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
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

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        var sum = 0
        if (root.`val` > low) sum += rangeSumBST(root.left, low, high)
        if (root.`val` < high) sum += rangeSumBST(root.right, low, high)
        return if (root.`val` in low..high) root.`val` + sum else sum
    }
}

fun main() {

    val tree1 = TreeNode.create(arrayOf(10, 5, 15, 3, 7, null, 18))
    println(Solution.rangeSumBST(tree1, 7, 15) == 32)

    val tree2 = TreeNode.create(arrayOf(10, 5, 15, 3, 7, 13, 18, 1, null, 6))
    println(Solution.rangeSumBST(tree2, 6, 10) == 23)
}
