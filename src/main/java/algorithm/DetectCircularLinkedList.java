package algorithm;


class DetectCircularLinkedList {

    public static void main (String[] args) {
        DetectCircularLinkedList dc = new DetectCircularLinkedList();
        Node head = dc.new Node(0);
        Node walker = head;
        Node pointer = head;

        for (int i = 1; i <= 10; i++) {
            Node node = dc.new Node(i);
            if (i == 4) pointer = node;
            walker.next = node;
            walker = node;
        }

        Node tail = dc.new Node(99);
        walker.next = tail;
        tail.next = pointer;
        System.out.println("Circular Node Value: " + detectCircular(head) + "\n");
        //printList(head);
    }

    private static int detectCircular(Node head) {
        Node pointerSlow = head;
        Node pointerFast = head;
        boolean match = false;
        while (pointerFast != null && pointerFast.next != null && match == false) {
            System.out.println(pointerSlow.value + " : " + pointerFast.value);
            pointerSlow = pointerSlow.next;
            pointerFast = pointerFast.next.next;
            if (pointerFast.value == pointerSlow.value) {
                System.out.println(pointerSlow.value + " : " + pointerFast.value);
                match = true;
                pointerSlow = head;
            }
        }

        if (!match) {
            return -1;
        }

        while (pointerSlow != pointerFast) {
            System.out.println(pointerSlow.value + " : " + pointerFast.value);
            pointerSlow = pointerSlow.next;
            pointerFast = pointerFast.next;
        }

        return pointerSlow.value;
    }

    private static void printList(Node node) {
        while (node.next != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("END");
    }

    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
}
