package service;

import commons.FuncWriteAndRead;
import exception.CompareByName;
import models.Booking;
import models.Customer;
import models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    VillaManager villaManager = new VillaManager();
    static CustomerManager customerManager = new CustomerManager();
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<Booking> functionReadAndWrite = new FuncWriteAndRead<>();
    Booking booking = new Booking();

    public void addNewBooking() {
        List<Customer> customerList = customerManager.findAll();
        customerList.sort(new CompareByName());
        for (int i = 0; i < customerList.size(); i++) {
            System.out.print((i + 1) + ". ");
            customerList.get(i).showInFor();
        }
        System.out.println("please choice Customer");
        int iCustomer = Integer.parseInt(scanner.nextLine());
        booking.setFullNameCustomer(customerList.get(iCustomer - 1).getFullName());
        booking.setIdCardCustomer(customerList.get(iCustomer - 1).getIdCard());

        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("choice iService");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                List<Villa> villaList = villaManager.findAll();
                for (int i = 0; i < villaList.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    villaList.get(i).showInFor();
                }
                    System.out.println("Enter Villa");
                    int choiceVilla = Integer.parseInt(scanner.nextLine());
                    booking.setIdService(villaList.get(choiceVilla - 1).getId());
                    break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("please choice 1->3");
                }
                List<Booking> list = new ArrayList<>();
                list.add(booking);
                functionReadAndWrite.writeFile("Booking.csv", list, true);

    }
}
