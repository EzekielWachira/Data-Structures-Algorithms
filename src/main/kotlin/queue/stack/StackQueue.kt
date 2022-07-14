package queue.stack

import queue.Queue

fun main() {
    val queue = StackQueue<String>()
    queue.apply {
        enqueue("Monday")
        enqueue("Tuesday")
        enqueue("Wednesday")
    }
    println(queue)
    println(queue.peek())
    println(queue)
    println(queue.dequeue())
    println(queue)
}

class StackQueue<T> : Queue<T> {

    private val stack1 = Stack<T>()
    private val stack2 = Stack<T>()

    override fun enqueue(element: T): Boolean {
        stack1.push(element)
        return true
    }

    override fun dequeue(): T? {
        if (stack2.isEmpty) transferElements()
        return stack2.pop()
    }

    override fun isEmpty(): Boolean {
        return stack1.isEmpty && stack2.isEmpty
    }

    override fun peek(): T? {
        if (stack2.isEmpty) {
            transferElements()
        }
        return stack2.peek()
    }

    override val count: Int
        get() = stack1.count

    private fun transferElements() {
        var element = stack1.pop()
        do {
            stack2.push(element!!)
            element = stack1.pop()
        } while (element != null)
    }

    override fun toString(): String {
        return "Left stack: \n$stack1 \n Right stack:\n$stack2"
    }
}