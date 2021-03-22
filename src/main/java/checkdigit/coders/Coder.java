package checkdigit.coders;

public interface Coder {
    char intToCharISO7064(int value);
    int charToIntISO7064(char value);
    String getName();
}
