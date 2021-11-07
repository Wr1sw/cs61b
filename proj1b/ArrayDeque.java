/**
 *  Deque implemented by array.
 * @author wr1sw
 **/
public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int capacity = 8;

    public ArrayDeque() {
        items = (Item[]) new Object[capacity];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }


    /**
     * Returns true if deque is empty, false otherwise.
     **/
    @Override
    public boolean isEmpty() {
        return Deque.super.isEmpty();
    }

    /** check whether the deque is full. **/
    private boolean isFull() {
        return size == capacity;
    }

    /**
     * Adds an item of type Item to the front of the deque.
     * @param item
     */
    @Override
    public void addFirst(Item item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
        size = size + 1;
    }

    /**
     * Adds an item of type Item to the back of the deque.
     * @param item
     */
    @Override
    public void addLast(Item item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + capacity) % capacity;
        size = size + 1;
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int k = (nextFirst + 1 + capacity) % capacity;
        Item res = items[k];


        nextFirst = (nextFirst + 1 + capacity) % capacity;
        size = size - 1;
        if (isLowUseageRate()) {
            resize((int) (capacity * 0.4));
        }
        return res;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        int k = (nextLast - 1 + capacity) % capacity;
        Item res = items[k];
//        items[k] = null;
        nextLast = (nextLast - 1 + capacity) % capacity;
        size = size - 1;
        if (isLowUseageRate()) {
            resize((int) (capacity * 0.4));
        }

        return res;
    }

    /** Returns the number of items in the deque. **/
    @Override
    public int size() {
        return size;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    @Override
    public Item get(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        int k = 0;
        if (nextFirst < nextLast) {
            k = (nextFirst + 1 + index + capacity) % capacity;
        } else {
            if (nextFirst + index + 1 < capacity) {
                k = (nextFirst + index + 1 + capacity) % capacity;
            } else {
                k = (nextFirst + 1 + index + capacity) % capacity;
            }
        }
        return items[k];
    }

    /**
     *
     * @param newSize
     */
    private void resize(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        int j = 0;
        if (nextLast == ((nextFirst + 1 + capacity) % capacity)) {
            for (int i = nextLast; i < capacity; i++, j++) {
                newArray[j] = items[i];
            }

            for (int i = 0; i < nextLast; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (nextFirst > nextLast) {
            for (int i = nextFirst + 1; i < capacity; i++, j++) {
                newArray[j] = items[i];
            }
            for (int i = 0; i < nextLast; i++, j++) {
                newArray[j] = items[i];
            }
        }
        nextFirst = newSize - 1;
        nextLast = size;
        items = newArray;
        capacity = newSize;
    }

    /** For arrays of length 16 or more,
     * your usage factor should always be at least 25%.  **/
    private boolean isLowUseageRate() {
        if (capacity >= 16 &&  ((double) size / capacity) < 0.25) {
            return true;
        }
        return false;
    }

    /** Prints the items in the deque from first to last,
     * separated by a space. **/
    @Override
    public void printDeque() {

        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                if (i == nextLast - 1) {
                    System.out.println(items[i]);
                } else {
                    System.out.print(items[i] + " ");
                }
            }
        } else {
            for (int i = nextFirst + 1; i < capacity; i++) {
                System.out.println(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                if (i == nextLast - 1) {
                    System.out.println(items[i]);
                } else {
                    System.out.print(items[i] + " ");
                }
            }
        }
    }

    /**
     * get capacity.
     * @return capacity size
     */
    private int getCapacity() {
        return capacity;
    }

}
