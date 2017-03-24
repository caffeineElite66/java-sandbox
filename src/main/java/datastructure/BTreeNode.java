package datastructure;

public class BTreeNode<T> {
  public BTreeNode<T> left;
  public BTreeNode<T> right;
  public T data;

  public BTreeNode(T value) {
    left = right = null;
    this.data = value;
  }
}
