
class ReverseLinkedList {

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    LinkedListNode head2 = new LinkedListNode(2);
    LinkedListNode head3 = new LinkedListNode(3);
    LinkedListNode head4 = new LinkedListNode(4);
    LinkedListNode head5 = new LinkedListNode(5);
    head.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;

    LinkedListNode walker = head;
    while(walker != null) {
      System.out.print(walker.value);
      walker = walker.next;
    }

    LinkedListNode newHead = reverseLinkedList(head);

    walker = newHead;
    System.out.println("");
    while(walker != null) {
      System.out.print(walker.value);
      walker = walker.next;
    }

  }


  // 1 -> 2 -> 3 -> 4
  // 1    2 -> 3 -> 4
  // 1 <- 2    3 -> 4
  static LinkedListNode reverseLinkedList(LinkedListNode node) {
    LinkedListNode previous = null;
    LinkedListNode current = node;
    LinkedListNode next = node.next.next;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public static class LinkedListNode {
    public int value;
    public LinkedListNode next;
    public LinkedListNode(int value) {
      this.value = value;
    }
  }
}
