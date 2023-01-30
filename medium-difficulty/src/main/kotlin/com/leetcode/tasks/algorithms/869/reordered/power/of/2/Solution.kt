package com.leetcode.tasks.algorithms.`869`.reordered.power.of.`2`

/**
 * 869. Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/
 */
private object Solution {

    fun reorderedPowerOf2(n: Int): Boolean {
        val digits = numberToDigits(n)
        return permutations(0, digits)
    }

    private fun numberToDigits(n: Int): MutableList<Int> {
        var value = n
        val digits = mutableListOf<Int>()

        while (value != 0) {
            digits.add(value % 10)
            value /= 10
        }

        return digits
    }

    private fun permutations(start: Int, digits: MutableList<Int>): Boolean {
        if (start >= digits.size) return isPower2(digits)

        for (i in start..digits.lastIndex) {
            swap(start, i, digits)
            if (permutations(start + 1, digits)) return true
            swap(start, i, digits)
        }

        return false
    }

    private fun swap(x: Int, t: Int, digits: MutableList<Int>) {
        val temp = digits[x]
        digits[x] = digits[t]
        digits[t] = temp
    }


    private fun isPower2(digits: List<Int>): Boolean {
        if (digits[0] == 0) return false
        var value = digits.joinToString("").toInt()
        while (value != 1) {
            if (value % 2 == 1) return false
            value /= 2
        }
        return true
    }
}

fun main() {

    println(Solution.reorderedPowerOf2(1))
    println(Solution.reorderedPowerOf2(8))
    println(!Solution.reorderedPowerOf2(10))
    println(Solution.reorderedPowerOf2(64))
    println(Solution.reorderedPowerOf2(281))
    println(!Solution.reorderedPowerOf2(282))

}