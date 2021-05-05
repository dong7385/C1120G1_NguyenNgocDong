package sap_xep.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SapXepChen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
        System.out.println("Sau khi sap xep");
        insertionSort(list);
    }

    public static void insertionSort(int[] list) {
        int i;
        int j;
        int temp;

        for(i=1; i<list.length; i++){
            j=i-1;
            temp=list[i];
            while (j>=0&&temp < list[j] ){
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=temp;
        }
        for (int k = 0; k <list.length; k++) {
            System.out.println(list[k]);
        }
    }
}
