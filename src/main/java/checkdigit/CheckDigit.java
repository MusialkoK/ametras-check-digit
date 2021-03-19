package checkdigit;

public class CheckDigit {

    private static final int MOD = 36;
    private static final int DIGIT_OFFSET = 48;
    private static final int LETTER_OFFSET = 65;
    private static final int LETTER_COUNT = 26;
    private static final int DIGIT_COUNT = 10;

    public static char getCheckDigit(String code) {
        char[] codeArray = code.toCharArray();
        int intCd = MOD;
        for (char c : codeArray) {
            intCd = algorithmLoop(intCd, c);
        }
        intCd = MOD + 1 - intCd;
        if (intCd == MOD) intCd = 0;
        return intToCharISO7064(intCd);
    }

    private static int algorithmLoop(int intCd, char c) {
        int val = charToIntISO7064(c);
        intCd += val;
        if (intCd > MOD) intCd -= MOD;
        intCd *= 2;
        if (intCd > MOD) intCd = intCd - MOD -1;
        return intCd;
    }

    private static char intToCharISO7064(int value) {
        if (value >= 0 && value < DIGIT_COUNT) return (char) (value + DIGIT_OFFSET);
        if (value >= DIGIT_COUNT && value < DIGIT_COUNT + LETTER_COUNT) return (char) (value + LETTER_OFFSET - DIGIT_COUNT);
        throw new IllegalArgumentException();
    }


    private static int charToIntISO7064(char value) {
        if ((int) value >= DIGIT_OFFSET && (int) value < DIGIT_OFFSET + DIGIT_COUNT) {
            return (int) value - DIGIT_OFFSET;
        }
        if ((int) value >= LETTER_OFFSET && (int) value < LETTER_OFFSET + LETTER_COUNT) {
            return (int) value - LETTER_OFFSET + DIGIT_COUNT;
        }
        throw new IllegalArgumentException();
    }
}
