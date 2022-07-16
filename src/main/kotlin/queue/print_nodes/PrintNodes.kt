package queue.print_nodes

class PrintNodes {

    /**
     * Iterative approach to print all nodes between two given
     * levels in a binary tree
     */
    fun printNodes(root: Node?, start: Int, end: Int) {

        if (root == null) return

        /**
         * Create an empty queue and add the root node
         */
        val queue = ArrayDeque<Node>()
        queue.add(root)

        /**
         * Keep track of current node
         */
        var current: Node? = null

        /**
         * Maintain level of current node
         */
        var level = 0

        while (!queue.isEmpty()) {
            level++

            /**
             * Calculate number of nodes at current level
             */
            var size = queue.size
            while (size-- > 0) {
//                current = queue.poll
            }
        }
    }

}