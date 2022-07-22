package com.leetcode.tasks.`27`.remove.element

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 */
private object Solution {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in 0..nums.lastIndex) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }
}

fun main() {

    println(Solution.removeElement(intArrayOf(1), 1) == 0)
    println(Solution.removeElement(intArrayOf(1, 1, 2), 1) == 1)
    println(Solution.removeElement(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 3) == 8)

}
