public class Palindrome {
    /**
     * Given a String, wordToDeque should return a Deque where
     * the characters appear in the same order as in the String.
     * @param word
     * @return wr1sw
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> characterDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            characterDeque.addLast(word.charAt(i));
        }
        return characterDeque;
    }

    /**
     * The isPalindrome method should return true if
     * the given word is a palindrome, and false otherwise.
     * @param word
     * @return wr1sw
     */
    public boolean isPalindrome(String word) {
        // Any word of length 1 or 0 is a palindrome.
        if (word.length() < 2) {
            return true;
        }
        Deque<Character> characterDeque = wordToDeque(word);
        while (characterDeque.size() > 1) {
            if (characterDeque.removeLast() != characterDeque.removeFirst()) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word,  CharacterComparator cc) {
        // Any word of length 1 or 0 is a palindrome.
        if (word.length() < 2) {
            return true;
        }
        Deque<Character> characterDeque = wordToDeque(word);
        while (characterDeque.size() > 1) {
            if (!cc.equalChars(characterDeque.removeFirst(), characterDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
