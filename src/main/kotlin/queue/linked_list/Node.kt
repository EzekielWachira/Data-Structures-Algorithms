package queue.linked_list

class Node<T>(val value: T) {
    var prev: Node<T>? = null
    var next: Node<T>? = null
}
