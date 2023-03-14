package com.leetcode.system.design.design.a.rate.limiting.system

/**
 *
 * Design a Rate Limiting System
 * https://leetcode.com/explore/learn/card/system-design/689/system-design-basics/4408/
 */

/**
 * Your RateLimiter object will be instantiated and called as such:
 * var obj = RateLimiter(n, t)
 * var param_1 = obj.shouldAllow(timestamp)
 */
class RateLimiter(val n: Int, val t: Int) {

    val queue = ArrayDeque<Int>()

    fun shouldAllow(timestamp: Int): Boolean {
        if (queue.size < n) {
            queue.addLast(timestamp)
        } else {
            if (queue.first() <= timestamp - t) {
                queue.removeFirst()
                queue.addLast(timestamp)
            } else {
                return false
            }
        }
        return true
    }
}

fun main() {

    val rateLimiter = RateLimiter(3, 5)
    rateLimiter.shouldAllow(1) // returns True

    // There are no previous requests, so this request is allowed.
    println(rateLimiter.shouldAllow(1)) // returns True

    // We can allow 3 requests every 5 seconds, so this request is allowed.
    // Timestamps of allowed requests are [1,1].
    println(rateLimiter.shouldAllow(2)) // returns True

    // Timestamps of allowed requests are [1,1,2].
    println(rateLimiter.shouldAllow(3)) // returns False

    // This request is not allowed because
    // the time range [1,3] already has 3 allowed requests.
    println(rateLimiter.shouldAllow(8)) // returns True

    // This request is allowed because
    // the time range [4,8] does not have any allowed requests.

}