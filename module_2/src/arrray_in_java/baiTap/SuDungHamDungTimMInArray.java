package arrray_in_java.baiTap;

import java.util.Scanner;

public class SuDungHamDungTimMInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.println("Hãy nhập kích thước của mảng");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("size lớn hơn 20->vui lòng nhập lại");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Nhập phần tử:  " + i);
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println("thong tin phần tử trong mảng");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t ");
        }

        int result = findMin(array);
        System.out.println("min= " + array[result] + "  index= " + result);

    }

    public static int findMin(int[] array) {
        int min = array[0];
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;
            }
        }
        return index;
    }
}
