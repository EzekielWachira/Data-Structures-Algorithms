package queue.linked_list

import queue.Queue

fun main() {
    val linkedListQueue = LinkedListQueue<String>()
    println(linkedListQueue.isEmpty())
    linkedListQueue.apply {
        enqueue("Monday")
        enqueue("Tuesday")
        enqueue("Wednesday")
        enqueue("Thursday")
    }
    println(linkedListQueue.count)
    println(linkedListQueue)
    println(linkedListQueue.dequeue())
    println(linkedListQueue)
    println(linkedListQueue.dequeue())
    println(linkedListQueue)
    println(linkedListQueue.dequeue())
    println(linkedListQueue)
    linkedListQueue.enqueue("Saturday")
    println(linkedListQueue)
}

class LinkedListQueue<T> : Queue<T> {

    private val doublyLinkedList = DoublyLinkedList<T>()

    override fun enqueue(element: T): Boolean {
        return doublyLinkedList.enqueue(Node(element))
    }

    override fun dequeue(): T? {
        return doublyLinkedList.dequeue()?.value
    }

    override fun isEmpty(): Boolean {
        return doublyLinkedList.isEmpty()
    }

    override fun peek(): T? {
        return doublyLinkedList.peek()?.value
    }

    override val count: Int
        get() = doublyLinkedList.count

    override fun toString(): String {
        return "Front -> ${doublyLinkedList.front?.value}, Rear -> ${doublyLinkedList.rear?.value}"
    }
}