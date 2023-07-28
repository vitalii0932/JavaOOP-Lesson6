package Exersice1;

import java.math.BigInteger;

public class FactorialTask implements Runnable {
    private int number;
    private BigInteger result;

    public FactorialTask(int number) {
        this.number = number;
    }

    public FactorialTask() {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigInteger getResult() {
        return result;
    }

    public BigInteger factorialCalculate(int n) {
        BigInteger fact = BigInteger.ONE;
        for(int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public void run() {
        result = BigInteger.ZERO;
        Thread thr = Thread.currentThread();
        BigInteger fact = factorialCalculate(number);
        System.out.println(thr.getName() + " != " + fact);
        result = result.add(fact);
    }
}
