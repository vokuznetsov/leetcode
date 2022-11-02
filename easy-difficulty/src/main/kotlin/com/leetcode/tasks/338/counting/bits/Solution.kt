package com.leetcode.tasks.`338`.counting.bits

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 */


private object Solution {

    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)

        for (i in 0..n) {
            var value = i
            var oneNumber = 0
            while (value != 0) {
                oneNumber += value and 1
                value = value shr 1
            }
            result[i] = oneNumber
        }

        return result
    }

    // more elegant solution
    // result[1] = (result[0]==0) + (1%1==1) = 1
    // result[11] = (result[1]==1) + (11%1==1)  = 2
    // result[110] = (result[11]==2) + (110%1==0) = 2
    // result[1101] = (result[110] ==2) + (1101%1==1) =3;
    // ...
    fun countBits1(n: Int): IntArray {
        val result = IntArray(n + 1)
        result[0] = 0

        for (i in 1..n) {
            result[i] = result[i shr 1] + (i and 1)
        }
        return result
    }
}

fun main() {

    println(Solution.countBits1(2).contentEquals(intArrayOf(0, 1, 1)))
    println(Solution.countBits1(5).contentEquals(intArrayOf(0, 1, 1, 2, 1, 2)))

}
