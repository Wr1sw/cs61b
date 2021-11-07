import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String test1 = "";
        String test2 = "p";
        String test3 = "pe";
        String test4 = "abba";
        String test5 = "abab";
        String test6 = "abA";
        assertTrue(palindrome.isPalindrome(test1));
        assertTrue(palindrome.isPalindrome(test2));
        assertFalse(palindrome.isPalindrome(test3));
        assertTrue(palindrome.isPalindrome(test4));
        assertFalse(palindrome.isPalindrome(test5));
        assertFalse(palindrome.isPalindrome(test6));
    }

    @Test
    public void testIsPalindromeByOne() {
        assertTrue(palindrome.isPalindrome("abwab", new OffByOne()));
        assertTrue(palindrome.isPalindrome("baba", new OffByOne()));
        assertTrue(palindrome.isPalindrome("benda", new OffByOne()));
        assertTrue(palindrome.isPalindrome("bigha", new OffByOne()));
        assertTrue(palindrome.isPalindrome("bija", new OffByOne()));
        assertTrue(palindrome.isPalindrome("chid", new OffByOne()));
    }

    @Test
    public void testIsPalindromeBySix() {
        assertTrue(palindrome.isPalindrome("ahong", new OffByN(6)));
        assertTrue(palindrome.isPalindrome("bargh", new OffByN(6)));
        assertTrue(palindrome.isPalindrome("bilch", new OffByN(6)));
        assertTrue(palindrome.isPalindrome("ganga", new OffByN(6)));
        assertTrue(palindrome.isPalindrome("goyim", new OffByN(6)));
        assertTrue(palindrome.isPalindrome("hoin", new OffByN(6)));
    }
}
