package introduction_to_java.baitap;

import java.util.Scanner;

public class show_greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

    }


}
