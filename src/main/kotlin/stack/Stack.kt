package stack

import linked_list.LinkedList

interface StackOperation<T> {
    fun push(t: T)
    fun pop(): T?
    fun peek(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class Stack<T: Any>: StackOperation<T> {
    private val storage = arrayListOf<T>()

    override fun toString(): String = buildString {
        appendLine("------top-----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("--------------")
    }

    override fun push(t: T) {
        storage.add(t)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(storage.size.minus(1))
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    companion object {
        fun<T: Any> create(elements: Iterable<T>): Stack<T> {
            val stack = Stack<T>()
            for (item in elements) {
                stack.push(item)
            }
            return stack
        }
    }
}

fun <T: Any> stackOf(vararg t: T): Stack<T> {
    return Stack.create(t.asList())
}

//Challenge 1

fun <T: Any> LinkedList<T>.printInReverse() {
    val stack = Stack<T>()

    this.forEach { stack.push(it) }

    var node = stack.pop()
    while (node != null) {
        println(node)
        stack.pop()
    }
}