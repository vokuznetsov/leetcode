package com.leetcode.system.design

class EvenNumberIterator(
    val numbers: IntArray
) : Iterator<Int> {

    var currentIndex = 0
    var hasNext = false

    override fun hasNext(): Boolean {
        if (!hasNext) {
            while (currentIndex < numbers.lastIndex && numbers[currentIndex] % 2 == 1) {
                currentIndex++
            }

            hasNext = currentIndex < numbers.size
        }

        return hasNext
    }

    override fun next(): Int {
        hasNext = hasNext()
        if (!hasNext) throw NoSuchElementException("There is no available elements")

        hasNext = false
        return numbers[currentIndex++]
    }
}

fun main() {

    firstPrint()
    secondPrint()

}

private fun firstPrint() {
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val iterator = EvenNumberIterator(numbers)
    println("First")
    while (iterator.hasNext()) {
        val evenNumber: Int = iterator.next()
        print("$evenNumber ")
    }
    println()
}

private fun secondPrint() {
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val iterator = EvenNumberIterator(numbers)
    println("Second")
    for (i in 0..11) {
        print("${iterator.next()} ")
    }
    println()
}


