package com.leetcode.tasks.algorithms.`55`.jump.game

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 */
private object Solution {

    var cache = Array<Boolean?>(1) { null }


    // ---------- recursive approach ----------
    fun canJump(nums: IntArray): Boolean {
        cache = Array(nums.size) { null }
        return canReach(0, nums)
    }

    private fun canReach(index: Int, nums: IntArray): Boolean {
        cache[index]?.let { return it }

        return if (index + nums[index] >= nums.lastIndex) true
        else {
            cache[index] = false
            for (i in 1..nums[index]) {
                if (canReach(index + i, nums)) {
                    cache[index] = true
                    return true
                }
            }
            false
        }
    }


}

fun main() {

    println(Solution.canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(!Solution.canJump(intArrayOf(3, 2, 1, 0, 4)))
    println(Solution.canJump(intArrayOf(1)))
    println(Solution.canJump(intArrayOf(2, 0)))

}