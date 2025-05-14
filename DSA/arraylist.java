import java.io.Serializable;
import java.util.RandomAccess;

public class arraylist<E> implements RandomAccess, Cloneable, Serializable {
  private Object[] elementData;
  private int size;
  private static final int DEFAULT_CAPACITY = 10;

  public arraylist() {
    elementData = new Object[0];
    size = 0;
  }

  public arraylist(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Initial capacity cannot be negative");
    }
    elementData = new Object[initialCapacity];
    size = 0;
  }
}
