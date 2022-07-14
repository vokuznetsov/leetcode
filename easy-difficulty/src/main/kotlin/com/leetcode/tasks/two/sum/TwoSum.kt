package com.leetcode.tasks.two.sum

/**
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
    val twoSum1 = Solution.twoSumMap(nums = intArrayOf(3, 2, 4), target = 6)
    val twoSum2 = Solution.twoSumMap(nums = intArrayOf(3, 2, 4), target = 6)

    println(twoSum1.joinToString())
    println(twoSum2.joinToString())
}