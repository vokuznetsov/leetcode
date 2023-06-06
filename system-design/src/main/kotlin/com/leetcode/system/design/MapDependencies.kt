package com.leetcode.system.design


object MapDependencies {

    fun getDependencies(dependencies: Map<String, List<String>>, element: String): List<String> {
        val result = mutableListOf<String>()
        val visited = mutableSetOf<String>()

        visited.add(element)

        for (elem in dependencies.getOrDefault(element, listOf())) {
            dfs(dependencies, elem, result, visited)
        }

        return result
    }

    private fun dfs(
        dependencies: Map<String, List<String>>,
        element: String,
        result: MutableList<String>,
        visited: MutableSet<String>
    ) {
        if (visited.contains(element)) return

        result.add(element)
        visited.add(element)

        for (elem in dependencies.getOrDefault(element, listOf())) {
            dfs(dependencies, elem, result, visited)
        }
    }
}

fun main() {

    test1()
    test2()

}

private fun test1() {
    // Пример входных данных
    val dependencies = mutableMapOf<String, List<String>>()
    dependencies["A"] = mutableListOf("B", "C", "D")
    dependencies["B"] = mutableListOf("D", "E")

    val element = "A"
    val elementDependencies: List<String> = MapDependencies.getDependencies(dependencies, element)
    println("Dependencies for element $element: $elementDependencies")
}

private fun test2() {
    // Пример входных данных
    val dependencies = mutableMapOf<String, List<String>>()
    dependencies["A"] = mutableListOf("B", "C", "D")
    dependencies["B"] = mutableListOf("D", "E")
    dependencies["C"] = mutableListOf("A", "E")
    dependencies["E"] = mutableListOf("J")

    val element = "E"
    val elementDependencies: List<String> = MapDependencies.getDependencies(dependencies, element)
    println("Dependencies for element $element: $elementDependencies")
}