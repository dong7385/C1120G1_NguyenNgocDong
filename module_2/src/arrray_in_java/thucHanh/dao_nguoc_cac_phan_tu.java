package arrray_in_java.thucHanh;

import java.util.Scanner;

public class dao_nguoc_cac_phan_tu {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
    }
}
