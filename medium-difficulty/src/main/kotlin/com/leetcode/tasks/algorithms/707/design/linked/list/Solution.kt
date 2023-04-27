package com.leetcode.tasks.algorithms.`707`.design.linked.list

/**
 * 707. Design Linked List
 * https://leetcode.com/problems/design-linked-list/
 */
class MyLinkedList {

    val head = Node(1)
    val tail = Node(-1)
    var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    inner class Node(
        var `val`: Int,
        var next: Node? = null,
        var prev: Node? = null
    )

    fun get(index: Int): Int {
        if (index < 0 || index > size) {
            return -1
        }

        var curr: Node? = head
        for (i in 0..index) {
            curr = curr?.next
        }

        return curr?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index in 0..size) {
            var curr: Node? = head
            for (i in 0..index) {
                curr = curr?.next
            }

            val temp = curr?.prev

            val node = Node(`val`)
            curr?.prev = node
            node.next = curr
            node.prev = temp
            temp?.next = node

            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index in 0 until size) {
            var curr: Node? = head
            for (i in 0..index) {
                curr = curr?.next
            }

            val prev = curr?.prev
            curr?.prev?.next = curr?.next
            curr?.next?.prev = prev

            size--
        }
    }
}

fun main() {

    firstTest()

}

private fun firstTest() {
    val myLinkedList = MyLinkedList()
    myLinkedList.addAtHead(1)
    myLinkedList.addAtTail(3)
    myLinkedList.addAtIndex(1, 2) // linked list becomes 1->2->3
    println(myLinkedList.get(1) == 2) // return 2
    myLinkedList.deleteAtIndex(1) // now the linked list is 1->3
    println(myLinkedList.get(1) == 3) // return 3
}