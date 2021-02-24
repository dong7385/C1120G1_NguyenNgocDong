package service;

import commons.FuncWriteAndRead;
import commons.regexExceptions.ValidateException;
import exception.CompareByName;
import models.Customer;

import java.util.*;

public class CustomerManager {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<Customer> functionReadAndWrite = new FuncWriteAndRead<>();

    public void addNewCustomer() {
        String fullName;
        String dateOfBirth;
        String gender;
        String idCard;
        String phoneNumber;
        String email;
        String typeCustomer;
        String address;

        List<Customer> list = new ArrayList<>();

       do {
           System.out.println("please input fullName");
           fullName = scanner.nextLine();
       }while (!ValidateException.isValidateStandard(fullName, ValidateException.REGEX_FULL_NAME));
        System.out.println("please input dateOfBirth");
        dateOfBirth = scanner.nextLine();
        System.out.println("please input gender");
        gender = scanner.nextLine();
        System.out.println("please input idCard");
        idCard = scanner.nextLine();
        System.out.println("please input phoneNumber");
        phoneNumber = scanner.nextLine();
        System.out.println("please input email");
        email = scanner.nextLine();
        System.out.println("please input typeCustomer");
        typeCustomer = scanner.nextLine();
        System.out.println("please input address");
        address = scanner.nextLine();
        Customer customer;
        customer = new Customer(fullName, dateOfBirth, gender, idCard, phoneNumber, email, typeCustomer, address);
        list.add(customer);
        functionReadAndWrite.writeFile("Customer.csv", list, true);
    }

    public List<Customer> findAll() {
        List<String[]> list = functionReadAndWrite.readFile("Customer.csv");
        List<Customer> listCustomer = new ArrayList<>();

        for (String[] strings : list) {
            Customer customer = new Customer(strings);
            listCustomer.add(customer);
        }
//        listCustomer.sort(new CompareByName());
        return listCustomer;
    }
}

