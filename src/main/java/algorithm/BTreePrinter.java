package algorithm;

import datastructure.BTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(BTreeNode<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printBinaryTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBinaryTreeNodeInternal(List<BTreeNode<T>> bTreeNodes, int level, int maxLevel) {
        if (bTreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(bTreeNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BTreeNode<T>> newBTreeNodes = new ArrayList<BTreeNode<T>>();
        for (BTreeNode<T> BTreeNode : bTreeNodes) {
            if (BTreeNode != null) {
                System.out.print(BTreeNode.data);
                newBTreeNodes.add(BTreeNode.left);
                newBTreeNodes.add(BTreeNode.right);
            } else {
                newBTreeNodes.add(null);
                newBTreeNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < bTreeNodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (bTreeNodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (bTreeNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (bTreeNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBinaryTreeNodeInternal(newBTreeNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BTreeNode<T> BTreeNode) {
        if (BTreeNode == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(BTreeNode.left), BTreePrinter.maxLevel(BTreeNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
