
class LinkedListCycles {
  public static void main(String[] args) {
    Node start = new Node(0);
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    start.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node2;

    System.out.println((containsCycle(start)) ? "YES" : "NO");
  }

  static Boolean containsCycle(Node start) {
    Node slow = start;
    Node fast = start.next;

    while (slow.next != null && fast.next != null & fast.next.next != null) {
      if (slow.value == fast.value) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }

  static class Node {
    public int value;
    public Node next;
    public Node(int value) {
      this.value = value;
    }
  }
}
