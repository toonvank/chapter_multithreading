package be.pxl.ja.DivisorCounter;
public class Main {
    public static void main(String[] args) {
        DivisorCounter divisorCounter = new DivisorCounter(1,100000);
        divisorCounter.start();
        //measure thread execution time
        long startTime = System.currentTimeMillis();
        try {
            divisorCounter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");
    }
}