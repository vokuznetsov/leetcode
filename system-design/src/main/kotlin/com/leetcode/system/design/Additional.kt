package com.leetcode.system.design

import java.math.BigDecimal

private object Additional {

    fun findRepeatedElements(nums: IntArray): Map<Int, Int> {
        val ans = mutableMapOf<Int, Int>()
        val size = nums.lastIndex
        var start = 0
        var middle = size / 2

        while (start < nums.lastIndex) {
            var left = start

            while (nums[start] != nums[middle - 1] && nums[middle] != nums[start] && middle <= size) {
                if (nums[start] == nums[middle]) left = middle
                middle = left + (middle - left) / 2
            }

            ans[nums[start]] = middle - start
            start = middle
        }

        return ans
    }
}


fun main() {

    println(
        Additional.findRepeatedElements(
            intArrayOf(-7, -7, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 248)
        )
    )

}
