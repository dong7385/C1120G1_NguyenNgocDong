package demo_product_manager.controllers;

import demo_product_manager.model.Product;
import demo_product_manager.services.product.ProductManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        int choose;
        showMenu();
        do {
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
createProduct();
                    break;
                case 2:
productManager.edit();
                    break;
                case 3:
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        } while (choose != 7);
    }

    public static void showMenu() {
        System.out.println("Hãy chọn thông tin sản phản ");
        System.out.println("1. Thêm thông tin sản phẩm.");
        System.out.println("2. Sửa thông tin sản phẩm theo id.");
        System.out.println("3. Xóa sản phẩm theo id ");
        System.out.println("4. Hiển thị danh sách sản phẩm ");
        System.out.println("5. Tìm kiểm sản phẩm theo tên ");
        System.out.println("6. Sắp xếp sản phẩm tăng dần giảm dần theo giá ");
        System.out.println("7. Exit ");
    }

    private static void createProduct() {
        System.out.println("Nhap id san pham");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap ten san pham");
        String name = scanner.nextLine();
        System.out.println("Nhap gia san pham");
        int price = Integer.parseInt(scanner.nextLine());
        productManager.save(new Product(id, name, price));
    }

    private static void displayProduct() {
        List<Product> list = productManager.findAll();
        for (Product product : list) {
            System.out.println(product);
        }
    }
}