public class LinkedListDeque<T> {

    private StuffNode sentinel;
    private int size;
    private StuffNode last;


    public class StuffNode {
        public T item;
        public StuffNode pre;
        public StuffNode next;

        public StuffNode(T i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            pre = p;
        }
    }

    public LinkedListDeque() {
        sentinel = new StuffNode((T) new Object(), null, null);
        last = sentinel;
        size = 0;
    }
    public LinkedListDeque(T item) {
        sentinel = new StuffNode((T) new Object(), null, null);
        sentinel.next = new StuffNode(item, null, sentinel);
        sentinel.pre = sentinel.next;
        last = sentinel.next;
        size = size + 1;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            sentinel.next = new StuffNode(item, sentinel.next, sentinel);
            sentinel.next.pre = sentinel.next;
            size = size + 1;
            last = sentinel.next;
        }else {
            sentinel.next = new StuffNode(item, sentinel.next, sentinel);
            size = size + 1;
        }
    }

    public void addLast(T item) {
        last.next = new StuffNode(item, null, sentinel);
        last = last.next;
        size = size + 1;
    }

    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
        }else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode temp = sentinel;
        while (temp.next.next != null) {
            System.out.println(temp.next.item+" ");
            temp = temp.next;
        }
        System.out.println(temp.next.item);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size = size -1;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = last.item;
        last = last.pre;
        last.next = null;
        last.pre = sentinel;
        size = size -1;
        return res;
    }

    public T get(int index) {
        if(size < index) {
            return null;
        }
        StuffNode temp = sentinel.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode((T) new Object(), null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public T getRecursive(int index) {
        if(size < index) {
            return null;
        }
        return getRecursive(sentinel, index);
    }

    private T getRecursive(LinkedListDeque<T>.StuffNode node, int i) {
        if (i == 0) {
            return node.item;
        }
        return getRecursive(node.next, i-1);
    }
}
