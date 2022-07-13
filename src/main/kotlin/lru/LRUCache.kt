package lru

fun main() {
    val cache = LRUCache<Int>(capacity = 3)
    cache.put("key1", 10)
    cache.put("key2", 11)
    cache.put("key3", 12)
    cache.put("key4", 13)
    cache.get("key2")
    cache.put("key2", 11)
    cache.put("key5", 15)
}

class LRUCache<T>(private val capacity: Int) {

    private val cache = hashMapOf<String, Node<T>>()
    private var internalQueue: DoublyLinkedList<T> = DoublyLinkedList()
    private var size = 0

    /**
     * Get a node in out queue, in this case, since we just accessed the
     * node, we move the node to the front to become most recent used.
     * We then return the value of the node otherwise null if node is null
     */
    fun get(key: String): T? {
        val node = cache[key]
        internalQueue.moveNodeToFront(node)
        return if (node == null) null
        else cache[key]?.value
    }

    /**
     * Here, we are adding a new node to our cache,
     *
     * CASE 1:
     * if the node with the given key exist, no need for adding the node,
     * we move the node to front, and it becomes the most recent used
     *
     * CASE 2:
     * if the node with the given key does not exist, first we check if
     * out cache capacity is full, if true we remove the LEAST ACCESSED
     * and reduce our cache capacity
     * We then add a new node with the give key at the front of the queue
     * and keep track of the node in our cache hashmap and increment the
     * cache capacity
     */
    fun put(key: String, value: T) {
        if (cache.contains(key)) {
            cache[key]?.value = value
            internalQueue.moveNodeToFront(cache[key]!!)
        }

        if (size == capacity) {
            val rearKey = internalQueue.getRearKey()
            internalQueue.removeNodeAtRear()
            cache.remove(rearKey)
            size--
        }

        val node = Node(key, value)
        internalQueue.insertNodeAtFront(node)
        cache[key] = node
        size++
    }

}

class Node<T>(val key: String, var value: T) {
    var prev: Node<T>? = null
    var next: Node<T>? = null
}

class DoublyLinkedList<T> {
    var front: Node<T>? = null
    var rear: Node<T>? = null

    override fun toString(): String {
        return "Front -> $front, Rear -> $rear"
    }

    fun insertNodeAtFront(node: Node<T>) {
        if (rear == null) {
            rear = node
            front = node
            return
        }
        println("Inserting node with key ${node.key} at front")
        node.next = front
        front?.prev = node
        front = node
    }

    fun moveNodeToFront(node: Node<T>?) {
        if (front == node) return

        println("Node with key ${node?.key} moved to front")
        if (node == rear) {
            rear = node?.prev
            rear?.next = null
        } else {
            node?.prev?.next = node?.next
            node?.next?.prev = node?.prev
        }

        insertNodeAtFront(node!!)

        node?.prev = null
        node?.next = front
        front?.prev = node
        front = node
    }

    fun removeNodeAtRear() {
        if (rear == null) return

        println("Removing key: ${rear!!.key}")
        if (front == rear) {
            front = null
            rear = null
        } else {
            rear = rear!!.prev
            rear?.next = null
        }
    }

    fun getRearKey(): String? {
        return rear?.key
    }
}