package checkdigit;

import checkdigit.coders.ArrayBasedCoder;
import checkdigit.coders.AsciiBasedCoder;
import checkdigit.coders.Coder;
import checkdigit.coders.RadixBasedCoder;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CoderDiagnostics {

    private int iterations;
    private final List<Double> results = new ArrayList<>();
    private final List<Coder> coders = List.of(new AsciiBasedCoder(), new RadixBasedCoder(), ArrayBasedCoder.getInstance());
    private Coder coder;
    private final Random random = new Random();
    private final int testsToRun = 20;

    public CoderDiagnostics() {
    }

    public CoderDiagnostics setIterations(int iterations) {
        this.iterations = iterations;
        return this;
    }

    public CoderDiagnostics run() {
        for(Coder c : coders){
            this.coder=c;
            List<Duration> durations = new ArrayList<>();
            for (int i = 0; i < testsToRun; i++) {
                IntStream stream = random.ints(iterations, 0, 36);
                Instant start = Instant.now();
                stream.forEach(coder::intToCharISO7064);
                Instant stop = Instant.now();
                durations.add(Duration.between(start, stop));
            }
            results.add(durations.stream().mapToDouble(Duration::toMillis).average().orElse(0));
        }

        return this;
    }

    public DiagnosticResult getDiagnosticResult(){
        return new DiagnosticResult(results, coders);
    }

}
