package binary_tree

class BinaryTreeNode(var value: Int) {
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null

    fun insertLeft(leftValue: Int): BinaryTreeNode? {
        left = BinaryTreeNode(leftValue)
        return left
    }

    fun insertRight(rightValue: Int): BinaryTreeNode? {
        right = BinaryTreeNode(rightValue)
        return right
    }

    fun findLargest(root: BinaryTreeNode): Int {
        var current: BinaryTreeNode? = root

        while (current?.right != null) {
            current = current.right
        }

        return current!!.value
    }

    fun findSecondLargest(root: BinaryTreeNode?): Int? {
        /**
         * CASE 1
         * - Check if we have less that 2 nodes
         */
        if (root == null || (root.right == null && root.left == null)) {
            throw IllegalArgumentException("Tree must have at least two elements")
        }

        var current: BinaryTreeNode?  = root

        while (true) {
            /**
             * CASE 2
             * We are currently at the largest element, but it has a left subtree
             * The second largest is the largest in the said subtree
             */
            if (root.left != null && root.right == null) {
                return findLargest(root.left!!)
            }

            /**
             * CASE 3
             * We are currently at the parent of the largest element and it doesn't have
             * a left subtree
             * In this case, the 2nd largest is the value of the current node
             */
            if (root.right != null &&
                root.right!!.left == null
                && root.right!!.right == null
            ) {
                return root.value
            }

            current = current?.right
        }
    }

    fun findSmallestValue(root: BinaryTreeNode?): Int {
        var current  = root
        while (current?.left != null) {
            current = current.left!!
        }
        return current!!.value
    }

    fun getSecondMinimum(root: BinaryTreeNode): Int? {
        if (root == null || (root.left == null && root.right == null))
            throw IllegalArgumentException("Must have at least two nodes")

        var current = root

        while (true) {
            /**
             * Case 1
             */
            if (current.left == null && current.right != null) {
                return findSmallestValue(current.right!!)
            }

            /**
             * Case 2
             */
            if (current.left != null && current.left!!.right == null &&
                    current.left!!.left == null) {
                return current.value
            }

            current = current.left!!
        }
    }
}
