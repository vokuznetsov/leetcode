package com.leetcode.tasks.algorithms.`380`.insert.delete.getrandom

import kotlin.random.Random


/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */

class RandomizedSet {

    val elemIndexMap = mutableMapOf<Int, Int>()
    val elemList = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (elemIndexMap.contains(`val`)) return false
        elemList.add(`val`)
        elemIndexMap[`val`] = elemList.lastIndex
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!elemIndexMap.contains(`val`)) return false

        val currentValIndex = elemIndexMap[`val`]!!

        swap(currentValIndex, elemList.lastIndex)

        elemIndexMap.remove(`val`)
        elemList.removeAt(elemList.lastIndex)

        return true
    }

    fun getRandom(): Int {
        val index = Random.nextInt(0, elemList.size)
        return elemList[index]
    }

    private fun swap(currentIndex: Int, lastIndex: Int) {
        val lastListElem = elemList[lastIndex]
        elemIndexMap[lastListElem] = currentIndex

        val temp = elemList[currentIndex]
        elemList[currentIndex] = elemList[lastIndex]
        elemList[lastIndex] = temp
    }

}

fun main() {

    // ------------- 1 -------------
    val randomizedSet1 = RandomizedSet()
    println(randomizedSet1.insert(1))        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    println(!randomizedSet1.remove(2))        // Returns false as 2 does not exist in the set.
    println(randomizedSet1.insert(2))        // Inserts 2 to the set, returns true. Set now contains [1,2].
    println(randomizedSet1.getRandom())          // getRandom() should return either 1 or 2 randomly.
    println(randomizedSet1.remove(1))        // Removes 1 from the set, returns true. Set now contains [2].
    println(!randomizedSet1.insert(2))        // 2 was already in the set, so return false.
    println(randomizedSet1.getRandom() == 2)          // Since 2 is the only number in the set, getRandom() will always

    // ------------- 2 -------------

//    ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
//    [[],[0],[1],[0],[2],[1],[]]

    val randomizedSet2 = RandomizedSet()

    println(randomizedSet2.insert(0))   // [0]
    println(randomizedSet2.insert(1))   // [0, 1]
    println(randomizedSet2.remove(0))   // [1]
    println(randomizedSet2.insert(2))   // [1, 2]
    println(randomizedSet2.remove(1))   // [2]
    println(randomizedSet2.getRandom() == 2)


}