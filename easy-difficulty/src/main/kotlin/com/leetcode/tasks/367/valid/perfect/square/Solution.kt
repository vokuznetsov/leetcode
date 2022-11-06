package com.leetcode.tasks.`367`.valid.perfect.square

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 */

private object Solution {

    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        var start = 1
        var end = num
        var mid = num / 2

        while (start < end) {
            if (mid == num / mid && num % mid == 0) return true
            if (mid > num / mid) end = mid - 1 else start = mid + 1
            mid = (end - start) / 2 + start
        }

        return mid * mid == num
    }

    // the same as previous but instead of using `/`,
    // we will use `*` with `long` type to avoid int overflow.
    // this variant is more readble
    fun isPerfectSquare1(num: Int): Boolean {
        if (num == 1) return true
        var start = 1
        var end = num
        var mid = num / 2

        while (start < end) {
            var square = mid.toLong() * mid.toLong()
            if (square == num.toLong()) return true
            if (square > num) end = mid - 1 else start = mid + 1
            mid = (end - start) / 2 + start
        }

        return mid * mid == num
    }
}

fun main() {

    println(Solution.isPerfectSquare(808201))
    println(Solution.isPerfectSquare(1))
    println(Solution.isPerfectSquare(16))
    println(Solution.isPerfectSquare(49))
    println(Solution.isPerfectSquare(64))
    println(Solution.isPerfectSquare(65))
    println(Solution.isPerfectSquare(14))

}
