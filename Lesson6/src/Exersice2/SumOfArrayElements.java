package Exersice2;

import java.util.Arrays;

public class SumOfArrayElements implements Runnable{
    private int result = 0;
    private int startPoint;
    private int endPoint;
    private static int[] intArray;

    public SumOfArrayElements(int[] intArray) {
        this.intArray = intArray;
    }

    public SumOfArrayElements() {
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray.clone();
    }

    public int getResult() {
        return result;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public int getSumOfArrayElements() {
        int sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        return sum;
    }

    public int getSumOfArrayElementsThr() {
        int sum = 0;
        for(int i = startPoint; i < endPoint; i++) {
            sum += intArray[i];
        }
        return sum;
    }

    @Override
    public void run() {
        result += getSumOfArrayElementsThr();
    }

    @Override
    public String toString() {
        return "SumOfArrayElements{" + "result=" + result + ", intArray=" + Arrays.toString(intArray) + '}';
    }
}
