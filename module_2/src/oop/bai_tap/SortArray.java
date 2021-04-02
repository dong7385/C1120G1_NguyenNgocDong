package oop.bai_tap;

public class SortArray {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(10000 * Math.random());
        }
        stopWatch.startTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[j] = temp;
                }
            }
        }
        stopWatch.endTime();
        System.out.println("Time" + stopWatch.getElapsedTime());
    }
}