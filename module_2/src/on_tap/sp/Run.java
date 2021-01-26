package bai16_io_text_file.sp;

import on_tap.Product;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        Product product = new Product("3", "khoa2",1000);
        FuncWriteAndRead.writeProduct(product);
        List<Product> list = FuncWriteAndRead.readProduct();
        for (Product product1: list) {
            System.out.println(product1);
        }
    }
}

