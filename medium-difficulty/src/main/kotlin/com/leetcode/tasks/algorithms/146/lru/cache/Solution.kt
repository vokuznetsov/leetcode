package com.leetcode.tasks.algorithms.`146`.lru.cache

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */


class LRUCache(val capacity: Int) {

    class Node(var key: Int, var value: Int, var previous: Node? = null, var next: Node? = null)

    private val map = mutableMapOf<Int, Node>()

    private var head: Node = Node(0, 0, null, null)
    private var tail: Node = Node(0, 0, head, null)
    private var size = 0

    init {
        head.next = tail
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var node = map[key]

        if (node == null) {
            node = Node(key, value)
            addNode(node)
            map[key] = node
            size++
        } else {
            node.value = value
            moveToHead(node)
        }

        if (size > capacity) {
            val previous = tail.previous
            previous?.let { removeNode(it) }
            map.remove(previous?.key)
            size--
        }
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addNode(node)
    }

    private fun removeNode(node: Node) {
        node.previous?.next = node.next
        node.next?.previous = node.previous
    }

    private fun addNode(node: Node) {
        node.previous = head
        node.next = head.next

        head.next?.previous = node
        head.next = node
    }
}

fun main() {

    println("--------------- 1 ---------------")

    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1)                                            // cache is {1=1}
    lRUCache.put(2, 2)                                            // cache is {1=1, 2=2}
    println(lRUCache.get(1) == 1)                                 // return 1
    lRUCache.put(3, 3)                                            // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    println(lRUCache.get(2) == -1)                                // returns -1 (not found)
    lRUCache.put(4, 4)                                            // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    println(lRUCache.get(1) == -1)                                // return -1 (not found)
    println(lRUCache.get(3) == 3)                                 // return 3
    println(lRUCache.get(4) == 4)                                 // return 4

    println("--------------- 2 ---------------")

    val lRUCache2 = LRUCache(2)
    lRUCache2.put(1, 0)
    lRUCache2.put(2, 2)
    println(lRUCache2.get(1) == 0)
    lRUCache2.put(3, 3)
    println(lRUCache2.get(2) == -1)
    lRUCache2.put(4, 4)
    println(lRUCache2.get(1) == -1)
    println(lRUCache2.get(3) == 3)
    println(lRUCache2.get(4) == 4)

    println("--------------- 3 ---------------")

    val lRUCache3 = LRUCache(2)
    println(lRUCache3.get(2) == -1)
    lRUCache3.put(2, 6)
    println(lRUCache3.get(1) == -1)
    lRUCache3.put(1, 5)
    lRUCache3.put(1, 2)
    println(lRUCache3.get(1) == 2)
    println(lRUCache3.get(2) == 6)

    println("--------------- 4 ---------------")

    val lRUCache4 = LRUCache(2)
    lRUCache4.put(2, 1)
    lRUCache4.put(1, 1)
    lRUCache4.put(2, 3)
    lRUCache4.put(4, 1)
    println(lRUCache4.get(1) == -1)
    println(lRUCache4.get(2) == 3)

    println("--------------- 5 ---------------")

    val lRUCache5 = LRUCache(3)
    lRUCache5.put(1, 1)
    lRUCache5.put(2, 2)
    lRUCache5.put(3, 3)
    lRUCache5.put(4, 4)
    println(lRUCache5.get(4) == 4)
    println(lRUCache5.get(3) == 3)
    println(lRUCache5.get(2) == 2)
    println(lRUCache5.get(1) == -1)
    lRUCache5.put(5, 5)
    println(lRUCache5.get(1) == -1)
    println(lRUCache5.get(2) == 2)
    println(lRUCache5.get(3) == 3)
    println(lRUCache5.get(4) == -1)
    println(lRUCache5.get(5) == 5)

    println("--------------- 6 ---------------")

    val lRUCache6 = LRUCache(2)
    lRUCache6.put(2, 1)
    lRUCache6.put(3, 2)
    println(lRUCache6.get(3) == 2)
    println(lRUCache6.get(2) == 1)
    lRUCache6.put(4, 3)
    println(lRUCache6.get(2) == 1)
    println(lRUCache6.get(3) == -1)
    println(lRUCache6.get(4) == 3)

}