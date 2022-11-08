package com.leetcode.tasks.algorithms.`342`.power.of.four

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 */

private object Solution {

    fun isPowerOfFour(n: Int): Boolean {
        if (n == 0) return false
        if (n == 1) return true
        return if (n % 4 == 0) isPowerOfFour(n / 4) else false
    }

    fun isPowerOfFour1(num: Int): Boolean {
//        Consider the valid numbers within 32 bit, and turn them into binary form, they are:
//
//        1
//        100
//        10000
//        1000000
//        100000000
//        10000000000
//        1000000000000
//        100000000000000
//        10000000000000000
//        1000000000000000000
//        100000000000000000000
//        10000000000000000000000
//        1000000000000000000000000
//        100000000000000000000000000
//        10000000000000000000000000000
//        1000000000000000000000000000000
//        Any other number not it the list should be considered as invalid.
//        So if you XOR them altogether, you will get a mask value, which is:
//
//        1010101010101010101010101010101 (1431655765 = 0x55555555)
//        Any number which is power of 4, it should be power of 2, I use num &(num-1) == 0 to make sure of that.
//        Obviously 0 is not power of 4, I have to check it.
//        and finally I need to check that if the number 'AND' the mask value is itself, to make sure it's in the list above.
//
//        here comes the final code:
//
//        return num != 0 and num &(num-1) == 0 and num & 1431655765== num

        return num > 0 && num and num - 1 == 0 && num and 0x55555555 == num
    }
}

fun main() {

    println(Solution.isPowerOfFour1(1))
    println(Solution.isPowerOfFour1(16))
    println(Solution.isPowerOfFour1(357))
    println(Solution.isPowerOfFour1(1048576))

//    println(16.toString(2))
//    println(15.toString(2))
//    println(16 and 15)
//
//    val i = "55555555".toInt(16)
//    println(Integer.toBinaryString(i))
//    println(16 and i)

}
