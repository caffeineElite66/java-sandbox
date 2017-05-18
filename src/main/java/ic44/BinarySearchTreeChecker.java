

public class BinarySearchTreeChecker {

  public static void main (String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(10);

    BinaryTreeNode l1left = root.insertLeft(5);
    BinaryTreeNode l1right = root.insertRight(11);

    l1left.insertLeft(4);
    l1left.insertRight(7);

    l1right.insertRight(16);

    System.out.println((isBST(root)) ? "YES" : "NO");
    System.out.println((isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))? "YES" : "NO");
  }

  private static boolean isBST(BinaryTreeNode node) {
    if (node == null) return true;
    if (node.left != null && node.left.value > node.value) return false;
    if (node.right != null && node.right.value < node.value) return false;
    return isBST(node.left) && isBST(node.right);
  }

  private static boolean isValidBST(BinaryTreeNode p, int min, int max){
    if(p==null) return true;
    if(p.value <= min || p.value >= max) return false;
    return isValidBST(p.left, min, p.value) && isValidBST(p.right, p.value, max);
}

  private static class BinaryTreeNode {

      public int value;
      public BinaryTreeNode left;
      public BinaryTreeNode right;

      public BinaryTreeNode(int value) {
          this.value = value;
      }

      public BinaryTreeNode insertLeft(int leftValue) {
          this.left = new BinaryTreeNode(leftValue);
          return this.left;
      }

      public BinaryTreeNode insertRight(int rightValue) {
          this.right = new BinaryTreeNode(rightValue);
          return this.right;
      }
  }
}
