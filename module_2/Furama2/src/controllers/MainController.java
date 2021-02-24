package controllers;

import commons.FuncWriteAndRead;
import exception.CompareByName;
import models.*;
import service.*;

import java.util.List;
import java.util.Scanner;

public class MainController {
    static FuncWriteAndRead<Customer> functionReadAndWrite = new FuncWriteAndRead<>();
    static VillaManager villaManager = new VillaManager();
    static HouseManager houseManager = new HouseManager();
    static RoomManager roomManager = new RoomManager();
    static CustomerManager customerManager = new CustomerManager();
    static BookingManager bookingManager = new BookingManager();


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        displayMainMenu();
    }

    public static void displayMainMenu() {

        do {
            System.out.println("1.\t Add New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                   addNewServices();
                    break;
                case 2:
                 showServices();
                    break;
                case 3:
                    customerManager.addNewCustomer();
                    break;
                case 4:
                    showInformationCustomers();
                    break;
                case 5:
                    bookingManager.addNewBooking();
                    break;
                case 6:
                    showInformationEmployee();
                    break;
                case 7:
                    System.exit(choose);
                default:
                    System.out.println("Please choice 1->7");
            }
        } while (true);
    }

    private static void showInformationEmployee() {
    }

    private static void showInformationCustomers(){
        List<Customer> list = customerManager.findAll();
        list.sort(new CompareByName());
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).showInFor();
        }
    }


    private static void showServices() {
        System.out.println("1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.exit(choose);
            default:
                System.out.println("please input 1->7");
        }
    }

    private static void showAllVilla() {
        List<Villa> list = villaManager.findAll();

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).showInFor();
        }
    }

    private static void showAllHouse() {
        List<House> list = houseManager.findAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).showInFor();
        }
    }

    private static void showAllRoom() {
        List<Room> list = roomManager.findAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).showInFor();
        }
    }

    private static void addNewServices() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");

        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                villaManager.addNewVilla();
                break;
            case 2:
                houseManager.addNewVHouse();
                break;
            case 3:
                roomManager.addNewRoom();
                break;
            case 4:
                displayMainMenu();
            case 5:
                System.exit(choose);
                break;
            default:
                System.out.println("Please choice 1->5");
        }
    }
}


