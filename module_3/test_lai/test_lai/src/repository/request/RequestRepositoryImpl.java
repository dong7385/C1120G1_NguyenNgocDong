package repository.request;

import model.Customer;
import model.Employee;
import model.Product;
import model.Request;
import repository.DBConnection;
import repository.customer.CustomerRepositoryImpl;
import repository.employee.EmployeeRepositoryImpl;
import repository.product.ProductRepositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestRepositoryImpl implements RequestRepository {

    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM request;";
    public static final String INSERT_NEW_CUSTOMER = "INSERT INTO customer(customer_id,customer_type_id, customer_name,customer_birthday ,customer_gender ,customer_id_card ,customer_phone,customer_email , customer_address) VALUE (? ,? ,? ,?, ?, ?, ?,?,?);";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?;";
    public static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?,customer_gender = ?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id= ?;";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from Customer where customer_id = ?;";
    public static final String FIND_CUSTOMER_BY_NAME = "select * from Customer where customer_name like ?;";

    private static ProductRepositoryImpl productRepository=new ProductRepositoryImpl();
    private static EmployeeRepositoryImpl employeeRepository=new EmployeeRepositoryImpl();
    private static CustomerRepositoryImpl customerRepository=new CustomerRepositoryImpl();

    @Override
    public List<Request> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Request> requestList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                Request request = null;
                while (resultSet.next()) {
                    int requestId = resultSet.getInt("requestId");
                    String pttt=resultSet.getString("pttt");
                    Product product = productRepository.findById(resultSet.getInt("productId"));
                    Customer customer = customerRepository.findById(resultSet.getInt("customerId"));
                    Employee employee = employeeRepository.findById(resultSet.getInt("employeeId"));
                    String requestDay=resultSet.getString("requestDay");
                    String requestUp=resultSet.getString("requestUp");
                    String requestAddress=resultSet.getString("requestAddress");

                   request = new Request(requestId,pttt,product,customer,employee,requestDay,requestUp,requestAddress);
                   //request = new Request(pttt,product,customer,employee,requestDay,requestUp,requestAddress);
                    requestList.add(request);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert resultSet != null;
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return requestList;
    }

    @Override
    public void save(Request request) {

    }

    @Override
    public Request findById(String id) {
        return null;
    }

    @Override
    public void update(String id, Request request) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Request> searchCustomer(String name) {
        return null;
    }
}
