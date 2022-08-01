package com.leetcode.tasks.`69`.sqrt

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 */
private object Solution {

    fun mySqrt1(x: Int): Int {
        var i: Long = 0

        while (i * i <= x) i++
        return (i - 1).toInt()
    }

    fun mySqrt2(x: Int): Int {
        if (x == 0) return 0
        var mid: Int
        var left = 1
        var right = x / 2 + 1

        while (true) {
            mid = left + (right - left) / 2
            if (mid > x / mid) {
                right = mid - 1
            } else {
                if (mid + 1 > x / (mid + 1)) return mid else left = mid + 1
            }
        }
    }
}

fun main() {

    println(Solution.mySqrt2(2147395600) == 46340)
    println(Solution.mySqrt2(0) == 0)
    println(Solution.mySqrt2(9) == 3)
    println(Solution.mySqrt2(8) == 2)

}
