package arrray_in_java.baiTap;
import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        int n, i, j;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int array[] = new int[n];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Nhập số nguyên k: ");
        int k = scanner.nextInt();
        for (j = i = 0; i < n; i++) {
            if (array[i] != k) {
                array[j] = array[i];
                j++;
            }
        }
        System.out.println("Mảng còn lại sau khi xóa phần tử " + k + " là: ");
        for (i = 0; i < j; i++) {
            System.out.print(array[i] + "\t");
    }
}
}
