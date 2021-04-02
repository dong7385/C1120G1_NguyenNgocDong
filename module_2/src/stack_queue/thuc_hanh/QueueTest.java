package stack_queue.thuc_hanh;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("element 1");//thêm phần tử
        queue.offer("element 2");//thêm phần tử
        queue.offer("element 3");
        System.out.println(queue);
        System.out.println(queue.peek());//lấy ra phần tử ở đầu hàng
        System.out.println(queue.element());//lấy ra phần tử ở đầu hàng
        System.out.println(queue.poll());//lấy ra phần tử ở đầu hàng đợi và xóa nó
        System.out.println(queue.remove());//lấy ra phần tử ở đầu hàng đợi và xóa nó
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.contains("element 2"));//kiểm tra phần tử trong hàm đợi
        System.out.println(queue.size());
        for (String element:queue){
            System.out.println(element);
        }
    }
}
