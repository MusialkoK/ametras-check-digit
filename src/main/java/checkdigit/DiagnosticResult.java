package checkdigit;

import checkdigit.coders.Coder;

import java.util.List;

public class DiagnosticResult {

    private final List<Double> results;
    private final List<Coder> coders;
    private int bestResultIndex;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public DiagnosticResult(List<Double> results, List<Coder> coders) {
        this.results = results;
        this.coders = coders;
        this.bestResultIndex = results.indexOf(results.stream().min(Double::compareTo).get());
    }

    public List<Double> getResults() {
        return results;
    }

    public List<Coder> getCoders() {
        return coders;
    }

    public void printResults() {
        printResultHeader();
        for (int i = 0; i < coders.size(); i++) {
            printResultLine(i);
        }
    }

    private void printResultHeader() {
        System.out.println("Coder                   duration [ms]");
    }

    private void printResultLine(int i) {
        boolean inYellow = i==bestResultIndex;

        String line = String.format("%s         %f",
                coders.get(i).getName(),
                results.get(i));

        if(inYellow){
            System.out.println(ANSI_YELLOW + line + ANSI_RESET);
        }else {
            System.out.println(line);
        }
    }
}
