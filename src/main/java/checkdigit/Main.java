package checkdigit;

public class Main {

    public static void main(String[] args) {
        String[] inputs = new String[]{"01632532948375", "01631234567890", "01632532948375", "06219912345678"};
        CheckDigit checkDigit = new CheckDigit();
        for (String s : inputs) {
            System.out.println(checkDigit.getCheckDigit(s));
        }

        CoderDiagnostics coderDiagnostics = new CoderDiagnostics().setIterations(20000000).run();
        DiagnosticResult result = coderDiagnostics.getDiagnosticResult();
        result.printResults();
    }


}
