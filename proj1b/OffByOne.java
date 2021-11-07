public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int temp = x - y;
        return temp == 1 || temp == -1;
    }
}
