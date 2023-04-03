package com.leetcode.tasks.algorithms.`917`.reverse.only.letters

/**
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 */

private object Solution {

    fun reverseOnlyLetters(s: String): String {
        val charArray = s.toCharArray()
        var left = 0
        var right = charArray.lastIndex

        while (left < right) {
            if (charArray[left].isLetter() && charArray[right].isLetter()) {
                val temp = charArray[left]
                charArray[left++] = charArray[right]
                charArray[right--] = temp
            } else {
                if (!charArray[left].isLetter()) left++
                if (!charArray[right].isLetter()) right--
            }
        }

        return String(charArray)
    }
}

fun main() {

    println(Solution.reverseOnlyLetters("ab-cd") == "dc-ba")
    println(Solution.reverseOnlyLetters("a-bC-dEf-ghIj") == "j-Ih-gfE-dCba")
    println(Solution.reverseOnlyLetters("Test1ng-Leet=code-Q!") == "Qedo1ct-eeLg=ntse-T!")

}
