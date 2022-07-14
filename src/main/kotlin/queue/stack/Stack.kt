package queue.stack

import stack.StackOperation

fun main() {
    val stack = Stack<String>()
    stack.apply {
        push("Monday")
        push("Tuesday")
        push("Wednesday")
    }
    println(stack)
    println(stack.count)
    println(stack.pop())
    println(stack)
    println(stack.count)
    stack.push("Thursday")
    println(stack.peek())
}

class Stack<T> : StackOperation<T> {

    var storage = arrayListOf<T>()

    override fun push(t: T) {
        storage.add(t)
    }

    override fun pop(): T? {
        val item = storage.lastOrNull()
        storage.remove(item)
        return item
    }

    override fun peek(): T? {
        return if (isEmpty) null
        else storage[storage.size - 1]
    }

    override val count: Int
        get() = storage.size

    override fun toString(): String {
        return storage.toString()
    }
}