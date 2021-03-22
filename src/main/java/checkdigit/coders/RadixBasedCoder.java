package checkdigit.coders;


public class RadixBasedCoder implements Coder {
    private final String name = "Radix-based Coder";


    @Override
    public char intToCharISO7064(int value) {
        return Character.toUpperCase(Character.forDigit(value,36));
    }

    @Override
    public int charToIntISO7064(char value) {
        return Integer.valueOf(String.valueOf(value),36);
    }

    @Override
    public String getName() {
        return name;
    }
}
