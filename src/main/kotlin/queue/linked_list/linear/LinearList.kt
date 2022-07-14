package queue.linked_list.linear

import java.lang.IllegalStateException

fun main() {
    val list = LinearList<String>()
    println("Size => ${list.size}")
    list.apply {
        enqueue("Monday")
        enqueue("Tuesday")
        enqueue("Wednesday")
    }
    println(list)
    println("Size => ${list.size}")
    println(list.dequeue())
    println("Size => ${list.size}")
    println(list)
}

class LinearList<T> {

    var front: SingleNode<T>? = null
    var rear: SingleNode<T>? = null
    var count = 0

    val size get() = count

    fun isEmpty(): Boolean = front == null

    fun peek(): T? = front?.value

    fun enqueue(value: T) {
        val node = SingleNode(value)
        if (front == null) {
            front = node
            rear = node
        } else {
            node.next = rear
            rear = node
        }
        count += 1
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            throw IllegalStateException("Queue is empty")
        }

        val tempNode = front
        if (front == rear) {
            front = null
            rear = null
        } else {
            front = front?.next
        }
        count -= 1
        return tempNode?.value
    }

    fun rear(): T? {
        if (isEmpty()) throw IllegalStateException("Queue is empty")
        else return rear?.value
    }

    override fun toString(): String {
        return "Front => ${front?.value}, Rear => ${rear?.value}"
    }
}
