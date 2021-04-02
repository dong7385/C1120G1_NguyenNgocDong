package models;

public class Room extends Services {
    private String extraService;

    public Room() {
    }

    public Room(String extraService) {
        this.extraService = extraService;
    }

    public Room(String id, String serviceName, double areaUse, double rentCost, int numberOfPeoples, String typeRent, String extraService) {
        super(id, serviceName, areaUse, rentCost, numberOfPeoples, typeRent);
        this.extraService = extraService;
    }

    public Room(String[] room) {
        super(room[0], room[1], Double.parseDouble(room[2]), Double.parseDouble(room[3]), Integer.parseInt(room[4]), room[5]);
        this.extraService = room[6];
    }

    public String getExtraService() {
        return extraService;
    }

    public void setExtraService(String extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return super.toString() + "," + extraService;
    }

    @Override
    public void showInFor() {
        System.out.println("Room{" +
                ", id='" + getId() +
                ", serviceName='" + getServiceName() +
                ", areaUse=" + getAreaUse() +
                ", rentCost=" + getRentCost() +
                ", numberOfPeoples=" + getNumberOfPeoples() +
                ", typeRent='" + getTypeRent() +
                "extraService='" + extraService + '\'' +
                '}');
    }
}
