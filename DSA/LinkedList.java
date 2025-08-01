import java.util.Collection;
import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList<E> implements Collection<E> {
  Node<E> head;
  Node<E> tail;
  int size = 0;

  LinkedList() {
  }

  public boolean add(E e) {
    Node<E> newNode = new Node<>(e);
    if (size == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
    return true;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  public boolean remove(Object e) {
    return true;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    if (index == 0) {
      // Removing the head
      head = head.next;
      if (size == 1) { // If it was the only element
        tail = null;
      }
    } else {
      Node<E> prev = head;
      for (int i = 0; i < index - 1; i++) {
        prev = prev.next;
      }
      prev.next = prev.next.next;
      if (index == size - 1) { // Removing the tail
        tail = prev;
      }
    }

    size--;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    LinkedList<String> a = new LinkedList<String>();
    a.add("asdf");
    a.add("asdfa");
    a.add("asdfb");
    a.remove(0);

    System.out.println(a.get(0));
    System.out.println(a.get(1));
  }

  @Override
  public boolean isEmpty() {
    return size == 0 ? false : true;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }
}

class Node<E> {
  E data;
  Node<E> next;

  Node(E data) {
    this.data = data;
  }
}
