import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Super Balanced = Height Balanced
 */
public class BalanceBinaryTree {

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(100);
        BinaryTreeNode level1Left = root.insertLeft(1);
        BinaryTreeNode level1Right = root.insertRight(2);
        BinaryTreeNode level2Left = level1Left.insertLeft(3);
        level2Left.insertLeft(4);

        BalanceBinaryTree tree = new BalanceBinaryTree();
        System.out.println((tree.isBalanced(root)) ? "YES" : "NO");
    }

    public boolean isBalanced(BinaryTreeNode treeRoot) {

        // a tree with no nodes is superbalanced, since there are no leaves!
        if (treeRoot == null) {
            return true;
        }

        List<Integer> depths = new ArrayList<Integer>(3); // we short-circuit as soon as we find more than 2

        // nodes will store pairs of a node and the node's depth
        Stack<NodeDepthPair> nodes = new Stack<NodeDepthPair>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.empty()) {

            // pop a node and its depth from the top of our stack
            NodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // case: we found a leaf
            if (node.left == null && node.right == null) {

                // we only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    // two ways we might now have an unbalanced tree:
                    //   1) more than 2 different leaf depths
                    //   2) 2 leaf depths that are more than 1 apart
                    if ((depths.size() > 2) ||
                            (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }

                // case: this isn't a leaf - keep stepping down
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
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

    private class NodeDepthPair {

        BinaryTreeNode node;
        int depth;

        public NodeDepthPair(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}


