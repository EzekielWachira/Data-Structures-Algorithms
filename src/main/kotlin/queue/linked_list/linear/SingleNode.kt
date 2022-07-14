package queue.linked_list.linear

data class SingleNode<T>(val value: T) {
    var next: SingleNode<T>? = null
}