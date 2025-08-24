import java.util.Vector;
import java.util.EmptyStackException;

public class stack<E> extends Vector<E> {
  int size = 0;
  Node<E> top;

  private static class Node<E> {
    E e;
    Node<E> prev;

    Node(E e) {
      this.e = e;
    }
  }

  stack() {
  }

  boolean empty() {
    return size == 0;
  }

  E peek() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return top.e;
  }

  E pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    Node<E> oldtop = top;
    top = top.prev;
    return oldtop.e;
  }

  E push(E item) {
    Node<E> oldtop = top;
    top = new Node<E>(item);
    top.prev = oldtop;
    size++;
    return item;
  }

  int search(Object o) {
    Node<E> current = top;
    int index = 1;
    while (current != null) {
      if (o.equals(current.e))
        return index;

      current = current.prev;
      index++;
    }
    return -1;
  }

  public static void main(String[] args) {
    stack a = new stack();
    a.push("c");
    a.push("d");
    a.push("a");
    a.push("b");
    System.out.println(a.search("a"));
  }
}
