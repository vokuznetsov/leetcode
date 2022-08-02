package com.leetcode.tasks.`100`.same.tree

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        return if (p.`val` == q.`val`) isSameTree(p.left, q.left) && isSameTree(p.right, q.right) else false
    }
}

fun main() {

    val tree = TreeNode(1, TreeNode(2), TreeNode(3))
    println(Solution.isSameTree(tree, tree))

    val t2 = TreeNode(1, TreeNode(2))
    val t3 = TreeNode(1, null, TreeNode(2))
    println(Solution.isSameTree(t2, t3))


}
