package checkdigit.coders;

public class AsciiBasedCoder implements Coder{

    private static final int DIGIT_OFFSET = 48;
    private static final int LETTER_OFFSET = 65;
    private static final int LETTER_COUNT = 26;
    private static final int DIGIT_COUNT = 10;

    private final String name = "ASCII-based Coder";

    @Override
    public String getName() {
        return name;
    }

    public char intToCharISO7064(int value) {
        if (value >= 0 && value < DIGIT_COUNT) return (char) (value + DIGIT_OFFSET);
        if (value >= DIGIT_COUNT && value < DIGIT_COUNT + LETTER_COUNT) return (char) (value + LETTER_OFFSET - DIGIT_COUNT);
        throw new IllegalArgumentException();
    }

    public int charToIntISO7064(char value) {
        if ((int) value >= DIGIT_OFFSET && (int) value < DIGIT_OFFSET + DIGIT_COUNT) {
            return (int) value - DIGIT_OFFSET;
        }
        if ((int) value >= LETTER_OFFSET && (int) value < LETTER_OFFSET + LETTER_COUNT) {
            return (int) value - LETTER_OFFSET + DIGIT_COUNT;
        }
        throw new IllegalArgumentException();
    }
}
