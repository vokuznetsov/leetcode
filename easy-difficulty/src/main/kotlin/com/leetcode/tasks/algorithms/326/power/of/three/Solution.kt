package com.leetcode.tasks.`326`.power.of.three

import kotlin.math.pow

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 */


private object Solution {

    fun isPowerOfThree(n: Int): Boolean {
        if (n == 0) return false
        if (n == 1) return true
        return if (n % 3 == 0) isPowerOfThree(n / 3) else false
    }

    // Approach 4: Integer Limitations
    // Decision explanation - https://leetcode.com/problems/power-of-three/solution/
    fun isPowerOfThree1(n: Int): Boolean {
        return n > 0 && 1162261467 % n == 0
    }
}

fun main() {

    for (i in 0..10) {
        println(Solution.isPowerOfThree(3.0.pow(i).toInt()))
//        println(3.0.pow(i).toInt().toString(2))
    }


    println(Solution.isPowerOfThree(10))
    println(Solution.isPowerOfThree(12314))

}
