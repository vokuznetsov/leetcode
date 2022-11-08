package com.leetcode.tasks.algorithms.`108`.convert.sorted.array.to.binary.search.tree

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

private object Solution {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBST(nums, 0, nums.lastIndex)
    }

    fun sortedArrayToBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        return if (start > end) null
        else {
            val middle = (end - start) / 2 + start
            val left = sortedArrayToBST(nums, start, middle - 1)
            val right = sortedArrayToBST(nums, middle + 1, end)
            return TreeNode(nums[middle], left, right)
        }
    }
}

fun main() {

    println(Solution.sortedArrayToBST(intArrayOf(7)))
    println(Solution.sortedArrayToBST(intArrayOf(1, 3)))
    println(Solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
    println(Solution.sortedArrayToBST(intArrayOf(-10, -3, 5, 9)))

}
