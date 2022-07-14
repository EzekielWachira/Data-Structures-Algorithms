package queue

fun main() {
    val arrayListQueue = ArrayListQueue<String>()
    println("Queue with arrayList")
    arrayListQueue.apply {
        enqueue("Sunday")
        enqueue("Monday")
        enqueue("Tuesday")
        enqueue("Wednesday")
    }
    println(arrayListQueue)
    println("Peek: ${arrayListQueue.peek()}")
    println("Size: ${arrayListQueue.count}")
    arrayListQueue.dequeue()
    println(arrayListQueue)
    arrayListQueue.enqueue("Sunday")
    println(arrayListQueue)
}

/**
 * ADVANTAGES OF USING ARRAYLIST FOR QUEUE IMPLEMENTATION
 * Count and Peek run at O(1)
 * Enqueue runs at O(1) regardless the size of the list
 * Dequeue runs at O(n) since we have to shift all the elements to
 * cover the empty space left after removing an element
 *
 * resize the list to allocate
 * new memory and copy the existing elements to the new list
 *
 * Space complexity of this approach is O(n)
 */
class ArrayListQueue<T> : Queue<T> {

    private val list = arrayListOf<T>()

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? {
        return if (isEmpty()) null
        else list.removeAt(0)
    }

    override fun peek(): T? {
        return list.getOrNull(0)
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override val count: Int
        get() = list.size

    override fun toString(): String {
        return list.toString()
    }
}