package com.leetcode.tasks.algorithms.`2434`.using.a.robot.to.print.the.lexicographically.smallest.string

import java.util.TreeSet

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String
 * https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 */
private object Solution {

    fun robotWithString(s: String): String {
        val set = TreeSet<Char>()
        val map = mutableMapOf<Char, Int>()

        for (c in s) {
            set.add(c)
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val stack = ArrayDeque<Char>()
        val sb = StringBuilder()

        for (c in s) {
            stack.addLast(c)
            val value = map.getOrDefault(c, 0)
            if (value <= 1) {
                map.remove(c)
                set.remove(c)
            } else {
                map[c] = map.getOrDefault(c, 0) - 1
            }

            while (stack.isNotEmpty() && set.isNotEmpty() && stack.last() <= set.first()) {
                sb.append(stack.removeLast())
            }
        }

        while(stack.isNotEmpty()) sb.append(stack.removeLast())

        return sb.toString()
    }

}

fun main() {

    println(Solution.robotWithString("zza") == "azz")
    println(Solution.robotWithString("bac") == "abc")
    println(Solution.robotWithString("bdda") == "addb")
    println(Solution.robotWithString("cddba") == "abddc")
    println(Solution.robotWithString("bddca") == "acddb")
    println(Solution.robotWithString("bddcabc") == "abccddb")
    println(Solution.robotWithString("vzhofnpo") == "fnohopzv")
    println(Solution.robotWithString("fgbdaced") == "acdbdegf")
    println(Solution.robotWithString("daced") == "acdde")
    println(Solution.robotWithString("cabdc") == "abccd")

}