package models;

public class Booking {
    private String fullNameCustomer;
    private String idCardCustomer;
    private String idService;

    public Booking() {
    }

    public Booking(String fullNameCustomer, String idCardCustomer, String idService) {
        this.fullNameCustomer = fullNameCustomer;
        this.idCardCustomer = idCardCustomer;
        this.idService = idService;
    }
    public Booking(String []booking) {
        this.fullNameCustomer = booking[0];
        this.idCardCustomer = booking[1];
        this.idService = booking[2];
    }

    public String getFullNameCustomer() {
        return fullNameCustomer;
    }

    public void setFullNameCustomer(String fullNameCustomer) {
        this.fullNameCustomer = fullNameCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return fullNameCustomer+","+idCardCustomer+","+idService;
    }
}
