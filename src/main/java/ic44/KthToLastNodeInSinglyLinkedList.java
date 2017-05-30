
class KthToLastNodeInSinglyLinkedList {

  public static void main(String[] args) {
    Node head1 = new Node(1);
    Node head2 = new Node(2);
    Node head3 = new Node(3);
    Node head4 = new Node(4);
    Node head5 = new Node(5);

    head1.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;

    Node walker = head1;
    while (walker != null) {
      System.out.print(walker.value);
      walker = walker.next;
    }
    System.out.println("");
    System.out.println(getLastKthIndex(head1, 5));
  }

  static int getLastKthIndex(Node head, int k) {

    Node start = head;
    Node end = head;
    for (int i = 0; i < k; i++) {
      if (end == null) return -1;
      end = end.next;
    }

    while (end != null) {
      start = start.next;
      end = end.next;
    }

    return start.value;
  }

  static class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }
}
