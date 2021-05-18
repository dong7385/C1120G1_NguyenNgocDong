package introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter so tien usd:");
        usd = scanner.nextDouble();
        double conversion = usd * 23000;
        System.out.println("so tien vnd " + conversion);
    }
}
