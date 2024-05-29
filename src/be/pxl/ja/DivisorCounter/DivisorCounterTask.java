package be.pxl.ja.DivisorCounter;

import java.util.concurrent.Callable;

public class DivisorCounterTask implements Callable<DivisorCounterResult> {
    private int minValue;
    private int maxValue;

    public DivisorCounterTask(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public DivisorCounterResult call() {
        int found = 0;
        int divisors = 0;
        for (int i = minValue; i < maxValue; i++) {
            int tempDivisors = DivisorCounter.countDivisors(i);
            if (tempDivisors > divisors) {
                found = i;
                divisors = tempDivisors;
            }
        }
        return new DivisorCounterResult(found, divisors);
    }
}