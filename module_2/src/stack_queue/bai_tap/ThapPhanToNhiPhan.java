package stack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class ThapPhanToNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so thap phan muon chuyen sang nhi phan");
        int num = scanner.nextInt();
        while (num != 0) {
            int soDu = num % 2;
            stack.push(soDu);
            num = num / 2;
       }
        while (!(stack.isEmpty() )) {
            System.out.print(stack.pop());
        }
        System.out.println();
//        System.out.println(stack);
    }
}
