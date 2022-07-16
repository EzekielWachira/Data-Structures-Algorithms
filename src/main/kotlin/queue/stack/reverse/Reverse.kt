package queue.stack.reverse

import queue.Queue
import queue.stack.Stack

/**
 * Reverse a queue using a stack
 * O(n) time complexity
 * O(n) space complexity
 */
fun <T> Queue<T>.reverse() {
    var aux  = Stack<T>()

    var next = dequeue()
    while (next != null) {
        aux.push(next)
        next = dequeue()
    }

    next = aux.pop()
    while (next != null) {
        enqueue(next)
        next = aux.pop()
    }
}