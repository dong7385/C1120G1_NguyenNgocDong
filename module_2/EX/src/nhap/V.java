package nhap;

import java.util.ArrayList;
import java.util.List;

public class V {
    public static void main(String[] args) {
//        List list = new ArrayList<>();
//        list.add("hello");
//        String s = (String) list.get(0);// ép kiểu
//        System.out.println(s);
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("4");
        String s = list.get(0);
        String j = list.get(1);
        System.out.println(s);
        System.out.println(j);
    }
}
