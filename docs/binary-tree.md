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
1. weight-balance tree
  * number of nodes in left vs right subtree is diff <= 1
2. height-balance tree
  * height of nodes in left vs right subtree is diff <= 1

Height of an empty tree = -1

Height of an tree with 1 node = 0

![](resources/binary-tree.png?raw=true)


#### Check for height balance tree.
```
/**
* Return -1 is not balanced.
* @param root
* @return
*/
private static int checkHeightBalanced(BinaryTreeNode root) {
    if (root == null) return 0;
    int leftHeight = checkHeightBalanced(root.left);
    int rightHeight = checkHeightBalanced(root.right);
    if (leftHeight == -1 || rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight, rightHeight) + 1;
}
```


 ## Store Binary Tree in Memory
 1. using a node class with pointers. (most common way)
 2. arrays. usually use for a perfect binary tree. `left-child-index = 2i+1` and `right-child-index = 2i+2` Need to be a complete binary tree.
