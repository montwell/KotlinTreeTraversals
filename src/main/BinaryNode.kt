package main

class BinaryNode<T>(
    var value: T,
    var left: BinaryNode<T>? = null,
    var right: BinaryNode<T>? = null
) {

    companion object {

        fun <T> traversePreorder(
            node: BinaryNode<T>?,
            action: (value: T) -> Unit
        ) {
            if(node != null) {
                action.invoke(node.value)
                traversePreorder(node.left, action)
                traversePreorder(node.right, action)
            }
        }

        fun <T> traverseInorder(
            node: BinaryNode<T>?,
            action: (value: T) -> Unit
        ) {
            if(node != null) {
                traverseInorder(node.left, action)
                action.invoke(node.value)
                traverseInorder(node.right, action)
            }
        }

        fun <T> traversePostOrder(
            node: BinaryNode<T>?,
            action: (value: T) -> Unit
        ) {
            if (node != null) {
                traversePostOrder(node.left, action)
                traversePostOrder(node.right, action)
                action.invoke(node.value)
            }
        }
    }
}