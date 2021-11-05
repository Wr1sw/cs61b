///**
// *  Deque implemented by array.
// **/
//public class ArrayDeque<T> {
//    private T[] items;
//    private int nextFirst;
//    private int nextLast;
//    private int size;
//    private int capacity = 8;
//
//    public ArrayDeque() {
//        items = (T[]) new Object[capacity];
//        nextFirst = 4;
//        nextLast = 5;
//        size = 0;
//    }
//
//
//    /** Returns true if deque is empty, false otherwise. **/
//    public boolean isEmpty() {
////        ((nextFirst + 1 + capacity) % capacity) == nextLast         why am i wrong to do this?
//        return size == 0;
//    }
//
//
//    public boolean isFull() {
//        return size == capacity;
//    }
//
//    /**  Adds an item of type T to the front of the deque. **/
//    public void addFirst(T item) {
//        if (isFull()) {
//            resize((int) (capacity * 1.5));
//        }
//        items[nextFirst] = item;
//        nextFirst = (nextFirst - 1 + capacity) % capacity;
//        size = size + 1;
//    }
//
//    /** Adds an item of type T to the back of the deque. **/
//    public void addLast(T item) {
//        if (isFull()) {
//            resize((int) (capacity * 1.5));
//        }
//        items[nextLast] = item;
//        nextLast = (nextLast + 1 + capacity) % capacity;
//        size = size + 1;
//    }
//
//    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
//    public T removeFirst() {
//        if (isEmpty()) {
//            return null;
//        }
//        int k = (nextFirst + capacity) % capacity;
//        T res = items[k];
//
//
//        nextFirst = (nextFirst + 1 + capacity) % capacity;
//        size = size - 1;
//        if (isLowUseageRate()) {
//            resize((int) (capacity * 0.4));
//        }
//        return res;
//    }
//
//    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
//    public T removeLast() {
//        if (isEmpty()) {
//            return null;
//        }
//        int k = (nextLast - 1 + capacity) % capacity;
//        T res = items[k];
//
//        nextLast = (nextLast - 1 + capacity) % capacity;
//        size = size - 1;
//        if (isLowUseageRate()) {
//            resize((int) (capacity * 0.4));
//        }
//
//        return res;
//    }
//
//    /** Returns the number of items in the deque. **/
//    public int size() {
//        return size;
//    }
//
//    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
//    public T get(int index) {
//        if (index < 0 || index >= size || isEmpty()) {
//            return null;
//        }
//        int k = 0;
//        if (nextFirst < nextLast) {
//            k = nextFirst + 1 + index;
//        }else {
//            if (nextFirst + index + 1 < capacity) {
//                k = (nextFirst + index + 1);
//            }else {
//                k = (nextFirst + 1 + index + capacity) % capacity;
//            }
//        }
//        return items[k];
//    }
//
//    public void resize(int newSize) {
//        T[] newArray = (T[]) new Object[newSize];
//
//        //1
//        if (nextFirst < nextLast) {
//            for (int i = nextFirst+1, j = 0; i <= nextLast-1;i++, j++) {
//                newArray[j] = items[i];
//            }
//        }
//        if (nextFirst > nextLast) {
//            int j = 1;
//            for(int i = nextFirst+1;i < capacity-nextFirst;i++, j++) {
//                newArray[j] = items[i];
//            }
//            for(int i = 0; i < nextLast; i++, j++) {
//                newArray[j] = items[i];
//            }
//        }
//        nextFirst = 0;
//        nextLast = size + 1;
//        items = newArray;
//        capacity = newSize;
//    }
//
//    /** For arrays of length 16 or more, your usage factor should always be at least 25% **/
//    public boolean isLowUseageRate () {
//        if (capacity >= 16 &&  ((double)size / capacity) < 0.25) {
//            return true;
//        }
//        return false;
//    }
//
//    /** Prints the items in the deque from first to last, separated by a space. **/
//    public void printDeque() {
//        if (nextFirst < nextLast) {
//            for (int i = nextFirst + 1; i < nextLast;i++) {
//                if (i == nextLast - 1) {
//                    System.out.println(items[i]);
//                }else {
//                    System.out.print(items[i] + " ");
//                }
//            }
//        }
//        else {
//            for (int i = nextFirst + 1; i < capacity; i++) {
//                System.out.println(items[i] + " ");
//            }
//            for (int i = 0;i < nextLast; i++) {
//                if (i == nextLast - 1) {
//                    System.out.println(items[i]);
//                }else {
//                    System.out.print(items[i] + " ");
//                }
//            }
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
/**
 * Deque implemented by array.
 */
public class ArrayDeque<T> {

    private T[] items;
    private int left;
    private int right;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        left = right = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        left = (left - 1 + capacity) % capacity;
        items[left] = item;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        items[right] = item;
        right = (right + 1 + capacity) % capacity;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return left == right;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return (right - left + capacity) % capacity;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        if (left < right) {
            for (int i = left; i < right; i++) {
                if (i == right - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.print(items[i] + " ");
            }
        } else if (left > right) {
            for (int i = left; i < capacity; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < right; i++) {
                if (i == right - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.print(items[i] + " ");
            }
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = items[left];
        left = (left + 1) % capacity;
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return res;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        right = (right - 1 + capacity) % capacity;
        T res = items[right];
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return res;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (index < 0 || index >= size() || isEmpty()) {
            return null;
        }
        if (left < right) {
            return items[index + left];
        } else if (left > right) {
            if (index + left < capacity) {
                return items[index + left];
            } else {
                return items[(index + left) % capacity];
            }
        }
        return null;
    }

    private boolean isFull() {
        return size() == capacity - 1;
    }

    private boolean isLowUsageRate() {
        return capacity >= 16 && size() / (double) capacity < 0.25;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];

        int size = size();
        if (left < right) {
            for (int i = left, j = 0; i < right && j < size; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (left > right) {
            int j = 0;
            for (int i = left; j < capacity - left; i++, j++) {
                newArray[j] = items[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newArray[j] = items[i];
            }
        }
        left = 0;
        right = size;
        items = newArray;
        capacity = newSize;
    }

}