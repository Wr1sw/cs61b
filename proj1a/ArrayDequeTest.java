import java.util.ArrayList;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<String> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    public static void addGetTest() {
        System.out.println("Running add/get test.");
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        for (int i = 0; i < 5; i++) {
            lld1.addLast(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("lld1.get(i) = " + lld1.get(i));
        }

    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
//        addIsEmptySizeTest();
//        addRemoveTest();
//        addGetTest();
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        System.out.println("ArrayDeque.get(0) = " + ArrayDeque.get(0)); // ==> 0
        ArrayDeque.addFirst(2);
        ArrayDeque.addLast(3);
        ArrayDeque.addFirst(4);
        System.out.println("ArrayDeque.removeLast() = " + ArrayDeque.removeLast()); //    ==> 3
        ArrayDeque.addLast(6);
        ArrayDeque.addFirst(7);
        System.out.println("ArrayDeque.removeFirst() = " + ArrayDeque.removeFirst()); //  ==> 7
        System.out.println("ArrayDeque.get(2) = " + ArrayDeque.get(2)); //   ==> 0
        ArrayDeque.addFirst(10);
        System.out.println("ArrayDeque.removeFirst() = " + ArrayDeque.removeFirst()); //   ==> 10
        ArrayDeque.addFirst(12);
        ArrayDeque.addFirst(13);
        ArrayDeque.addFirst(14);
        ArrayDeque.addLast(15);
        ArrayDeque.addLast(16);
        ArrayDeque.addLast(17);
        ArrayDeque.addLast(18);
        System.out.println("ArrayDeque.removeLast() = " + ArrayDeque.removeLast());   // ==> 18
        System.out.println("ArrayDeque.removeLast() = " + ArrayDeque.removeLast()); //  ==> 17
        ArrayDeque.addLast(21);
        System.out.println("ArrayDeque.removeLast() = " + ArrayDeque.removeLast()); //  ==> 21
        System.out.println("ArrayDeque.get(3) = " + ArrayDeque.get(3));   //   ==> null

    }
} 