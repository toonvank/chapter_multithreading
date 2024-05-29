package be.pxl.ja.DivisorCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int min = 1;
        int max = 100000;
        int range = 10;
        int numThreads = (max - min) / range;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<DivisorCounterResult>> futures = new ArrayList<>();

        // Measure execution time
        long startTime = System.currentTimeMillis();

        // Create and submit tasks to the executor
        for (int i = 0; i < numThreads; i++) {
            int start = min + i * range;
            int end = Math.min(start + range, max);
            DivisorCounterTask task = new DivisorCounterTask(start, end);
            Future<DivisorCounterResult> future = executor.submit(task);
            futures.add(future);
        }

        // Wait for all tasks to complete and collect results
        int overallFoundNumber = 0;
        int overallNumberOfDivisors = 0;
        for (Future<DivisorCounterResult> future : futures) {
            try {
                DivisorCounterResult result = future.get();
                if (result.getNumberOfDivisors() > overallNumberOfDivisors) {
                    overallFoundNumber = result.getFoundNumber();
                    overallNumberOfDivisors = result.getNumberOfDivisors();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        executor.shutdown();

        System.out.println("Range ["+min+"-"+max+"]");
        System.out.println("Getal: " +overallFoundNumber);
        System.out.println("Aantal delers: " +overallNumberOfDivisors);
        System.out.println("Tijd: " +(endTime - startTime) / 1000.0 + " seconden");
    }
}
