//package map.bai_tap;
//
//import java.sql.SQLOutput;
//import java.util.*;
//
//public class ProductManager {
//    static Scanner input = new Scanner(System.in);
//    static List<Product> list = new ArrayList<Product>();
//
//    public static void main(String[] args) {
//        showMenu();
//        int choose;
//        do {
//            choose = Integer.parseInt(input.nextLine());
//            switch (choose) {
//                case 1:
//                    input(list);
//                    break;
//                case 2:
//                    edit(list);
//                    break;
//                case 3:
//                    deleted(list);
//                    break;
//                case 4:
//                    display(list);
//                    break;
//                case 5:
//                    search(list);
//                    break;
//                case 6:
//                    int choose1;
//                    do {
//                        System.out.println("chọn 1 nếu muốn sắp xếp theo thứ tự tăng dần ");
//                        System.out.println("chọn 2 nếu muốn sắp xếp theo thứ tự giảm dần ");
//                        choose1 = Integer.parseInt(input.nextLine());
//                    } while (choose1 != 1 && choose1 != 2);
//                    switch (choose1) {
//                        case 1:
//                            sort(list);
//                            break;
//                        case 2:
//                            sort(list);
//                            Collections.reverse(list);
//                    }
//
//                case 7:
//                    System.out.println("Thoát ");
//                    break;
//                default:
//                    System.out.println("Input faile ");
//            }
//        } while (choose != 7);
//    }
//
//    private static void deleted() {
//    }
//
//    static void input(List<Product> list) {
//        System.out.print("Nhập ID:");
//        int id = Integer.parseInt(input.nextLine());
//        System.out.print("Nhập Name:");
//        String name = input.nextLine();
//        System.out.print("Nhập giá :");
//        int price = Integer.parseInt(input.nextLine());
//        Product product = new Product(id, name, price);
//        list.add(product);
//    }
//
//
//    static void edit(List<Product> list) {
//        int id = Integer.parseInt(input.nextLine());
//        for(Product p:list){
//            if(id==list.get(list).getId()){
//                p.setName(p.getName());
//                p.setPrice(p.getId());
//
//            }
//        }
//    }
//
//
//    static void deleted(List<Product> list) {
//        int id = Integer.parseInt(input.nextLine());
//        int temp = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                temp = i;
//            }
//        }
//        list.remove(temp);
//    }
//
//    static void display(List<Product> list) {
//        for (Product product : list) {
//            System.out.println(product);
//        }
//
//    }
//
//    static void search(List<Product> list) {
//        System.out.println("Nhap ten ");
//        String name = input.nextLine();
//
//        for (Product product : list) {
//            if (product.getName().equals(name)) {
//                System.out.println(product);
//            }
//        }
//    }
//
//    static void sort(List<Product> list) {
//Collections.sort(list, new Comparator<Product>() {
//    @Override
//    public int compare(Product o1, Product o2) {
//       return o1.getPrice()-o2.getPrice();
//    }
//});
//    }
//
//    public static void showMenu() {
//        System.out.println("Hãy chọn thông tin sản phản ");
//        System.out.println("1. Thêm thông tin sản phẩm.");
//        System.out.println("2. Sửa thông tin sản phẩm theo id.");
//        System.out.println("3. Xóa sản phẩm theo id ");
//        System.out.println("4. Hiển thị danh sách sản phẩm ");
//        System.out.println("5. Tìm kiểm sản phẩm theo tên ");
//        System.out.println("6. Sắp xếp sản phẩm tăng dần giảm dần theo giá ");
//        System.out.println("7. Exit ");
//    }
//}