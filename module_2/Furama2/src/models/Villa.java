package models;

public class Villa extends Services {
    private String standardRoom;
    private String otherDescription;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent,
                 String standardRoom, String otherDescription, double areaPool, int numberOfFloors) {
        super(id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }
    public Villa(String[]villa){
        super(villa[0], villa[1],Double.parseDouble(villa[2]), Double.parseDouble(villa[3]), Integer.parseInt(villa[4]),
                villa[5]);
        this.standardRoom = villa[6];
        this.otherDescription = villa[7];
        this.areaPool = Double.parseDouble(villa[8]);
        this.numberOfFloors = Integer.parseInt(villa[9]);
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }


    @Override
    public String toString() {
        return super.toString() + "," + standardRoom + "," + otherDescription + "," + areaPool + "," + numberOfFloors;
    }

    @Override
    public void showInFor() {
        System.out.println("Villa{" +
                "id='" + getId() +
                ", serviceName='" +getServiceName()+
                ", areaUse=" + getAreaUse() +
                ", rentCost=" + getRentCost() +
                ", numberOfPeoples=" + getNumberOfPeoples() +
                ", typeRent='" + getTypeRent() +
                "standardRoom='" + standardRoom +
                ", otherDescription='" + otherDescription +
                ", areaPool=" + areaPool +
                ", numberOfFloors=" + numberOfFloors +
                "} ");
    }
}
