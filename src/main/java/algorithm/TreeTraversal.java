package algorithm;

import datastructure.BTreeNode;

class TreeTraversal {

  public static void main (String[] args) {
    BTreeNode node1 = new BTreeNode(1);
    BTreeNode node2 = new BTreeNode(2);
    BTreeNode node3 = new BTreeNode(3);
    BTreeNode node4 = new BTreeNode(4);
    BTreeNode node5 = new BTreeNode(5);
    BTreeNode node6 = new BTreeNode(6);

    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;

    BTreePrinter p = new BTreePrinter();
    p.printNode(node1);
  }

  // left to right
  private static void inOrderTraversal(BTreeNode node) {

  }

  // up to down
  private static void preOrderTraversal(BTreeNode node) {

  }

  // down to up
  private static void postOrderTraversal(BTreeNode node) {

  }
}
