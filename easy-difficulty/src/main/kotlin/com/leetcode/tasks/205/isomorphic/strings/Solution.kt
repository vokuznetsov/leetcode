package com.leetcode.tasks.`205`.isomorphic.strings

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 */


private object Solution {

    fun isIsomorphic(s: String, t: String): Boolean {
        val charMappingTable = mutableMapOf<Char, Char>()
        val usedChars = mutableSetOf<Char>()

        for ((index, char) in s.withIndex()) {
            val mappingChar = t[index]

            val existingChar = charMappingTable[char]

            // символ из s не добавлен и mappingChar из t не содержится в уже замапленых символах
            if (existingChar == null && !usedChars.contains(mappingChar)) {
                charMappingTable[char] = mappingChar
                usedChars.add(mappingChar)
                // символ из s не добавлен, но mappingChar из t уже использовался для соотвествия с другим символом из s
            } else if (existingChar == null && usedChars.contains(mappingChar)) return false
            // не совпадает символ, который использовался раньше и сейчас
            else if (existingChar != null && existingChar != mappingChar) return false
        }

        return true
    }
}

fun main() {

    println(Solution.isIsomorphic("egg", "add"))
    println(Solution.isIsomorphic("foo", "bar"))
    println(Solution.isIsomorphic("paper", "title"))
    println(Solution.isIsomorphic("badc", "baba"))

}
