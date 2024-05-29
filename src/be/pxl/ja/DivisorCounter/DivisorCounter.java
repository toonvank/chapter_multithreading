package be.pxl.ja.DivisorCounter;

public class DivisorCounter extends Thread {
    private int minValue;
    private int maxValue;
    public int foundNumber = 0;
    public int numberOfDivisors = 0;

    public DivisorCounter(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run(){
        int found = 0;
        int divisors = 0;
        for (int i = minValue; i<maxValue; i++){
            int tempDivisors = 0;
            for(int k = 1; k<=i; k++) {
                if(i % k == 0) {
                    tempDivisors++;
                }
            }
            if(tempDivisors > divisors) {
                found = i;
                divisors = tempDivisors;
            }
            if (divisors > numberOfDivisors){
                numberOfDivisors = divisors;
                foundNumber = found;
            }
        }
        System.out.println("Number with most divisors: " + foundNumber + " with " + numberOfDivisors + " divisors");
    }
}