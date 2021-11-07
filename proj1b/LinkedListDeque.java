/**
 * Deque (usually pronounced like “deck”) is an irregular
 * acronym of double-ended queue.
 * @author wr1sw
 * @param <Item>
 */
public class LinkedListDeque<Item> implements Deque<Item> {

    private StuffNode sentinel;
    private int size;


    private class StuffNode {
        private Item item;
        private StuffNode pre;
        private StuffNode next;

        StuffNode(Item i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            pre = p;
        }
    }

    public LinkedListDeque() {
        sentinel = new StuffNode((Item) new Object(), null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }
//    public LinkedListDeque(Item item) {
//        sentinel = new StuffNode((Item) new Object(), null, null);
//        sentinel.next = new StuffNode(item, null, sentinel);
//        sentinel.pre = sentinel.next;
//        size = size + 1;
//    }

    @Override
    public void addFirst(Item item) {
        StuffNode newNode = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size = size + 1;
    }

    @Override
    public void addLast(Item item) {
        StuffNode newNode = new StuffNode(item, sentinel, sentinel.pre);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size = size + 1;
    }

    @Override
    public boolean isEmpty() {
        return Deque.super.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode temp = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println(temp.item);
    }

    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size = size - 1;
        return res;
    }

    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Item res = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size = size - 1;
        return res;
    }

    @Override
    public Item get(int index) {
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
//        sentinel = new StuffNode((Item) new Object(), null, null);
//        sentinel.pre = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for (int i = 0; i < other.size(); i++) {
//            addLast((Item) other.get(i));
//        }
//    }

    public Item getRecursive(int index) {
        if (size <= index) {
            return null;
        }
        return getRecursive(sentinel, index);
    }

    private Item getRecursive(LinkedListDeque<Item>.StuffNode node, int i) {
        if (i == 0) {
            return node.next.item;
        }
        return getRecursive(node.next, i - 1);
    }
}
