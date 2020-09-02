package main

class Node<T>(
    var value: T,
    var children: MutableList<Node<T>> = mutableListOf()
) {

    companion object {

        fun <T> traverseDepthFirst(
            rootNode: Node<T>,
            action: (value: T) -> Unit
        ) {
            val stack = ArrayDeque<Node<T>>()
            stack.addFirst(rootNode)

            while(stack.isNotEmpty()) {
                val currentNode = stack.removeFirst()

                action.invoke(currentNode.value)

                for(index in currentNode.children.size - 1 downTo 0) {
                    stack.addFirst(currentNode.children[index])
                }
            }
        }

        fun <T> traverseBreadthFirst(
            rootNode: Node<T>,
            action: (value: T) -> Unit
        ) {
            val queue = ArrayDeque<Node<T>>()
            queue.addFirst(rootNode)

            while(queue.isNotEmpty()) {
                val currentNode = queue.removeLast()

                action.invoke(currentNode.value)

                for(childNode in currentNode.children) {
                    queue.addFirst(childNode)
                }
            }
        }
    }
}