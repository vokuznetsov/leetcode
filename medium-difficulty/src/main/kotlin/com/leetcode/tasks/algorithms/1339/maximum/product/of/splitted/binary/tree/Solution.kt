package com.leetcode.tasks.algorithms.`1339`.maximum.product.of.splitted.binary.tree

import com.leetcode.utility.TreeNode

/**
 * 1339. Maximum Product of Splitted Binary Tree
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
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

    var max: Long = 0
    var totalSum = 0

    fun maxProduct(root: TreeNode?): Int {
        max = 0
        totalSum = 0

        if (root == null) return 0
        totalSum = treeSum(root)
        findMaximum(root)

        return (max % (Math.pow(10.0, 9.0) + 7)).toInt()
    }

    private fun treeSum(root: TreeNode?): Int {
        if (root == null) return 0
        return root.`val` + treeSum(root.left) + treeSum(root.right)
    }

    private fun findMaximum(root: TreeNode?): Long {
        if (root == null) return 0
        val left = findMaximum(root.left)
        val right = findMaximum(root.right)

        val currentSum = left + right + root.`val`
        val currentMaximum = currentSum * (totalSum - currentSum)
        if (currentMaximum > max) max = currentMaximum
        return currentSum
    }

}

fun main() {

    println(Solution.maxProduct(TreeNode.create(arrayOf(1, 2, 3, 4, 5, 6))) == 110)
    println(Solution.maxProduct(TreeNode.create(arrayOf(1, null, 2, 3, 4, null, null, 5, 6))) == 90)

}