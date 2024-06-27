package custom_implementation;

import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MIN_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(E element) {
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;

        if (size <= elements.length / 2 && elements.length / 2 >= MIN_CAPACITY) {
            resize(elements.length / 2);
        }
    }

    private void resize(int newCapacity) {
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return elements.length;
    }
}
