package com.leetcode.tasks.algorithms.`257`.binary.tree.paths

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
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

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    val paths = mutableListOf<String>()

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()
        binaryTreePaths(root, "")
        return paths
    }

    fun binaryTreePaths(root: TreeNode, currentPath: String) {
        val path = if (currentPath.isEmpty()) "${root.`val`}" else "$currentPath->${root.`val`}"

        if (root.left == null && root.right == null) {
            paths.add(path)
            return
        }

        root.left?.let { binaryTreePaths(it, path) }
        root.right?.let { binaryTreePaths(it, path) }
    }
}

fun main() {

    val tree1 = TreeNode(1, TreeNode(2, null, TreeNode(5)), TreeNode(3))
    println(Solution.binaryTreePaths(tree1) == listOf("1->2->5", "1->3"))

    Solution.paths.clear()

    val tree2 = TreeNode(1)
    println(Solution.binaryTreePaths(tree2) == listOf("1"))

}
