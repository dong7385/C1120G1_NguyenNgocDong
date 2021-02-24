package service;

import commons.FuncWriteAndRead;
import commons.regexExceptions.ValidateException;
import models.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseManager {
    static Scanner scanner = new Scanner(System.in);
    static FuncWriteAndRead<House> functionReadAndWrite = new FuncWriteAndRead<>();

    public void addNewVHouse() {
        String id;
        String serviceName;
        double areaUse;
        double rentCost;
        int numberOfPeoples;
        String typeRent;

        String standardRoom;
        String otherDescription;
        int numberOfFloors;

        List<House> list = new ArrayList<>();

        do {
            System.out.println("Please Input Id");
            id = scanner.nextLine();
        } while (ValidateException.isValidateStandard(id, ValidateException.REGEX_ID));
        do {
            System.out.println("Please Input serviceName");
            serviceName = scanner.nextLine();
        } while (ValidateException.isValidateStandard(serviceName, ValidateException.REGEX_SERVICE_NAME));
        do {
            System.out.println("Please Input areaUse");
            areaUse = Double.parseDouble(scanner.nextLine());
        } while (ValidateException.isMoreThan(areaUse, 30));
        do {
            System.out.println("Please Input rentCost");
            rentCost = Double.parseDouble(scanner.nextLine());
        } while (ValidateException.isMoreThan(rentCost, 0));
        do {
            System.out.println("Please Input numberOfPeoples");
            numberOfPeoples = Integer.parseInt(scanner.nextLine());
        } while (ValidateException.isMoreThan(numberOfPeoples, 0, 20));

        do {
            System.out.println("Please Input typeRent");
            typeRent = scanner.nextLine();
        } while (ValidateException.isValidateStandard(typeRent, ValidateException.REGEX_SERVICE_NAME));

        do {
            System.out.println("Please Input standardRoom");
            standardRoom = scanner.nextLine();
        } while (ValidateException.isValidateStandard(standardRoom, ValidateException.REGEX_SERVICE_NAME));
        System.out.println("Please Input otherDescription");
        otherDescription = scanner.nextLine();

        do {
            System.out.println("Please Input numberOfFloors");
            numberOfFloors = Integer.parseInt(scanner.nextLine());
        } while (ValidateException.isMoreThan(numberOfFloors, 0));


        House house = new House(id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent,
                standardRoom, otherDescription, numberOfFloors);
        list.add(house);
        functionReadAndWrite.writeFile("House.csv", list, true);

    }

    public List<House> findAll() {
        List<String[]> list = functionReadAndWrite.readFile("House.csv");
        List<House> listHouse = new ArrayList<>();

        for (String[] strings : list) {
            House house = new House(strings);
            listHouse.add(house);
        }
        return listHouse;
    }
}
