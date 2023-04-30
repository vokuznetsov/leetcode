package com.leetcode.tasks.algorithms.`71`.simplify.path

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
private object Solution {

    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (s in path.split("/")) {
            if (s.isEmpty() || s == ".") {
                continue
            } else if (s == "..") {
                if (stack.isNotEmpty()) stack.removeLast()
            } else stack.addLast(s)
        }

        val sb = StringBuilder()
        for (s in stack) {
            sb.append("/${s}")
        }

        return if (sb.isEmpty()) "/" else sb.toString()
    }
}

fun main() {

    println(Solution.simplifyPath("/.") == "/")
    println(Solution.simplifyPath("/../") == "/")
    println(Solution.simplifyPath("/home/") == "/home")
    println(Solution.simplifyPath("/a/b/c/.././..d") == "/a/b/..d")
    println(Solution.simplifyPath("/a/../../b/../c//.//") == "/c")
    println(Solution.simplifyPath("/a//b////c/d//././/..") == "/a/b/c")

}