package model;

public class Request {
    private  int requestId;
    private  String pttt;
    Product product;
    Customer customer;
    Employee employee;
    private String requestDay;
    private String requestUp;
    private String requestAddress;

    public Request() {
    }

    public Request(int requestId, String pttt, Product product, Customer customer, Employee employee, String requestDay, String requestUp, String requestAddress) {
        this.requestId = requestId;
        this.pttt = pttt;
        this.product = product;
        this.customer = customer;
        this.employee = employee;
        this.requestDay = requestDay;
        this.requestUp = requestUp;
        this.requestAddress = requestAddress;
    }

    public Request(String pttt, Product product, Customer customer, Employee employee, String requestDay, String requestUp, String requestAddress) {
        this.pttt = pttt;
        this.product = product;
        this.customer = customer;
        this.employee = employee;
        this.requestDay = requestDay;
        this.requestUp = requestUp;
        this.requestAddress = requestAddress;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getPttt() {
        return pttt;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRequestDay() {
        return requestDay;
    }

    public void setRequestDay(String requestDay) {
        this.requestDay = requestDay;
    }

    public String getRequestUp() {
        return requestUp;
    }

    public void setRequestUp(String requestUp) {
        this.requestUp = requestUp;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }
}
