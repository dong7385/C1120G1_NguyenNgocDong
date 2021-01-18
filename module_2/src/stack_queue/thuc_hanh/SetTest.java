package stack_queue.thuc_hanh;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("element 1");
        set.add("element 4");
        set.add("element 3");
        System.out.println(set);
//        for (String element : set) {
//                System.out.println(element);
//        }

        Set<String>set1=new HashSet<>();
        set1.add("element 4");
        set1.add("element 5");
        set.addAll(set1);
        System.out.println(set.contains("element 4"));
        System.out.println(set.isEmpty());
        System.out.println("------------------");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
