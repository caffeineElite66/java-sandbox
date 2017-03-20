package algorithm;

import datastructure.BinaryTreeNode;

public class CheckBalanceBTree {

  public static void main (String[] args) {
    BinaryTreeNode<Integer> root = new BinaryTreeNode(1);
    BinaryTreeNode<Integer> node2 = new BinaryTreeNode(2);
    BinaryTreeNode<Integer> node3 = new BinaryTreeNode(3);
    BinaryTreeNode<Integer> node4 = new BinaryTreeNode(4);
    BinaryTreeNode<Integer> node5 = new BinaryTreeNode(5);
    BinaryTreeNode<Integer> node6 = new BinaryTreeNode(6);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node4.left = node6;

    BTreePrinter.printNode(root);
    System.out.println((isBalanced(root)) ? "Balanced!" : "Not Balanced!");
  }

  private static boolean isBalanced(BinaryTreeNode root) {
    return (checkHeightBalanced(root) != -1);
  }

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



}
