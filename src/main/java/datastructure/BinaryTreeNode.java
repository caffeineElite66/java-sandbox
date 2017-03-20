package datastructure;

public class BinaryTreeNode<T> {
  public BinaryTreeNode<T> left;
  public BinaryTreeNode<T> right;
  public T data;

  public BinaryTreeNode(T value) {
    left = right = null;
    this.data = value;
  }
}
