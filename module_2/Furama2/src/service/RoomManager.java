package service;

import commons.FuncWriteAndRead;
import commons.regexExceptions.ValidateException;
import models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<Room> functionReadAndWrite = new FuncWriteAndRead<>();

    public void addNewRoom() {
        String id;
        String serviceName;
        double areaUse;
        double rentCost;
        int numberOfPeoples;
        String typeRent;

       String extraService;

        List<Room> list = new ArrayList<>();
        do{
            System.out.println("Please Input Id");
            id = scanner.nextLine();
        } while (ValidateException.isValidateStandard(id, ValidateException.REGEX_ID));
        do {
            System.out.println("Please Input serviceName");
            serviceName = scanner.nextLine();
        }while (ValidateException.isValidateStandard(serviceName, ValidateException.REGEX_SERVICE_NAME));
        do{
            System.out.println("Please Input areaUse");
            areaUse = Double.parseDouble(scanner.nextLine());
        }while (ValidateException.isMoreThan(areaUse, 30));
        do {
            System.out.println("Please Input rentCost");
            rentCost = Double.parseDouble(scanner.nextLine());
        }while (ValidateException.isMoreThan(rentCost, 0));
        do{
            System.out.println("Please Input numberOfPeoples");
            numberOfPeoples = Integer.parseInt(scanner.nextLine());
        }while (ValidateException.isMoreThan(numberOfPeoples, 0, 20));

        do {
            System.out.println("Please Input typeRent");
            typeRent =scanner.nextLine();
        }while (ValidateException.isValidateStandard(typeRent, ValidateException.REGEX_SERVICE_NAME));
       do {
           System.out.println("Please Input extraService");
           extraService=scanner.nextLine();
       }while (!ValidateException.isExtraService(extraService));

        Room room = new Room(id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent,extraService );
        list.add(room);
        functionReadAndWrite.writeFile("Room.csv",list, true);
    }
    public List<Room> findAll(){
        List<String[]> list=functionReadAndWrite.readFile("Room.csv");
        List<Room>listRoom=new ArrayList<>();

        for (String[] strings:list) {
            Room room=new Room(strings);
            listRoom.add(room);
        }
        return listRoom;
    }
}
