package exception.bai_tap;

import java.io.NotActiveException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
int a=0;
        try {
             a= nhap();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("đã nho hon -1"+a);
        }
        System.out.println("kết thúc:");

    }
    public static int nhap()  {
        Scanner scanner=new Scanner(System.in);
        System.out.println("hãy nhập canh thu 1 tam giác:");
        int a=scanner.nextInt();
        System.out.println("cạnh a"+a);
        return a;
    }
}
