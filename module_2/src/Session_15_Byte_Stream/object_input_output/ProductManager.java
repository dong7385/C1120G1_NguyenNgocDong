package Session_15_Byte_Stream.object_input_output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private static List<Product> productList = new ArrayList<>();

    private static final String PATH_FILE = "src/Session_15_Byte_Stream/object_input_output/data.dat";

    public static void main(String[] args) throws Exception {
        addProduct("Iphone 12","USA","1000USD","new like");
        addProduct("SamSung Note 20","Korea","1200USD","new");
        showProducts();
    }

    private static void writeToDatabase() throws Exception {
        File file = new File(PATH_FILE);
        FileOutputStream fileOutput = new FileOutputStream(file);
        try {
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            for(Product product : productList){
                output.writeObject(product.toString());
            }
            output.flush();
            output.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private static void readFromDatabase() throws Exception {
        FileInputStream fileInput = new FileInputStream(PATH_FILE);
        try {
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Product product;
            while((product = (Product) input.readObject()) != null){
                productList.add(product);
            }
            input.close();
        } catch (EOFException e){
            System.out.println("Load success");
        } catch (Exception e){
//            System.out.println(e);
        }
    }

    private static void addProduct(String name, String manufacturer, String price, String description) throws Exception {
        readFromDatabase();
        productList.add(new Product(name,manufacturer,price,description));
        writeToDatabase();
    }

    private static void showProducts() throws Exception{
        readFromDatabase();
//        for (Product product : productList){
//            System.out.println(product.toString());
//        }
        productList.forEach((v) -> System.out.println(v.toString()));
    }
}
