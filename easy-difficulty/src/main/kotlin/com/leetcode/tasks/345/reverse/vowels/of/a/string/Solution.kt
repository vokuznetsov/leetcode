package com.leetcode.tasks.`345`.reverse.vowels.of.a.string

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */


private object Solution {

    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var startPointer = 0
        var endPointer = s.length - 1

        var arr = s.toCharArray()

        while (startPointer < endPointer) {
            if (vowels.contains(s[startPointer]) && !vowels.contains(s[endPointer])) endPointer--
            else if (!vowels.contains(s[startPointer]) && vowels.contains(s[endPointer])) startPointer++
            else {
                if (vowels.contains(s[startPointer]) && vowels.contains(s[endPointer])) {
                    arr[startPointer] = s[endPointer]
                    arr[endPointer] = s[startPointer]
                }
                startPointer++
                endPointer--
            }

        }

        return String(arr)
    }

}

fun main() {

    println(Solution.reverseVowels("hello") == "holle")
    println(Solution.reverseVowels("leetcode") == "leotcede")

}
