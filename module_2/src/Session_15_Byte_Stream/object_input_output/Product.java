package Session_15_Byte_Stream.object_input_output;

import java.io.Serializable;
//import java.util.concurrent.atomic.AtomicInteger;

public class Product implements Serializable {


    private int id;
    private String name;
    private String manufacturer;
    private String price;
    private String description;

    public Product(){}

    public Product(String name, String manufacturer, String price, String description) {

        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id: " + id + "~~Name: " + name + "~~Price: " + price + "~~Manufacturer: " + manufacturer + "~~Description: " + description;
    }
}
