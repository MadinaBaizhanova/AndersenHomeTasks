package custom_implementation;

import java.util.Arrays;

public class CustomHashSet<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Object[] table;
    private int size;
    private int threshold;

    public CustomHashSet() {
        table = new Object[DEFAULT_CAPACITY];
        size = 0;
        threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    public void put(E element) {
        if (contains(element)) {
            return;
        }
        if (size + 1 >= threshold) {
            resize(table.length * 2);
        }
        int index = getIndex(element);
        if (table[index] == null) {
            table[index] = element;
            size++;
        }
    }

    public boolean contains(E element) {
        int index = getIndex(element);
        return table[index] != null && table[index].equals(element);
    }

    public void delete(E element) {
        int index = getIndex(element);
        if (table[index] != null && table[index].equals(element)) {
            table[index] = null;
            size--;

            if (size < threshold * 0.75 && table.length > DEFAULT_CAPACITY) {
                resize(table.length / 2);
            }
        }
    }

    public void iterate() {
        for (Object obj : table) {
            if (obj != null) {
                @SuppressWarnings("unchecked")
                E element = (E) obj;
                System.out.println(element);
            }
        }
    }

    private int getIndex(E element) {
        int hash = element.hashCode();
        return Math.abs(hash) % table.length;
    }

    private void resize(int newCapacity) {
        table = Arrays.copyOf(table, newCapacity);
        threshold = (int) (newCapacity * DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return table.length;
    }
}
