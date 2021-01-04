package introduction_to_java.thuchanh;

import java.util.Scanner;

public class check_leap_year {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a year: ");

        int year = scanner.nextInt();
        boolean isLeapYear = false;

        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("is a leap year", year);
        } else {
            System.out.printf("is NOT a leap year", year);
        }
    }
}
