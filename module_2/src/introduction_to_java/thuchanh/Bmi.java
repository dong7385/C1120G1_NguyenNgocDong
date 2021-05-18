package introduction_to_java.thuchanh;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight");
        float weight = sc.nextFloat();
        System.out.println("Enter height");
        float height = sc.nextFloat();

        double bmi = weight / Math.pow(height, 2);

        if (bmi < 18.5)
            System.out.println(bmi + "bmi underweight");
        else if (bmi < 25.0)
            System.out.println(bmi + "bmi Normal");
        else if (bmi < 30)
            System.out.println(bmi + "Overweight");
        else
            System.out.printf("obese");
    }
}
