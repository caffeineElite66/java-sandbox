# Binary Tree

A binary tree is a tree where each node has no more than 2 children.

Max number of nodes a level i can have is `maxNodes = Math.pow(2, i)`

The operational time complexity of a binary tree is proportional to the height of the tree. It is important to keep the height of the tree low.


A complete binary tree is:
1. exception the last level, all other nodes are filled.
2. should be filled as left as possible.

## Balance tree
### A balance binary tree is when the height of left and right subtree for every node is not more than 1.

A balanced binary tree is:
1. weight-balance tree - number of nodes in left vs right subtree is diff <= 1
2. height-balance tree - height of nodes in left vs right subtree is diff <= 1

Height of an empty tree = -1

Height of an tree with 1 node = 0

![](resources/binary-tree.png?raw=true)


#### Check for height balance tree.
```java
/**
* Return -1 is not balanced.
* @param root
* @return
*/
private static int checkHeightBalanced(BTreeNode root) {
    if (root == null) return 0;
    int leftHeight = checkHeightBalanced(root.left);
    int rightHeight = checkHeightBalanced(root.right);
    if (leftHeight == -1 || rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight, rightHeight) + 1;
}
```

## Traverse tree
### Breath First
Useful when you want to display the tree in it's hierarchy, decision tree...etc.
You need to use a queue to keep track of each level when you move your way down.
```java
  private static void breadthFirstTraversal(BTreeNode node) {
      Queue queue = new LinkedList<BTreeNode>();
      queue.add(node);
      while (!queue.isEmpty()) {
          BTreeNode currentNode = (BTreeNode) queue.remove();
          if (currentNode.left != null) queue.add(currentNode.left);
          if (currentNode.right != null) queue.add(currentNode.right);
          System.out.print(currentNode.data + ", ");
      }
  }
```
### Depth First - in,pre,post order traversal
Go through the tree recursivly. 
```java
  // left to right
  private static void inOrderTraversal(BTreeNode node) {
      if (node == null) return;
      inOrderTraversal(node.left);
      System.out.print(node.data + ", ");
      inOrderTraversal(node.right);
  }

  // up to down
  private static void preOrderTraversal(BTreeNode node) {
      if (node == null) return;
      System.out.print(node.data + ", ");
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
  }

  // down to up
  private static void postOrderTraversal(BTreeNode node) {
    if (node == null) return;
    postOrderTraversal(node.left);
    postOrderTraversal(node.right);
    System.out.print(node.data + ", ");
  }
```

 ## Store Binary Tree in Memory
 1. using a node class with pointers. (most common way)
 2. arrays. usually use for a perfect binary tree. `left-child-index = 2i+1` and `right-child-index = 2i+2` Need to be a complete binary tree.
