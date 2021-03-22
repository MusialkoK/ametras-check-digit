package checkdigit.coders;

import java.util.Arrays;

public class ArrayBasedCoder implements Coder{
    private final int TABLE_ENTRIES = 36;
    private static final int DIGIT_COUNT = 10;
    private static final int LETTER_OFFSET = 65;
    private final char[] table = new char[TABLE_ENTRIES];
    private static ArrayBasedCoder instance;
    private final String name = "Array-based Coder";

    private ArrayBasedCoder() {
        for (int i = 0; i < DIGIT_COUNT; i++) table[i] = (char) (i + '0');
        for (int i = DIGIT_COUNT; i < TABLE_ENTRIES; i++) table[i] = (char) (i + LETTER_OFFSET - DIGIT_COUNT);
    }

    public static ArrayBasedCoder getInstance() {
        if (instance == null) {
            instance = new ArrayBasedCoder();
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char intToCharISO7064(int value) {
        return table[value];
    }

    @Override
    public int charToIntISO7064(char value) {
        return Arrays.binarySearch(table,value);
    }
}

