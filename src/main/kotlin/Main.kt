import binary_search.BinarySearch
import linked_list.LinkedList
import stack.Stack
import stack.stackOf

fun main(args: Array<String>) {
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    val binarySearch = BinarySearch()
    println(binarySearch.search(9, arrayOf(1, 2, 3, 4, 5,6,7,8,9, 10)))


//    val stack = stackOf("A", "B", "C", "D", "E", "F")
//
//    reverseLinkedList()
}

fun reverseLinkedList() {
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3).push(4).push(5)
    println(list)
    val stack = Stack<Int>()
    for(item in list) {
        stack.push(item)
    }
    
    val reversedList = LinkedList<Int>()
    while (!stack.isEmpty) {
        reversedList.push(stack.pop()!!)
    }
    print("Items in reverse $reversedList")
}

fun pushExample() {
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3).push(4)
    list.push(2)
    list.push(3)
    list.push(4)

    println(list)
}

fun appendExample() {
    val list = LinkedList<Int>()
    list.append(1).append(2).append(3).append(4)
    list.append(3)
    list.append(4)
    list.append(5)
    println(list)
}

fun insertExample() {
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3)
    println("Before inserting list: $list")
    var middleNode = list.nodeAt(1)
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode!!)
    }
    println("After inserting: $list")
}