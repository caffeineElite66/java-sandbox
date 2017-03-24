package algorithm;

import datastructure.BTreeNode;

public class CheckBalanceBTree {

  public static void main (String[] args) {
    BTreeNode<Integer> root = new BTreeNode(1);
    BTreeNode<Integer> node2 = new BTreeNode(2);
    BTreeNode<Integer> node3 = new BTreeNode(3);
    BTreeNode<Integer> node4 = new BTreeNode(4);
    BTreeNode<Integer> node5 = new BTreeNode(5);
    BTreeNode<Integer> node6 = new BTreeNode(6);

    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node4.left = node6;

    BTreePrinter.printNode(root);
    System.out.println((isBalanced(root)) ? "Balanced!" : "Not Balanced!");
  }

  private static boolean isBalanced(BTreeNode root) {
    return (checkHeightBalanced(root) != -1);
  }

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



}
