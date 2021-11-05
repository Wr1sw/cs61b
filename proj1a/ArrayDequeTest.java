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
        addIsEmptySizeTest();
        addRemoveTest();
        addGetTest();
//        LinkedListDeque<String> s1 = new LinkedListDeque<>();
//        s1.addLast("first");
//        s1.addLast("second");
//        s1.addLast("third");
//        s1.addLast("forth");
//        s1.printDeque();
//        System.out.println("s1.getRecursive(0) = " + s1.getRecursive(0));
//        System.out.println("s1.getRecursive(0) = " + s1.getRecursive(1));
//        System.out.println("s1.getRecursive(0) = " + s1.getRecursive(2));
//        System.out.println("s1.getRecursive(0) = " + s1.getRecursive(3));
//        System.out.println("s1.getRecursive(0) = " + s1.getRecursive(4));
//        s1.printDeque();


    }
} 