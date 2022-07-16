package trees

import queue.ArrayListQueue
import queue.Queue
import queue.linked_list.LinkedListQueue
import queue.stack.StackQueue

fun main() {
    val tree = makeBeverageTree()
//    tree.forEachLevelOrder {
//        println(it.value)
//    }
//    tree.search("white coffee")?.let {
//        println("Node White Coffee Found: ${it.value}")
//    }
//
//    tree.search("lemon")?.let {
//        println("Node White Coffee Found: ${it.value}")
//    } ?: println("Node not found")

    tree.printNds()


}

fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("chocolate")

    val blackTea = TreeNode("black tea")
    val greenTea = TreeNode("green tea")
    val chaiTea = TreeNode("chai tea")

    val whiteCoffee = TreeNode("white coffee")
    val blackCoffee = TreeNode("black coffee")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.apply {
        add(hot)
        add(cold)
    }

    hot.apply {
        add(tea)
        add(coffee)
        add(chocolate)
    }

    cold.apply {
        add(soda)
        add(milk)
    }

    tea.apply {
        add(blackTea)
        add(greenTea)
        add(chaiTea)
    }

    coffee.apply {
        add(whiteCoffee)
        add(blackCoffee)
    }

    soda.apply {
        add(gingerAle)
        add(bitterLemon)
    }

    return tree
}

typealias Visitor<T> = (TreeNode<T>) -> Unit
class TreeNode<T>(val value: T) {
    private val children = mutableListOf<TreeNode<T>>()

    fun add(node: TreeNode<T>) {
        children.add(node)
    }

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach { child->
            child.forEachDepthFirst(visit)
        }
    }

    fun levelOrderTraversal(visit: Visitor<T>) {
        visit(this)
        val queue = LinkedListQueue<TreeNode<T>>()
        children.forEach { child->
            queue.enqueue(child)
        }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { child->
                queue.enqueue(child)
            }
            node = queue.dequeue()
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)

        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { child->
            queue.enqueue(child)
        }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { child->
                queue.enqueue(child)
            }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        levelOrderTraversal { node->
            if (node.value == value) {
                result = node
            }
        }
        return result
    }

    fun printEachLevel() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty().not()) {
            nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let { nd->
                    print(nd.value)
                    node.children.forEach { child->
                        queue.enqueue(child)
                    }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
            println()
        }
    }

    fun printNodes() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var leftNodesInCurrentNode = 0

        queue.enqueue(this)
        while (!queue.isEmpty()) {
            leftNodesInCurrentNode = queue.count
            while (leftNodesInCurrentNode > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { child->
                        queue.enqueue(child)
                    }
                    leftNodesInCurrentNode--
                } ?: break
            }
            println()
        }
    }


    fun printNds() {
        val queue = LinkedListQueue<TreeNode<T>>()
        var nodesLeft = 0

        queue.enqueue(this)
        while (!queue.isEmpty()) {
            nodesLeft = queue.count
            while (nodesLeft > 0) {
                val node = queue.dequeue()
                node?.let { nd->
                    print("${nd.value} ")
                    node.children.forEach { child->
                        queue.enqueue(child)
                    }
                    nodesLeft--
                } ?: break
            }
            println()
        }
    }
}

