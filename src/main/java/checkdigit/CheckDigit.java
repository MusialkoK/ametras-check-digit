package checkdigit;

import checkdigit.coders.ArrayBasedCoder;
import checkdigit.coders.Coder;

public class CheckDigit{

    private static final int MOD = 36;
    private final Coder coder = ArrayBasedCoder.getInstance();

    public char getCheckDigit(String code) {
        char[] codeArray = code.toCharArray();
        int intCd = MOD;
        for (char c : codeArray) {
            intCd = algorithmLoop(intCd, c);
        }
        intCd = MOD + 1 - intCd;
        if (intCd == MOD) intCd = 0;
        return coder.intToCharISO7064(intCd);
    }

    private int algorithmLoop(int intCd, char c) {
        int val = coder.charToIntISO7064(c);
        intCd += val;
        if (intCd > MOD) intCd -= MOD;
        intCd *= 2;
        if (intCd > MOD) intCd = intCd - MOD -1;
        return intCd;
    }
}
