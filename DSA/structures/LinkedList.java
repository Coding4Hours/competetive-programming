import java.util.List;
import java.util.ListIterator;
import java.util.Collection;
import java.util.Random;
import java.util.Iterator;

public class LinkedList<E> implements List<E> {
	Node<E> head;
	Node<E> tail;
	int size = 0;

	private Node<E> cachedNode = null;
	private int cachedIndex = -1;

	LinkedList() {
	}

	private Node<E> move(Node<E> start, int fromIndex, int toIndex) {
		Node<E> current = start;
		if (fromIndex < toIndex) {
			for (int i = fromIndex; i < toIndex; i++) {
				current = current.next;
			}
		} else {
			for (int i = fromIndex; i > toIndex; i--) {
				current = current.prev;
			}
		}
		return current;
	}

	Node<E> getNode(final int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		// Use cached node if closer
		if (cachedNode != null && Math.abs(index - cachedIndex) < (size >> 1)) {
			cachedNode = move(cachedNode, cachedIndex, index);
			cachedIndex = index;
			return cachedNode;
		}

		// Traverse from head or tail
		Node<E> current;
		if (index < (size >> 1)) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = tail;
			for (int i = size - 1; i > index; i--) {
				current = current.prev;
			}
		}

		cachedNode = current;
		cachedIndex = index;
		return current;
	}

	private void linkNode(Node<E> newNode, Node<E> prev, Node<E> next) {
		newNode.prev = prev;
		newNode.next = next;
		if (prev != null) {
			prev.next = newNode;
		} else {
			head = newNode;
		}
		if (next != null) {
			next.prev = newNode;
		} else {
			tail = newNode;
		}

	}

	private void unlinkNode(Node<E> node) {
		Node<E> prevNode = node.prev;
		Node<E> nextNode = node.next;

		if (prevNode == null) {
			head = nextNode;
		} else {
			prevNode.next = nextNode;
		}

		if (nextNode == null) {
			tail = prevNode;
		} else {
			nextNode.prev = prevNode;
		}

		node.data = null;
		node.next = null;
		node.prev = null;

		size--;
		cachedNode = null;
		cachedIndex = -1;
	}

	public boolean add(final E e) {
		final Node<E> newNode = new Node<>(e);
		if (size == 0)
			head = tail = newNode;
		else
			linkNode(newNode, tail, null);

		size++;
		return true;
	}

	public void add(final int index, final E e) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		final Node<E> newNode = new Node<>(e);
		if (index == size) {
			add(e); // Reuse add for tail insertion
		} else {
			Node<E> current = getNode(index);
			linkNode(newNode, current.prev, current);
			size++;
		}
	}

	public E get(final int index) {
		return getNode(index).data;
	}

	public boolean remove(final Object e) {
		int index = indexOf(e);
		if (index == -1)
			return false;

		remove(index);
		return true;
	}

	public E remove(final int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		Node<E> thing = getNode(index);

		unlinkNode(thing);
		return thing.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(final Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public E set(int index, E e) {
		return e;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = head;
			private Node<E> lastReturned = null;

			public boolean hasNext() {
				return current != null;
			}

			public E next() {
				if (current == null) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.next;
				return lastReturned.data;
			}

			public void remove() {
				if (lastReturned == null) {
					throw new IllegalStateException();
				}
				unlinkNode(lastReturned);
				lastReturned = null;
			}
		};
	}

	@Override
	public ListIterator<E> listIterator(final int index) {
		return new ListIterator<E>() {
			private Node<E> current = head;
			private Node<E> lastReturned = null;

			public boolean hasNext() {
				return current != null;
			}

			@Override
			public boolean hasPrevious() {
				return current.prev != null;
			}

			@Override
			public void add(E e) {

			}

			@Override
			public void set(E e) {

			}

			@Override
			public int previousIndex() {
				return 1;
			}

			@Override
			public int nextIndex() {
				return 1;
			}

			public E next() {
				if (current == null) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.next;
				return lastReturned.data;
			}

			@Override
			public E previous() {
				if (current == null) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.prev;
				return lastReturned.data;
			}

			public void remove() {
				if (lastReturned == null) {
					throw new IllegalStateException();
				}
				unlinkNode(lastReturned);
				lastReturned = null;
			}
		};
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIterator<E>() {
			private Node<E> current = head;
			private Node<E> lastReturned = null;

			public boolean hasNext() {
				return current != null;
			}

			@Override
			public void add(E e) {

			}

			@Override
			public void set(E e) {

			}

			@Override
			public boolean hasPrevious() {
				return current.prev != null;
			}

			@Override
			public int nextIndex() {
				return 1;
			}

			@Override
			public int previousIndex() {
				return 1;
			}

			public E next() {
				if (current == null) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.next;
				return lastReturned.data;
			}

			@Override
			public E previous() {
				if (current == null) {
					throw new java.util.NoSuchElementException();
				}
				lastReturned = current;
				current = current.prev;
				return lastReturned.data;
			}

			public void remove() {
				if (lastReturned == null) {
					throw new IllegalStateException();
				}
				unlinkNode(lastReturned);
				lastReturned = null;
			}
		};
	}

	public Object[] toArray() {
		Object[] eray = new Object[size];
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			eray[i] = current.data;
			current = current.next;
		}
		return eray;
	}

	@Override
	public <T> T[] toArray(final T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(final Collection<?> c) {
		for (Object e : c) {
			if (indexOf(e) == -1)
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(final Collection<? extends E> c) {
		return addAll(size, c);
	}

	public boolean addAll(final int index, final Collection<? extends E> c) {
		if (c.isEmpty()) {
			return false;
		}

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		if (index == size) {
			for (E e : c) {
				add(e);
			}
		} else {
			Node<E> current = getNode(index);
			Node<E> prev = current.prev;
			for (E e : c) {
				Node<E> newNode = new Node<>(e);
				linkNode(newNode, prev, current);
				prev = newNode;
				size++;
			}
		}
		return true;
	}

	@Override
	public boolean removeAll(final Collection<?> c) {
		for (Object e : c)
			remove(e);
		return false;
	}

	@Override
	public boolean retainAll(final Collection<?> c) {
		boolean modified = false;
		Node<E> current = head;
		while (current != null) {
			Node<E> next = current.next;
			if (!c.contains(current.data)) {
				unlinkNode(current);
				modified = true;
			}
			current = next;
		}
		return modified;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
		cachedNode = null;
		cachedIndex = -1;
	}

	public int indexOf(final Object obj) {
		int i = 0;
		for (Node<E> current = head; current != null; current = current.next) {
			if ((obj == null && current.data == null) || (obj != null && obj.equals(current.data))) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public int lastIndexOf(final Object e) {
		int i = 0;
		for (Node<E> current = tail; current != null; current = current.prev) {
			if ((e == null && current.data == null) || (e != null && e.equals(current.data))) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public LinkedList<E> subList(final int start, final int end) {
		LinkedList<E> sublist = new LinkedList<E>();
		for (int i = start; i < end; i++) {
			sublist.add(get(i));
		}
		return sublist;
	}
}

class Node<E> {
	E data;
	Node<E> prev;
	Node<E> next;

	Node(final E data) {
		this.data = data;
	}
}
