package com.leetcode.tasks.algorithms.`15`.`3sum`

import com.leetcode.utility.annotations.Repeat


/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
@Repeat
private object Solution {

    /*fun threeSum1(nums: IntArray): List<List<Int>> {
        nums.sort()

        var zeroIndex: Int? = null
        var point1 = 0
        var point2 = nums.lastIndex

        val result = mutableListOf<List<Int>>()

        while (nums[point1] <= 0 || nums[point2] >= 0 || point1 <= point2) {
            val twoSum = nums[point1] + nums[point2]
            var point3: Int
            if (twoSum < 0) {
                point3 = point2 - 1
                while (point3 >= 0 && nums[point3] > 0) {
                    if (twoSum + nums[point3] == 0)
                        result.add(listOf(nums[point1], nums[point3], nums[point2]))
                    point3--
                }
                point1++
            } else if (twoSum > 0) {
                point3 = point1 + 1
                while (point3 <= nums.lastIndex && nums[point3] < 0) {
                    if (twoSum + nums[point3] == 0)
                        result.add(listOf(nums[point1], nums[point3], nums[point2]))
                    point3++
                }
                point2--
            } else {
                point3 = point1
                var point4 = point2

                while (nums[point3] < 0 || nums[point4] > 0) {
                    point3++
                    point4--
                }
                if (nums[point3] == 0) result.add(listOf(nums[point1], nums[point3], nums[point2]))
                if (nums[point4] == 0) result.add(listOf(nums[point1], nums[point4], nums[point2]))
                point1++
            }

        }

        println(result)
        return result
    }*/

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        var point1 = 0

        val result = mutableSetOf<List<Int>>()

        while (point1 < nums.lastIndex && nums[point1] <= 0) {
            var point2 = nums.lastIndex

            while (point2 - point1 >= 2 && nums[point2] >= 0) {
                val twoSum = nums[point1] + nums[point2]

                if (twoSum <= 0) {
                    var point3 = point2 - 1
                    while (point3 >= 0 && nums[point3] >= 0) {
                        if (twoSum + nums[point3] == 0) {
                            result.add(listOf(nums[point1], nums[point3], nums[point2]))
                            break
                        }
                        point3--
                    }
                } else {
                    var point3 = point1 + 1
                    while (point3 < point2 && nums[point3] <= 0) {
                        if (twoSum + nums[point3] == 0) {
                            result.add(listOf(nums[point1], nums[point3], nums[point2]))
                            break
                        }
                        point3++
                    }
                }
                point2--
            }
            point1++
        }

        return result.toList()
    }
}

fun main() {
    println(Solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)) == listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))
    println(Solution.threeSum(intArrayOf(0, 1, 1)) == emptyList<List<Int>>())
    println(Solution.threeSum(intArrayOf(0, 0, 0)) == listOf(listOf(0, 0, 0)))
    println(Solution.threeSum(intArrayOf(-3, -2, -2, 0, 4)) == listOf(listOf(-2, -2, 4)))
    println(Solution.threeSum(intArrayOf(3, 2, 2, 0, -4)) == listOf(listOf(-4, 2, 2)))
    println(
        Solution.threeSum(intArrayOf(-2, -1, -1, 0, 1, 1, 2)) == listOf(
            listOf(-2, 0, 2),
            listOf(-2, 1, 1),
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
    )
    println(
        Solution.threeSum(intArrayOf(-7, 0, 2, 3, 4, 5, 7)) == listOf(
            listOf(-7, 0, 7),
            listOf(-7, 2, 5),
            listOf(-7, 3, 4)
        )
    )
}