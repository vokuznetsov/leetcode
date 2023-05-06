package com.leetcode.tasks.algorithms.`340`.longest.substring.with.at.most.k.distinct.characters

import com.leetcode.utility.ListNode


/**
 * 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */

private object Solution {

    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        var left = 0
        var right = 0
        val map = mutableMapOf<Char, Int>()
        var ans = 0

        while (right < s.length) {
            val char = s[right]
            map[char] = map.getOrDefault(char, 0) + 1

            while (map.size > k) {
                val count = map.getOrDefault(s[left], 0) - 1
                if (count > 0) map[s[left]] = count else map.remove(s[left])
                left++
            }

            ans = Math.max(ans, right - left + 1)
            right++
        }

        return ans
    }
}

fun main() {


}