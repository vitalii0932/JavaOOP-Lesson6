package Exersice2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //standard
        Random random = new Random();
        int[] intArray = new int[100000000];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(-10000, 10000);
        }
        SumOfArrayElements sumOfArrayElements = new SumOfArrayElements();
        sumOfArrayElements.setIntArray(intArray);

        long startTime = System.nanoTime();
        int sum;
        sum = sumOfArrayElements.getSumOfArrayElements();
        long endTime = System.nanoTime();
        System.out.println("Sum = " + sum);
        System.out.println("Execution time: " + (endTime - startTime));

        System.out.println("-------------------------");

        //with threads
        SumOfArrayElements sumOfArrayElements1 = new SumOfArrayElements();
        SumOfArrayElements sumOfArrayElements2 = new SumOfArrayElements();
        SumOfArrayElements sumOfArrayElements3 = new SumOfArrayElements();
        SumOfArrayElements sumOfArrayElements4 = new SumOfArrayElements();

        long newStartTime = System.nanoTime();
        int partLength = intArray.length / 4;
        int sumThr = 0;
        sumOfArrayElements1.setStartPoint(0);
        sumOfArrayElements1.setEndPoint(partLength);
        sumOfArrayElements2.setStartPoint(partLength);
        sumOfArrayElements2.setEndPoint(partLength * 2);
        sumOfArrayElements3.setStartPoint(partLength * 2);
        sumOfArrayElements3.setEndPoint(partLength * 3);
        sumOfArrayElements4.setStartPoint(partLength * 3);
        sumOfArrayElements4.setEndPoint(intArray.length);

        Thread thread1 = new Thread(sumOfArrayElements1);
        Thread thread2 = new Thread(sumOfArrayElements2);
        Thread thread3 = new Thread(sumOfArrayElements3);
        Thread thread4 = new Thread(sumOfArrayElements4);

        //start
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sumThr = sumOfArrayElements1.getResult() + sumOfArrayElements2.getResult() + sumOfArrayElements3.getResult() + sumOfArrayElements4.getResult();

        long newEndTime = System.nanoTime();
        System.out.println("Sum with thr = " + sumThr);
        System.out.println("Execution time with thr: " + (newEndTime - newStartTime));
    }
}
