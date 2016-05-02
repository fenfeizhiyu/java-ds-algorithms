package anthonynsimon.datastructures;

import java.util.Arrays;

public class DynamicArray<E> {
  
  protected int size;
  protected E[] data;
  
  private int growthFactor = 2;
  
  public DynamicArray(int initialCapacity) {
    this.size = 0;
    E[] array = (E[]) new Object[initialCapacity];
    this.data = array;
  }
  
  public void add(E item) {
    ensureCapacity();
    this.data[size()] = item;
    this.size++;
  }
  
  public E get(int index) throws IndexOutOfBoundsException {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity());
    }
    return this.data[index];
  }
  
  public void set(int index, E item) throws IndexOutOfBoundsException {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + capacity());
    }
    this.data[index] = item;
  }
  
  public int capacity() {
    return this.data.length;
  }
  
  public int size() {
    return this.size;
  }
  
  private boolean isOutOfBounds(int index) {
    return index < 0 || index > capacity() - 1;
  }
  
  private void ensureCapacity() {
    if (capacity() < size() + 1) {
      int newCapacity = capacity() * this.growthFactor;
      this.data = Arrays.copyOf(this.data, newCapacity);
    }
  }
}