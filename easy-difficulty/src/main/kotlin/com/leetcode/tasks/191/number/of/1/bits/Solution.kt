package com.leetcode.tasks.`191`.number.of.`1`.bits

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 */


private object Solution {

    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var curr = n
        var result = 0

        for (i in (0..31)) {
            if (curr and 1 == 1) result++
            curr = curr ushr 1
        }

        return result
    }
}

fun main() {


    println(Solution.hammingWeight(0b00000000000000000000000000001011) == 3)
    println(Solution.hammingWeight(0b00000000000000000000000010000000) == 1)
    println(Solution.hammingWeight(0b1111111111111111111111111111111) == 31)

//    val a = -0b1111111111111111111111111111100
//    println(a)
//    val b = a shr 10
//    val c = a ushr 10
//    println(a.toString(2))
//    println("${b.toString(2)} - $b")
//    println("${c.toString(2)} -  $c")

}
