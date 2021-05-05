package models;

public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent, String standardRoom, String otherDescription, int numberOfFloors) {
        super(id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloors = numberOfFloors;
    }
    public House(String []house) {
        super(house[0], house[1],Double.parseDouble(house[2]), Double.parseDouble(house[3]), Integer.parseInt(house[4]), house[5]);
        this.standardRoom = house[6];
        this.otherDescription = house[7];
        this.numberOfFloors = Integer.parseInt(house[8]);
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public void showInFor() {
        System.out.println("House{" +
                "id='" + getId() +
                ", serviceName='" + getServiceName() +
                ", areaUse=" + getAreaUse() +
                ", rentCost=" + getRentCost() +
                ", numberOfPeoples=" + getNumberOfPeoples() +
                ", typeRent='" + getTypeRent() +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                "} ");
    }

    @Override
    public String toString() {
        return super.toString()+","+standardRoom+","+otherDescription+","+numberOfFloors;
    }
}
