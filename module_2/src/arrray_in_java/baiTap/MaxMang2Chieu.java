package arrray_in_java.baiTap;

import java.util.Scanner;

public class MaxMang2Chieu {
    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của ma mảng: ");
        m = scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng: ");
        n = scanner.nextInt();
        int Array [][] = new int[m][n];
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Array[" + i + "]["+ j + "] = ");
                Array[i][j] = scanner.nextInt();
            }
        }
        int max = Array[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < Array[i][j]) {
                    max = Array[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng= " + max);
    }
}
