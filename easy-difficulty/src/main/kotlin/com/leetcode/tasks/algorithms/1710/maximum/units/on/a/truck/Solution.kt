package com.leetcode.tasks.algorithms.`1710`.maximum.units.on.a.truck

/**
 * 1710. Maximum Units on a Truck
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */

private object Solution {

    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        var size = truckSize
        boxTypes.sortWith(compareBy<IntArray>({ it.last() }, { it.first() }).reversed())

        var maxUnits = 0

        for (boxType in boxTypes) {
            var boxCount = 0
            while (size != 0 && boxCount < boxType[0]) {
                maxUnits += boxType[1]
                boxCount++
                size--
            }
            if (size == 0) return maxUnits
        }

        return maxUnits
    }
}

fun main() {

    //boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
    println(Solution.maximumUnits(arrayOf(intArrayOf(1, 7)), 1) == 7)
    println(Solution.maximumUnits(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)), 4) == 8)

    //[[5,10],[2,5],[4,7],[3,9]], truckSize = 10
    println(
        Solution.maximumUnits(
            arrayOf(intArrayOf(5, 10), intArrayOf(2, 5), intArrayOf(4, 7), intArrayOf(3, 9)),
            10
        ) == 91
    )


}
