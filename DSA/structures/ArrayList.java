import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements List<E> {

  private Object[] elementData;
  private int size;

  public MyArrayList() {
    /* ... */ }

  public MyArrayList(int initialCapacity) {
    /* ... */ }

  public MyArrayList(Collection<? extends E> c) {
    /* ... */ }

  @Override
  public boolean add(E e) {
    return true;
  }

  @Override
  public void add(int index, E element) {
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    return false;
  }

  @Override
  public void clear() {
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean equals(Object o) {
    return false;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int indexOf(Object o) {
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public int lastIndexOf(Object o) {
    return -1;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public void replaceAll(UnaryOperator<E> operator) {
  }

  @Override
  public boolean retainAll(Collection<?> c) {
  }

  @Override
  public E set(int index, E element) {
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void sort(Comparator<? super E> c) {
  }

  @Override
  public Spliterator<E> spliterator() {
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return (T[]) new Object[0];
  }
}
