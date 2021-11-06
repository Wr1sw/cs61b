/**
 * Deque (usually pronounced like “deck”) is an irregular
 * acronym of double-ended queue.
 * @author wr1sw
 * @param <T>
 */
public class LinkedListDeque<T> {

    private StuffNode sentinel;
    private int size;


    private class StuffNode {
        private T item;
        private StuffNode pre;
        private StuffNode next;

        public StuffNode(T i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            pre = p;
        }
    }

    public LinkedListDeque() {
        sentinel = new StuffNode((T) new Object(), null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }
//    public LinkedListDeque(T item) {
//        sentinel = new StuffNode((T) new Object(), null, null);
//        sentinel.next = new StuffNode(item, null, sentinel);
//        sentinel.pre = sentinel.next;
//        size = size + 1;
//    }

    public void addFirst(T item) {
        StuffNode newNode = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size = size + 1;
    }

    public void addLast(T item) {
        StuffNode newNode = new StuffNode(item, sentinel, sentinel.pre);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode temp = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println(temp.item);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size = size - 1;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size = size - 1;
        return res;
    }

    public T get(int index) {
        if (size < index) {
            return null;
        }
        StuffNode temp = sentinel.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new StuffNode((T) new Object(), null, null);
//        sentinel.pre = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }

    public T getRecursive(int index) {
        if (size <= index) {
            return null;
        }
        return getRecursive(sentinel, index);
    }

    private T getRecursive(LinkedListDeque<T>.StuffNode node, int i) {
        if (i == 0) {
            return node.next.item;
        }
        return getRecursive(node.next, i - 1);
    }
}
