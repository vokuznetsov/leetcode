package com.leetcode.tasks.algorithms.`872`.leaf.similar.trees

import com.leetcode.utility.TreeNode


/**
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
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

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leaves1 = mutableListOf<Int>()
        val leaves2 = mutableListOf<Int>()

        // ------- Recursion Approach -------
//        leavesOfTree(root1, leaves1)
//        leavesOfTree(root2, leaves2)

        // ------- Iterative Approach -------
        leavesOfTreeIterative(root1, leaves1)
        leavesOfTreeIterative(root2, leaves2)

        return leaves1 == leaves2
    }

    // recursion approach
    private fun leavesOfTree(root: TreeNode?, leaves: MutableList<Int>) {
        if (root == null) return
        if (root.left == null && root.right == null) leaves.add(root.`val`)

        if (root.left != null) leavesOfTree(root.left, leaves)
        if (root.right != null) leavesOfTree(root.right, leaves)
    }

    // iterative approach
    private fun leavesOfTreeIterative(root: TreeNode?, leaves: MutableList<Int>) {
        val stack = ArrayDeque<TreeNode?>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            if (node != null) {
                if (node.left == null && node.right == null) {
                    leaves.add(node.`val`)
                }
                stack.addLast(node.right)
                stack.addLast(node.left)
            }
        }
    }
}

fun main() {

    val tree11 = TreeNode.create(arrayOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4))
    val tree12 = TreeNode.create(arrayOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8))
    println(Solution.leafSimilar(tree11, tree12))

    val tree21 = TreeNode.create(arrayOf(1, 2, 3))
    val tree22 = TreeNode.create(arrayOf(1, 3, 2))
    println(!Solution.leafSimilar(tree21, tree22))

}
