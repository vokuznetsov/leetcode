package com.leetcode.tasks.algorithms.`976`.largest.perimeter.triangle

/**
 * 976. Largest Perimeter Triangle
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */

private object Solution {

    fun largestPerimeter(nums: IntArray): Int {
        nums.sortDescending()
        var window = 0

        while (window <= nums.size - 3) {
            if (nums[window] < nums[window + 1] + nums[window + 2]) {
                return nums[window] + nums[window + 1] + nums[window + 2]
            }
            window += 1
        }

        return 0
    }
}

fun main() {

    println(Solution.largestPerimeter(intArrayOf(3, 2, 3)))

}
