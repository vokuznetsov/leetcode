package com.leetcode.system.design

private object RemoveSmile {

    fun removeSmile(str: String): String {
        val sb = StringBuilder()
        var i = 0
        while (i < str.length) {
            val currChar = str[i]
            if (currChar == ':' && isSmile(i, str)) {
                i += 2
                val smileSymbol = str[i]
                while (i < str.length && str[i] == smileSymbol) i++
            } else sb.append(str[i++])

        }

        return sb.toString()
    }

    private fun isSmile(startIndex: Int, str: String): Boolean {
        if (startIndex + 2 < str.length) {
            // we can use String.substring() but as far as I know it has O(n) time complexity
            val sb = StringBuilder()
            for (i in startIndex until startIndex + 3) sb.append(str[i])

            val subStr = sb.toString()
            return subStr == ":-)" || subStr == ":-("
        }
        return false
    }
}

fun main() {
    println(RemoveSmile.removeSmile("str1:-)))str2:-((str3))") == "str1str2str3))")
    println(RemoveSmile.removeSmile("str1:-)))((str2:-((str3))") == "str1((str2str3))")
    println(RemoveSmile.removeSmile("str1:-)))((str2:-((str3:-))") == "str1((str2str3")
    println(RemoveSmile.removeSmile(":-)") == "")
    println(RemoveSmile.removeSmile(":-)))") == "")
    println(RemoveSmile.removeSmile(":-((") == "")
    println(RemoveSmile.removeSmile("") == "")
    println(RemoveSmile.removeSmile(":-") == ":-")
    println(RemoveSmile.removeSmile(":-]") == ":-]")
    println(RemoveSmile.removeSmile(":-))((:-((") == "((")
    println(RemoveSmile.removeSmile(":-)):-((") == "")
}