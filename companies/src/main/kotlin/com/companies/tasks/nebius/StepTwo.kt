package com.companies.tasks.nebius

/**
 * Дан класс Node
 * class Node {
 *     int value;
 *     List<Node> children;
 * }
 *
 *        1
 *      / | \
 *     2  3  4
 *          / \
 *          5 6
 *
 * Задача: написать serializer и deserializer для этого класса.
 *
 * Пример, как можно сериализовать класс.
 * 1:[2:3:4:[5:6:]]
 */

data class Node(
    val value: Int,
    val children: MutableList<Node>
)

private object StepTwo {

    fun serializer(node: Node): String {
        val sb = StringBuilder()
        serializerHelper(node, sb)
        return sb.toString()
    }

    private fun serializerHelper(node: Node, sb: StringBuilder) {
        sb.append("${node.value}:")

        if (node.children.isNotEmpty()) {
            sb.append("[")
            for (child in node.children) {
                serializerHelper(child, sb)
            }
            sb.append("]")
        }
    }

    fun deserializer(node: String): Node? {
        if (node.isBlank()) return null

        val head = Node(node[0].digitToInt(), mutableListOf())
        deserializerHelper(1, node, head)
        return head
    }

    private fun deserializerHelper(start: Int, node: String, head: Node): Int {
        var i = start
        while (i != node.length && node[i] != '[') i++

        val children = mutableListOf<Node>()

        while (i != node.length && node[i] != ']') {
            if (node[i].isDigit()) {
                children.add(Node(node[i].digitToInt(), mutableListOf()))
            } else if (node[i] == '[' && children.isNotEmpty()) {
                i = deserializerHelper(i, node, children.last())
            }

            i++
        }

        head.children.addAll(children)
        return i
    }

}

fun main() {

    val node = Node(
        1, mutableListOf(
            Node(2, mutableListOf()),
            Node(3, mutableListOf()),
            Node(
                4, mutableListOf(
                    Node(5, mutableListOf()),
                    Node(6, mutableListOf())
                )
            )
        )
    )

    println("-------------- Serialize --------------")
    val serializer = StepTwo.serializer(node)
    println(serializer == "1:[2:3:4:[5:6:]]")

    println("-------------- Deserialize --------------")
    val deserializedNode = StepTwo.deserializer(serializer)
    println(deserializedNode == node)

}
