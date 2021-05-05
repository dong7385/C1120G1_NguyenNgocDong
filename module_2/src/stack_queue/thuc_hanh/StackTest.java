package stack_queue.thuc_hanh;

import netscape.security.UserTarget;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println("-------------------");
        System.out.println(stack.search(2));
        System.out.println("-------------------");
//        Iterator<Integer>iterator=stack.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        for(Integer integer :stack){
            System.out.println(integer);
        }
    }
}
