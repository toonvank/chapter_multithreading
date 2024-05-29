package be.pxl.ja.DivisorCounter;

public class DivisorCounterResult {
    private int foundNumber;
    private int numberOfDivisors;

    public DivisorCounterResult(int foundNumber, int numberOfDivisors) {
        this.foundNumber = foundNumber;
        this.numberOfDivisors = numberOfDivisors;
    }

    public int getFoundNumber() {
        return foundNumber;
    }

    public int getNumberOfDivisors() {
        return numberOfDivisors;
    }
}