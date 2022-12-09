package com.leetcode.utility

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class TreeNodeTest {

    @Test
    internal fun treeNodeCreationEquals1() {
        val treeExpected = TreeNode(
            10,
            TreeNode(5, TreeNode(3), TreeNode(7)),
            TreeNode(15, null, TreeNode(18))
        )
        val treeResult = TreeNode.create(arrayOf(10, 5, 15, 3, 7, null, 18))

        assertEquals(treeExpected, treeResult)
    }

    @Test
    internal fun treeNodeCreationEquals2() {
        val treeExpected = TreeNode(
            1,
            TreeNode(2, null, TreeNode(5)),
            TreeNode(3)
        )
        val treeResult = TreeNode.create(arrayOf(1, 2, 3, null, 5))

        assertEquals(treeExpected, treeResult)
    }

    @Test
    internal fun treeNodeCreationEquals3() {
        val treeExpected = TreeNode(
            10,
            TreeNode(
                5,
                TreeNode(3, TreeNode(1)),
                TreeNode(7, TreeNode(6))
            ),
            TreeNode(
                15,
                TreeNode(13),
                TreeNode(18)
            )
        )
        val treeResult = TreeNode.create(arrayOf(10, 5, 15, 3, 7, 13, 18, 1, null, 6))

        assertEquals(treeExpected, treeResult)
    }

    @Test
    internal fun treeNodeCreationEquals4() {
        assertEquals(null, TreeNode.create(arrayOf()))
    }

    @Test
    internal fun treeNodeCreationNotEquals1() {
        val treeExpected = TreeNode(
            10,
            TreeNode(5, TreeNode(3), TreeNode(7)),
            TreeNode(15, null, TreeNode(18))
        )
        val treeResult = TreeNode.create(arrayOf(10, 5, 15, 3, 7, null, 99))

        assertNotEquals(treeExpected, treeResult)
    }

}