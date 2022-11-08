package com.leetcode.tasks.`278`.first.bad.version

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/
 */


private object Solution {

    fun isBadVersion(version: Int): Boolean {
        return version >= 4
    }

    fun firstBadVersion(n: Int): Int {
        var start = 0
        var end = n
        var version = n / 2

        while (end - start > 1) {
            if (isBadVersion(version)) end = version else start = version
            version = (end - start) / 2 + start
        }

        return end
    }
}

fun main() {

    println(Solution.firstBadVersion(5))
    println(Solution.firstBadVersion(4))

}
