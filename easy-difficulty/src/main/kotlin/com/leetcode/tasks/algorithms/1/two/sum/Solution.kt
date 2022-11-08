package com.leetcode.tasks.algorithms.`1`.two.sum

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/submissions/
 */
private object Solution {

    // first solution
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { indexX, x ->
            val lastIndex = nums.size - 1
            if (indexX != lastIndex) {
                for (indexY in (indexX + 1..lastIndex)) {
                    if (x + nums[indexY] == target) return intArrayOf(indexX, indexY)
                }
            }
        }

        return intArrayOf(0)
    }

    // second solution (faster)
    fun twoSumMap(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, x ->
            val requiredNumber = target - x

            if (map.containsKey(requiredNumber)) {
                return intArrayOf(map[requiredNumber]!!, index)
            } else {
                map[x] = index
            }
        }

        return intArrayOf(0)
    }
}

fun main() {
    val result1 = Solution.twoSumMap(nums = intArrayOf(3, 2, 4), target = 6)
    val result2 = Solution.twoSumMap(nums = intArrayOf(3, 2, 4), target = 6)

    println(result1.joinToString())
    println(result2.joinToString())
}