package com.leetcode.tasks.`374`.guess.number.higher.or.lower

/**
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

open class GuessGame {

    fun guess(num: Int): Int {
        val value = 1
        if (num > value) return -1
        if (num < value) return 1

        return 0
    }
}

object Solution : GuessGame() {

    fun guessNumber(n: Int): Int {
        if (n == 1) return 1

        var start = 1
        var end = n
        var mid = n / 2

        while (start < end) {
            if (guess(mid) == 0) return mid
            if (guess(mid) < 0) end = mid - 1 else start = mid + 1
            mid = (end - start) / 2 + start
        }

        return mid
    }
}

fun main() {

    println(Solution.guessNumber(1))
    println(Solution.guessNumber(2))
//    println(Solution.guessNumber(10))

}
