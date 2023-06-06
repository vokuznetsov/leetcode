package com.leetcode.system.design

private object BubbleSort {

    fun bubbleSort(arr: IntArray) {
        var swapped = false

        for (i in 0..arr.lastIndex) {
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp

                    swapped = true
                }
            }
            if (!swapped) return
        }
    }
}

fun main() {

    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    BubbleSort.bubbleSort(arr)
    arr.forEach { print("$it ") }
    println()
    println(arr.contentEquals(intArrayOf(11, 12, 22, 25, 34, 64, 90)))


}