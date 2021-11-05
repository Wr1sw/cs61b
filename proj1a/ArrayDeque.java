import java.util.Objects;

public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Objects[capacity];
        nextFirst = 0;
        nextLast = 0;
        size = 0;
    }

//    public void resize(int newSize) {
//        T[] temp = (T[]) new Objects[newSize];
//        System.arraycopy(items, 0, temp, 0, newSize);
//        items = temp;
//    }

    public boolean isEmpty() {
        return nextFirst == nextLast;
    }
    public void addFirst (T item) {
//        if ()
        items[nextFirst] = item;
        nextFirst = (nextFirst-1+capacity)%capacity;
    }

    public void addLast (T item) {
//        if(nextLast+1 > capacity) {
//            resize((int) (capacity * 1.2));
//        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + capacity) % capacity;
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        int k = (nextFirst+1+capacity)%capacity;
        T res = items[k];
        items[k] = null;

        nextFirst = (nextFirst+1+capacity)%capacity;
//       if usage-rate < 25%
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int k = (nextLast-1+capacity)%capacity;
        T res = items[k];
        items[k] = null;
        nextLast = (nextLast-1+capacity)%capacity;
        //       if usage-rate < 25%
        return res;
    }

}
