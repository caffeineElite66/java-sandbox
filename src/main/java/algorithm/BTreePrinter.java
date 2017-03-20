package algorithm;

import datastructure.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(BinaryTreeNode<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printBinaryTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBinaryTreeNodeInternal(List<BinaryTreeNode<T>> BinaryTreeNodes, int level, int maxLevel) {
        if (BinaryTreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(BinaryTreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newBinaryTreeNodes = new ArrayList<BinaryTreeNode<T>>();
        for (BinaryTreeNode<T> BinaryTreeNode : BinaryTreeNodes) {
            if (BinaryTreeNode != null) {
                System.out.print(BinaryTreeNode.data);
                newBinaryTreeNodes.add(BinaryTreeNode.left);
                newBinaryTreeNodes.add(BinaryTreeNode.right);
            } else {
                newBinaryTreeNodes.add(null);
                newBinaryTreeNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < BinaryTreeNodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (BinaryTreeNodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (BinaryTreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (BinaryTreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBinaryTreeNodeInternal(newBinaryTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTreeNode<T> BinaryTreeNode) {
        if (BinaryTreeNode == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(BinaryTreeNode.left), BTreePrinter.maxLevel(BinaryTreeNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
