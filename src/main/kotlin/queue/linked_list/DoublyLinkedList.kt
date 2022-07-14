package queue.linked_list

import org.jetbrains.annotations.TestOnly

class DoublyLinkedList<T> {
    var front: Node<T>? = null
    var rear: Node<T>? = null

    var size = 0

    /**
     * Insert element at the rear
     */
    fun enqueue(node: Node<T>): Boolean {
        if (rear == null) {
            rear = node
            front = node
            size += 1
            return true
        }

        node.prev = rear
        rear?.next = node
        rear = node
        size += 1
        return true
    }

    fun dequeue(): Node<T>? {
        return if (front == null) {
            null
        } else {
            val nodeToDelete = front
            front?.next?.prev = null
            front = front?.next
            size -= 1
            nodeToDelete
        }
    }

    fun peek(): Node<T>? = front

    val count = size

    fun isEmpty() = front == null && rear == null

    override fun toString(): String {
        return "Front -> ${front?.value}, Rear -> ${rear?.value}"
    }
}

//interface DoublyLinkedList<T> {
//    fun enqueue(element: T)
//    fun dequeue(): T?
//}

