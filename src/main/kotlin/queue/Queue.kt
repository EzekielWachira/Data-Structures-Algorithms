package queue

interface Queue<T> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    fun isEmpty(): Boolean
    fun peek(): T?
    val count: Int
        get
}