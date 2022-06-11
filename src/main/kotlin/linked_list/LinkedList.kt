package linked_list

import Node
import java.lang.IndexOutOfBoundsException

class LinkedList<T>: Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }


    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currenNode = head
        var currentIndex = 0

        while (currenNode != null && currentIndex < index) {
            currenNode = currenNode.next
            currentIndex++
        }
        return currenNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null

        if (head.next == null) return pop()
        size--

        var current = head
        var prev = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }
}

class LinkedListIterator<T>(
    private val linkedList: LinkedList<T>
): Iterator<T> {
    private var index = 0
    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < linkedList.size
    }

    override fun next(): T {
        if (index >= linkedList.size) throw IndexOutOfBoundsException()
        lastNode = if (index == 0) {
            linkedList.nodeAt(0)
        } else {
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }
}

fun <T> LinkedList<T>.printInReverse() {

}