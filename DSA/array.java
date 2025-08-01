import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.nio.ByteBuffer;

public class array {
  private final ByteBuffer buffer;
  private final int capacity;
  private final int slotSize;

  public array(int capacity, int slotSize) {
    this.capacity = capacity;
    this.slotSize = slotSize;
    buffer = ByteBuffer.allocate(capacity * slotSize);
  }

  public void put(int index, Object obj) throws IOException {
    if (index < 0 || index >= capacity)
      throw new IndexOutOfBoundsException();
    byte[] bytes = serialize(obj);
    if (bytes.length > slotSize) {
      throw new IllegalArgumentException("Serialized object too large for slot");
    }

    int pos = index * slotSize;
    buffer.position(pos);
    buffer.put(bytes);
    for (int i = bytes.length; i < slotSize; i++) {
      buffer.put((byte) 0);
    }
  }

  public Object get(int index) throws IOException, ClassNotFoundException {
    if (index < 0 || index >= capacity)
      throw new IndexOutOfBoundsException();

    int pos = index * slotSize;
    byte[] slotBytes = new byte[slotSize];
    buffer.position(pos);
    buffer.get(slotBytes);

    boolean empty = true;
    for (byte b : slotBytes) {
      if (b != 0) {
        empty = false;
        break;
      }
    }

    if (empty) {
      throw new IndexOutOfBoundsException("No object stored at index: " + index);
    }

    int len = slotSize;
    for (int i = slotSize - 1; i >= 0; i--) {
      if (slotBytes[i] != 0) {
        len = i + 1;
        break;
      }
    }

    if (len == 0)
      return null; // empty slot

    byte[] actualBytes = new byte[len];
    System.arraycopy(slotBytes, 0, actualBytes, 0, len);

    return deserialize(actualBytes);
  }

  private static byte[] serialize(Object obj) throws IOException {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(obj);
      oos.flush();
      return baos.toByteArray();
    }
  }

  private static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
    try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
      return ois.readObject();
    }
  }

  public static void main(final String[] args) throws Exception {
    array arr = new array(4, 2048);

    arr.put(0, "Hello");
    arr.put(1, 12345);
    arr.put(2, true);

    System.out.println(arr.get(0)); // Hello
    System.out.println(arr.get(1)); // 12345
    System.out.println(arr.get(2)); // true
    System.out.println(arr.get(3)); // null (empty)
  }
}
