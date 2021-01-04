package introduction_to_java.thuchanh;

import java.util.Scanner;

public class day_month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month");
        int month = sc.nextInt();
        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = ("28 day or 29 day");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = ("31 day");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = (" 30 day");
                break;
            default:
                daysInMonth = ("Invalid input");
        }
        System.out.println(daysInMonth);
    }
}
