package be.pxl.ja.DivisorCounter;

public class DivisorCounter extends Thread {
    private int minValue;
    private int maxValue;
    public int foundNumber = 0;
    public int numberOfDivisors = 0;

    public DivisorCounter(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        int found = 0;
        int divisors = 0;
        for (int i = minValue; i < maxValue; i++) {
            int tempDivisors = countDivisors(i);
            if (tempDivisors > divisors) {
                found = i;
                divisors = tempDivisors;
            }
            if (divisors > numberOfDivisors) {
                numberOfDivisors = divisors;
                foundNumber = found;
            }
        }
        System.out.println("Number with most divisors in range [" + minValue + ", " + maxValue + "]: " + foundNumber + " with " + numberOfDivisors + " divisors");
    }

    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}