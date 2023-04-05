package com.leetcode.tasks.algorithms.`1208`.get.equal.substrings.within.budget

/**
 * 1208. Get Equal Substrings Within Budget
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
private object Solution {

    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var left = 0
        var ans = 0
        var curr = maxCost

        for (right in 0..s.lastIndex) {
            val cost = Math.abs(s[right] - t[right])

            while (left < right && curr < cost) {
                curr = Math.min(maxCost, curr + Math.abs(s[left] - t[left]))
                left++
            }

            if (cost > curr) {
                left++
            } else {
                curr -= cost
                ans = Math.max(ans, right - left + 1)
            }
        }

        return ans
    }

    fun equalSubstring1(s: String, t: String, k: Int): Int {
        var k = k
        var i = 0
        var j: Int
        j = 0
        while (j < s.length) {
            k -= Math.abs(s[j] - t[j])
            if (k < 0) {
                k += Math.abs(s[i] - t[i])
                ++i
            }
            ++j
        }
        return j - i
    }
}

fun main() {

    println(Solution.equalSubstring("abcd", "bcdf", 3) == 3)
    println(Solution.equalSubstring("abcd", "cdef", 3) == 1)
    println(Solution.equalSubstring("abcd", "acde", 0) == 1)
    println(Solution.equalSubstring("abcd", "zzzz", 0) == 0)
    println(Solution.equalSubstring("an", "zj", 5) == 1)
    println(Solution.equalSubstring("acbg", "befi", 3) == 2)

}