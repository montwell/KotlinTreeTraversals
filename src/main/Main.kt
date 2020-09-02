package main

fun main() {

    val rootOfBinaryTestTree = rootOfBinaryTestTree()

    println("Preorder")
    BinaryNode.traversePreorder(rootOfBinaryTestTree) {
        println(it)
    }

    println("\nInorder")
    BinaryNode.traverseInorder(rootOfBinaryTestTree) {
        println(it)
    }

    println("\nPostorder")
    BinaryNode.traversePostOrder(rootOfBinaryTestTree) {
        println(it)
    }

    val rootOfNAryTestTree = rootOfNAryTestTree()

    println("\nDepth First")
    Node.traverseDepthFirst(rootOfNAryTestTree) {
        println(it)
    }

    println("\nBreadth First")
    Node.traverseBreadthFirst(rootOfNAryTestTree) {
        println(it)
    }

    println("\nTest Breadth First Search")
    var found3 = false
    var found9 = false

    Node.traverseBreadthFirst(rootOfNAryTestTree) {
        if(it == 3) {
            found3 = true
        }
        if(it == 9) {
            found9 = true
        }
    }
    println("found3 = $found3, found9 = $found9")
}

/**
 *                      (1)
 *                     /  \
 *                  (2)    (3)
 *                  / \    / \
 *                (4) (5)(6) (7)
 */
fun rootOfBinaryTestTree(): BinaryNode<Int> {

    var rootNode = BinaryNode(1)
    rootNode.left = BinaryNode(2)
    rootNode.right = BinaryNode(3)
    rootNode.left?.left = BinaryNode(4)
    rootNode.left?.right = BinaryNode(5)
    rootNode.right?.left = BinaryNode(6)
    rootNode.right?.right = BinaryNode(7)

    return rootNode
}

/**
 *                       (1)
 *                     /    \
 *                   (2)    (3)
 *                  / | \   |  \
 *                (4)(5)(6)(7) (8)
 */
fun rootOfNAryTestTree(): Node<Int> {

    var level1Node1 = Node(2)
    level1Node1.children = mutableListOf(Node(4), Node(5), Node(6))

    var level1Node2 = Node(3)
    level1Node2.children = mutableListOf(Node(7), Node(8))

    var rootNode = Node(1)
    rootNode.children = mutableListOf(level1Node1, level1Node2)

    return rootNode
}