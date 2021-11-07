public class OffByN implements CharacterComparator {
    private int diff;

    public OffByN(int n) {
        diff = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int temp = x - y;
        return temp == diff || temp == -diff;
    }
}
