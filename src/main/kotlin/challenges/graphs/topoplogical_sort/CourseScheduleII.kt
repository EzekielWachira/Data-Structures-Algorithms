package challenges.graphs.topoplogical_sort

import java.util.*


class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray? {
        val g = buildGraph(numCourses, prerequisites)
        val visited = BooleanArray(numCourses)
        val onStack = BooleanArray(numCourses)
        val queue: Queue<Int> = LinkedList()
        for (i in 0 until numCourses) {
            if (!visited[i] && hasCycle(g, i, visited, onStack, queue)) return IntArray(0)
        }
        var i = 0
        val result = IntArray(numCourses)
        while (!queue.isEmpty()) result[i++] = queue.poll()
        return result
    }

    fun hasCycle(g: Graph, src: Int, visited: BooleanArray, onStack: BooleanArray, queue: Queue<Int>): Boolean {
        visited[src] = true
        onStack[src] = true
        val adjVertices = g.adjVertices(src)
        for (vertex in adjVertices!!) {
            if (!visited[vertex] && hasCycle(g, vertex, visited, onStack, queue) ||
                onStack[vertex]
            ) return true
        }
        queue.add(src)
        onStack[src] = false
        return false
    }

    fun buildGraph(n: Int, edges: Array<IntArray>): Graph {
        val g = Graph(n)
        for (edge in edges) {
            g.addEdge(edge[0], edge[1])
        }
        return g
    }
}

class Graph {
    var adjList: Array<MutableList<Int>?>

    constructor(n: Int) {
        adjList = arrayOfNulls(n)
        for (i in 0 until n) {
            adjList[i] = LinkedList()
        }
    }

    fun addEdge(src: Int, dest: Int) {
        adjList[src]!!.add(dest)
    }

    fun adjVertices(vertex: Int): List<Int>? {
        return adjList[vertex]
    }
}


class MyStack {
    private val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
        for (i in 0 .. queue.lastIndex) {
            queue.add(queue.pollLast())
        }
    }

    fun pop(): Int = queue.pollLast()

    fun top(): Int = queue.peekLast()

    fun empty(): Boolean = queue.isEmpty()

    fun size(): Int = queue.size

}