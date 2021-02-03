//package service;
//
//import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
//import commons.FuncWriteAndRead;
//import models.Booking;
//import models.Customer;
//import models.Villa;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import static service.VillaManager.functionReadAndWrite;
//
//public class BookingManager {
//    private void AddNewBooking() {
//        VillaManager villaManager = new VillaManager();
//        List<Villa>villaList=villaManager.findAll();
//        Scanner scanner = new Scanner(System.in);
//        FuncWriteAndRead<Booking> functionReadAndWrite = new FuncWriteAndRead<>();
//        Customer customer = new Customer();
//        String fullNameCustomer = null;
//        String idCardCustomer = null;
//        String idService = null;
//        List<Booking> listBooking = new ArrayList<>();
//        Booking booking = new Booking();
//        CustomerManager customerManager = new CustomerManager() ;
//        List<Customer> customerList =customerManager.findAll();
//        int iCustomer = Integer.parseInt(scanner.nextLine());
//        customer= customerList.get(iCustomer-1);
//
//        booking.setFullNameCustomer(customer.getFullName());
//        booking.setFullNameCustomer(customer.getIdCard());
//        booking.setIdService(villaList.get(0).getId());
//        listBooking.add(booking);
//        functionReadAndWrite.writeFile("Booking.csv", listBooking, true);
//    }
//}