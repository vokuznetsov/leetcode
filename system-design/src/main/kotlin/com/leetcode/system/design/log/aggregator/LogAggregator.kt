package com.leetcode.system.design.log.aggregator

/**
 * Design Log Aggregation System
 * https://leetcode.com/explore/learn/card/system-design/689/system-design-basics/4406/
 */

/**
 * Your LogAggregator object will be instantiated and called as such:
 * var obj = LogAggregator(machines, services)
 * obj.pushLog(logId,machineId,serviceId,message)
 * var param_2 = obj.getLogsFromMachine(machineId)
 * var param_3 = obj.getLogsOfService(serviceId)
 * var param_4 = obj.search(serviceId,searchString)
 */

class LogAggregator(machines: Int, services: Int) {

    data class Log(val logId: Int, val machineId: Int, val serviceId: Int, val message: String)

    val machineMap = mutableMapOf<Int, MutableList<Int>>()
    val serviceMap = mutableMapOf<Int, MutableList<Int>>()
    val logs = mutableListOf<Log>()

    fun pushLog(logId: Int, machineId: Int, serviceId: Int, message: String) {
        val log = Log(logId, machineId, serviceId, message)
        logs.add(log)
        val indexOfAddedLog = logs.lastIndex

        val machineLogs = machineMap.getOrDefault(machineId, mutableListOf())
        machineLogs.add(indexOfAddedLog)
        machineMap[machineId] = machineLogs

        val serviceLogs = serviceMap.getOrDefault(serviceId, mutableListOf())
        serviceLogs.add(indexOfAddedLog)
        serviceMap[serviceId] = serviceLogs
    }

    fun getLogsFromMachine(machineId: Int): List<Int> {
        return machineMap.getOrDefault(machineId, mutableListOf())
            .map { logs[it].logId }
    }

    fun getLogsOfService(serviceId: Int): List<Int> {
        return serviceMap.getOrDefault(serviceId, mutableListOf())
            .map { logs[it].logId }
    }

    fun search(serviceId: Int, searchString: String): List<String> {
        return serviceMap.getOrDefault(serviceId, mutableListOf())
            .map { logs[it].message }
            .filter { it.contains(searchString) }
    }

}


fun main() {
    val logAggregator = LogAggregator(3, 3) // There are 3 machines and 3 services

    logAggregator.pushLog(2322, 1, 1, "Machine 1 Service 1 Log 1")
    logAggregator.pushLog(2312, 1, 1, "Machine 1 Service 1 Log 2")
    logAggregator.pushLog(2352, 1, 1, "Machine 1 Service 1 Log 3")
    logAggregator.pushLog(2298, 1, 1, "Machine 1 Service 1 Log 4")
    logAggregator.pushLog(23221, 1, 2, "Machine 1 Service 2 Log 1")
    logAggregator.pushLog(23121, 1, 2, "Machine 1 Service 2 Log 2")
    logAggregator.pushLog(23222, 2, 2, "Machine 2 Service 2 Log 1")
    logAggregator.pushLog(23122, 2, 2, "Machine 2 Service 2 Log 2")
    logAggregator.pushLog(23521, 1, 2, "Machine 1 Service 2 Log 3")
    logAggregator.pushLog(22981, 1, 2, "Machine 1 Service 2 Log 4")
    logAggregator.pushLog(23522, 2, 2, "Machine 2 Service 2 Log 3")
    logAggregator.pushLog(22982, 2, 2, "Machine 2 Service 2 Log 4")


    val logsOfMachine2 = logAggregator.getLogsFromMachine(2) // return [23222, 23122, 23522, 22982]
    println(logsOfMachine2 == listOf(23222, 23122, 23522, 22982))

    // Machine 2 added 4 logs, so we return them in the order they were added.
    val logsOfService2 =
        logAggregator.getLogsOfService(2) // return [23221, 23121, 23222, 23122, 23521, 22981, 23522, 22982]
    println(logsOfService2 == listOf(23221, 23121, 23222, 23122, 23521, 22981, 23522, 22982))

    // 8 logs were added while running service 2 on a machine.
    val log1Search = logAggregator.search(1, "Log 1") // return ["Machine 1 Service 1 Log 1"]
    println(log1Search == listOf("Machine 1 Service 1 Log 1"))

    // There is only one log that was added while running service 1 and contains "Log 1".
    // return ["Machine 1 Service 2 Log 3", "Machine 2 Service 2 Log 3"]
    val log2Search = logAggregator.search(2, "Log 3")
    println(log2Search == listOf("Machine 1 Service 2 Log 3", "Machine 2 Service 2 Log 3"))

    // 2 logs were added while running service 2 that contain "Log 3".
}
