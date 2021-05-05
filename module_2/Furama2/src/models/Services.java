package models;

public abstract class Services {
    private String id;
    private String serviceName;
    private double areaUse;
    private double rentCost;
    private int numberOfPeoples;
    private String typeRent;

    public Services() {
    }

    public Services(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentCost = rentCost;
        this.numberOfPeoples = numberOfPeoples;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return id + "," +serviceName+","+ areaUse + "," + rentCost + "," + numberOfPeoples + "," + typeRent;

    }
    public abstract void showInFor();
}
