package stack_queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static boolean checkPalindrome(String inputString) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
            queue.add(inputString.charAt(i));
        }
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập chuỗi đối xứng cần kiểm tra");
        String inputString = scanner.nextLine();
        if (!checkPalindrome(inputString)) {
            System.out.println("Đây là chuỗi không đối xứng ");
        } else
            System.out.println("Đây là chuỗi đối xứng ");
    }


//    public static boolean checkPalindrome(String inputString) {
//
//        Stack<String> stack = new Stack<>();
//        Queue<String> queue = new LinkedList<>();
//
//
//        for (int i = 0; i < inputString.length(); i++) {
//            stack.push();
//            queue.add(inputString);
//        }
//        for (int i = 0; i < inputString.length(); i++) {
//            if (!(stack.pop().equals(queue.remove()))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hãy nhập chuỗi đối xứng cần kiểm tra");
//        String inputString = scanner.nextLine();
//        if (checkPalindrome(inputString)) {
//            System.out.println("Đây là chuỗi không đối xứng ");
//        } else
//            System.out.println("Đây là chuỗi đối xứng ");
//    }
}
