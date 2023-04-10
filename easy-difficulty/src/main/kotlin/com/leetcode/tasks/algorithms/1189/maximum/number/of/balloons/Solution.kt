package com.leetcode.tasks.algorithms.`1189`.maximum.number.of.balloons

/**
 * 1189. Maximum Number of Balloons
 * https://leetcode.com/problems/maximum-number-of-balloons
 */

private object Solution {

    fun maxNumberOfBalloons(text: String): Int {
        val map = mutableMapOf<Char, Int>()

        for (c in text) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        val balloonMap = mutableMapOf<Char, Int>()
        for (c in "balloon") {
            balloonMap[c] = balloonMap.getOrDefault(c, 0) + 1
        }

        var ans = Int.MAX_VALUE

        for ((key, value) in balloonMap) {
            if (map.containsKey(key))
                map[key]?.let { ans = Math.min(ans, it / value) }
            else return 0
        }

        return if (ans != Int.MAX_VALUE) ans else 0
    }
}

fun main() {

    println(Solution.maxNumberOfBalloons("nlaebolko") == 1)
    println(Solution.maxNumberOfBalloons("loonbalxballpoon") == 2)
    println(Solution.maxNumberOfBalloons("leetcode") == 0)
    println(Solution.maxNumberOfBalloons("lloo") == 0)

}
