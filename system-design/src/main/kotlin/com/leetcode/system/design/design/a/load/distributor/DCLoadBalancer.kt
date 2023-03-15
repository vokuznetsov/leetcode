package com.leetcode.system.design.design.a.load.distributor

import java.util.PriorityQueue

/**
 *
 * Design a Load Distributor
 * https://leetcode.com/explore/learn/card/system-design/689/system-design-basics/4409/
 */

/**
 * Your DCLoadBalancer object will be instantiated and called as such:
 * var obj = DCLoadBalancer()
 * obj.addMachine(machineId,capacity)
 * obj.removeMachine(machineId)
 * var param_3 = obj.addApplication(appId,loadUse)
 * obj.stopApplication(appId)
 * var param_5 = obj.getApplications(machineId)
 */
class DCLoadBalancer {

    data class Machine(
        val machineId: Int,
        var capacity: Int,
        val apps: MutableList<Int> = mutableListOf()
    ) : Comparable<Machine> {
        override fun compareTo(other: Machine): Int {
            return if (this.capacity == other.capacity) {
                return machineId.compareTo(other.machineId)
            } else other.capacity.compareTo(this.capacity)
        }
    }

    data class Application(
        val appId: Int,
        val loadUse: Int,
        val machineId: Int
    )

    private val machines = mutableMapOf<Int, Machine>()
    private val apps = mutableMapOf<Int, Application>()
    private val pqMachines = PriorityQueue<Machine>()

    fun addMachine(machineId: Int, capacity: Int) {
        val machine = Machine(machineId, capacity)
        machines[machineId] = machine
        pqMachines.add(machine)
    }

    fun removeMachine(machineId: Int) {
        machines.remove(machineId)?.let { machine ->
            pqMachines.remove(machine)
            machine.apps.forEach { appId ->
                apps[appId]?.let { addApplication(appId, it.loadUse) }
            }
        }
    }

    fun addApplication(appId: Int, loadUse: Int): Int {
        pqMachines.peek()?.let { if (it.capacity < loadUse) return -1 } ?: return -1

        return pqMachines.remove().let { machine ->
            machine.capacity = machine.capacity - loadUse
            pqMachines.add(machine)
            machine.apps.add(appId)

            val app = Application(appId, loadUse, machine.machineId)
            apps[appId] = app

            machine.machineId
        }
    }

    fun stopApplication(appId: Int) {
        apps[appId]?.let { app ->
            machines[app.machineId]?.let { machine ->
                pqMachines.remove(machine)
                machine.capacity = machine.capacity + app.loadUse
                machine.apps.remove(appId)
                pqMachines.add(machine)
            }
        }
    }

    fun getApplications(machineId: Int): List<Int> {
        return machines[machineId]?.apps?.take(10) ?: emptyList()
    }

}


fun main() {

    case1()
    case2()
}

private fun case1() {

    println("Start case 1...")

    val dCLoadBalancer = DCLoadBalancer()
    dCLoadBalancer.addMachine(1, 1) // Capacity Left: [1]

    dCLoadBalancer.addMachine(2, 10) // Capacity Left: [1,10]

    dCLoadBalancer.addMachine(3, 10) // Capacity Left: [1,10,10]

    dCLoadBalancer.addMachine(4, 15) // Capacity Left: [1,10,10,15]

    println(dCLoadBalancer.addApplication(1, 3) == 4) // return 4, Capacity Left: [1,10,10,12]

    // Machine 4 had the largest capacity left at 15.
    println(dCLoadBalancer.addApplication(2, 11) == 4) // return 4, Capacity Left: [1,10,10,1]

    // Machine 4 had the largest capacity left at 12.
    println(dCLoadBalancer.addApplication(3, 6) == 2) // return 2, Capacity Left: [1,4,10,1]

    // Machine 2 and 3 had the same largest capacity but machine 2 has the lower ID.
    println(dCLoadBalancer.addApplication(4, 5) == 3) // return 3, Capacity Left: [1,4,5,1]

    // Machine 3 had the largest capacity at 10.
    println(dCLoadBalancer.getApplications(2) == listOf(3)) // return [3], Machine 2 only has application 3.

    dCLoadBalancer.addMachine(5, 10) // Capacity Left: [1,4,5,1,10]

    println(dCLoadBalancer.addApplication(5, 5) == 5) // return 5, Capacity Left: [1,4,5,1,5]

    // Machine 5 had the largest capacity at 10.
    dCLoadBalancer.stopApplication(3) // Capacity Left: [1,10,5,1,5],

    // Application 3 was running on machine 2.
    println(dCLoadBalancer.addApplication(6, 5) == 2) // return 2, Capacity Left: [1,5,5,1,5]

    // Machine 2 had the largest capacity at 10.
    println(dCLoadBalancer.getApplications(4) == listOf(1, 2)) // return [1, 2], Machine 4 has applications 1 and 2.

    dCLoadBalancer.removeMachine(4) // Capacity Left: [1,2,5,-,5]

    // Machine 4 had applications 1 and 2.
    // Application 1 has a load of 3 and is added to machine 2.
    // Application 2 has a load of 11 and cannot be added to any machine so it is removed.
    println(dCLoadBalancer.getApplications(2) == listOf(6, 1)) // return [6, 1], Machine 2 has applications 6 and 1.

    println("End case 1!")
}

private fun case2() {

    println("Start case 2...")

    val lb = DCLoadBalancer()

    lb.addMachine(73314, 38096)
    println(lb.getApplications(73314) == emptyList<Int>())

    println(lb.addApplication(73811, 46083) == -1)
    println(lb.getApplications(73314) == emptyList<Int>())

    println(lb.addApplication(89187, 25213) == 73314)
    println(lb.getApplications(73314) == listOf(89187))

    println("End case 2!")

}