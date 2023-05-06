package com.leetcode.tasks.algorithms.`104`.maximum.depth.of.binary.tree

import com.leetcode.utility.TreeNode

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */


private object Additional {

    var maxLevel: Int = 0
    var ans = mutableSetOf<Int>()
    var deepestElem: TreeNode? = null

    fun depestElems(root: TreeNode?): Set<Int> {
        if (root != null) maxDepth(root, 0)
        return ans
    }

    fun getDeepestNodeValue(root: TreeNode?): TreeNode? {
        if (root != null) maxDepth(root, 0)
        return deepestElem

    }

    fun maxDepth(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }

        if (level > maxLevel) {
            maxLevel = level
            ans.clear()
            ans.add(root.`val`)
            deepestElem = root
        } else if (level == maxLevel) ans.add(root.`val`)

        maxDepth(root.left, level + 1)
        maxDepth(root.right, level + 1)
    }

}

fun main() {

    println(Additional.getDeepestNodeValue(TreeNode.create(arrayOf(1, 2, 3))))
    println(Additional.getDeepestNodeValue(TreeNode.create(arrayOf(1, 2, 2, 3, 4, 4, 3))))
    println(Additional.getDeepestNodeValue(TreeNode.create(arrayOf(1,3,2,5,3,null,9))))
    println(Additional.getDeepestNodeValue(TreeNode.create(arrayOf(1,3,2,5,3,null,9))))
    println(Additional.getDeepestNodeValue(
        TreeNode.create(arrayOf(8,3,10,1,6,null,14,null,null,4,7,13, null, 19)))
    )


}
