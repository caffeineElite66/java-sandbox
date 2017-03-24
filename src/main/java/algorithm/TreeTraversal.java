package algorithm;

import datastructure.BTreeNode;


class TreeTraversal {

  public static void main (String[] args) {
      BTreeNode<Integer> node1 = new BTreeNode<>(1);
      BTreeNode<Integer> node2 = new BTreeNode<>(2);
      BTreeNode<Integer> node3 = new BTreeNode<>(3);
      BTreeNode<Integer> node4 = new BTreeNode<>(4);
      BTreeNode<Integer> node5 = new BTreeNode<>(5);
      BTreeNode<Integer> node6 = new BTreeNode<>(6);

    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;


      BTreePrinter.printNode(node1);

      System.out.println("\nPRE ORDER: ");
      preOrderTraversal(node1);

      System.out.println("\nPOST ORDER: ");
      postOrderTraversal(node1);

      System.out.println("\nIN ORDER: ");
      inOrderTraversal(node1);
  }

  // left to right
  private static void inOrderTraversal(BTreeNode node) {

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
      if (node.left == null && node.right == null) {
          System.out.print(node.data + ", ");
          return;
      }

      postOrderTraversal(node.left);

      postOrderTraversal(node.right);


  }
}
