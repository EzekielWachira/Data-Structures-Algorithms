package queue.ring_buffer

import queue.Queue

fun main() {
    val ringBufferQueue = RingBufferQueue(5)
    ringBufferQueue.apply {
        enqueue(1)
        enqueue(2)
        enqueue(3)
        enqueue(4)
        enqueue(5)
    }
    println(ringBufferQueue)
    ringBufferQueue.dequeue()
    println(ringBufferQueue.peek())
    println(ringBufferQueue)

}

class RingBufferQueue(size: Int) : Queue<Int> {

    private val ringBuffer = CircularQueue(size)

    override fun enqueue(element: Int): Boolean {
        ringBuffer.enqueue(element)
        return true
    }

    override fun dequeue(): Int? {
        return ringBuffer.dequeue()
    }

    override fun isEmpty(): Boolean {
        return ringBuffer.isEmpty()
    }

    override fun peek(): Int? {
       return ringBuffer.peek()
    }

    override val count: Int
        get() = ringBuffer.size

    override fun toString(): String {
        return ringBuffer.toString()
    }
}

class CircularQueue(size: Int) {

    private var front: Int = -1
    private var rear: Int = -1
    var items = IntArray(size)

    fun enqueue(item: Int) {
        if (isFull()) resize()
        else if(isEmpty()) front++
        rear = (rear + 1) % items.size
        items[rear] = item
    }

    fun dequeue(): Int {
        if (isEmpty()) throw IllegalStateException("Queue is empty")
        val temp = items[front]
        if (front == rear) {
            front = -1
            rear = -1
        } else {
            front = (front + 1) % items.size
        }

        return temp
    }

    private fun resize() {
        val tempArr = IntArray(items.size.times(2))
        var i = 0
        var j = front

        do {
            tempArr[i++] = items[j]
            j = (j.plus(1)) % items.size
        } while (j != front)
    }

    private fun isFull() = (rear + 1) % items.size == front

    fun isEmpty(): Boolean = front == -1

    fun peek(): Int? = items.getOrNull(front)

    val size = items.size

    override fun toString(): String {
        return items.toList().toString()
    }

}


internal class MyCircularQueue(var cap: Int) {
    var q = IntArray(cap)
    var front: Int = -1
    var rear: Int = -1
    var size: Int = 0

    init {

        front = size
        rear = cap - 1
    }

    fun enQueue(value: Int): Boolean {
        if (size < cap) {
            rear = (rear + 1) % cap
            q[rear] = value
            size++
            return true
        }
        return false
    }

    fun deQueue(): Boolean {
        if (size > 0) {
            front = ++front % cap
            size--
            return true
        }
        return false
    }

    fun Front(): Int {
        return if (size > 0) q[front] else -1
    }

    fun Rear(): Int {
        return if (size > 0) q[rear] else -1
    }

    val isEmpty: Boolean
        get() = size == 0
    val isFull: Boolean
        get() = size == cap
}
