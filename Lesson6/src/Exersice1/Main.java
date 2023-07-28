package Exersice1;

public class Main {

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        FactorialTask[] factorialTasks = new FactorialTask[100];
        for(int i = 0; i < threads.length; i++) {
            factorialTasks[i] = new FactorialTask();
            threads[i] = new Thread(factorialTasks[i]);
            factorialTasks[i].setNumber(Integer.parseInt(threads[i].getName().replaceAll("Thread-", "")));
        }

        for(int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}