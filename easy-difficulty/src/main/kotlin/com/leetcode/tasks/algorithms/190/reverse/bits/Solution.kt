package com.leetcode.tasks.algorithms.`190`.reverse.bits

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 */


private object Solution {

    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var curr = n
        var result = 0

        for (i in (0..31)) {
            result = result shl 1
            if (curr and 1 == 1) result++
            curr = curr ushr 1
        }

        return result
    }
}

fun main() {

    println(Solution.reverseBits(0b00000010100101000001111010011100) == 964176192)


//    val x = Integer.parseInt("1101", 2)
//    println(x)

//    val aa = x shl 31
//    println("$aa - ${aa.toString(2)}")

//    val bb = aa ushr 31
//    println("$bb - ${bb.toString(2)}")

//    val cc = x shl 28
//    println("$cc - ${cc.toString(2)}")

//    val dd = aa ushr 30
//    println("$dd - ${dd.toString(2)}")

//    0b111111111111111111111100110011
//    val aa1 = 0b10111111111111111111110011001101 shr 29
//    println(aa1.toString(2))

}
