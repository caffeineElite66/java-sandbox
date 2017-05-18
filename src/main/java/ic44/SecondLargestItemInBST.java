// package ic44;

class SecondLargestItemInBST {

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode l1left = root.insertLeft(5);
        BinaryTreeNode l1right = root.insertRight(15);

        l1left.insertLeft(4);
        l1left.insertRight(7);

        l1right.insertRight(14);

        System.out.println(findSecondLargest(root));
    }

    public static int findSecondLargest(BinaryTreeNode root) {
        BinaryTreeNode node = root;
        int secondLargest = root.value;
        while (node.right != null) {
            secondLargest = node.value;
            node = node.right;
        }
        if (node.left != null) secondLargest = node.left.value;

        return secondLargest;
    }

    public static class BinaryTreeNode {

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
