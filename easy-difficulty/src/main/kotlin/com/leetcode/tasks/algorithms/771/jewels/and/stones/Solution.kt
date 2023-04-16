package com.leetcode.tasks.algorithms.`771`.jewels.and.stones

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 */

private object Solution {

    fun numJewelsInStones(jewels: String, stones: String): Int {
        val map = mutableMapOf<Char, Int>()

        for (stone in stones) {
            map[stone] = map.getOrDefault(stone, 0) + 1
        }

        var ans = 0
        for (jewel in jewels) {
            ans += map.getOrDefault(jewel, 0)
        }

        return ans
    }
}

fun main() {

    println(Solution.numJewelsInStones("aA", "aAAbbbb") == 3)
    println(Solution.numJewelsInStones("z", "ZZ") == 0)

}

