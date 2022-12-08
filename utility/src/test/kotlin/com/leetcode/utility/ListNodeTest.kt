package com.leetcode.utility

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ListNodeTest {

    @Test
    internal fun listNodeCreationEquals1() {
        val listNodeExp = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        val listNodeResult = ListNode.create(intArrayOf(1, 2, 3, 4, 5))

        assertEquals(listNodeExp, listNodeResult)
    }

    @Test
    internal fun listNodeCreationEquals2() {
        val listNodeExp = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    6,
                    ListNode(
                        3,
                        ListNode(
                            4,
                            ListNode(
                                5,
                                ListNode(6)
                            )
                        )
                    )
                )
            )
        )
        val listNodeResult = ListNode.create(intArrayOf(1, 2, 6, 3, 4, 5, 6))

        assertEquals(listNodeExp, listNodeResult)
    }

    @Test
    internal fun listNodeCreationNotEquals1() {
        val listNodeExp = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        val listNodeResult = ListNode.create(intArrayOf(1, 2, 3, 4, 99))

        assertNotEquals(listNodeExp, listNodeResult)
    }
}