package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.CustomerRepository;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();

    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM Customer;";
    public static final String INSERT_NEW_CUSTOMER = "INSERT INTO Customer (customerName, customerBirthday, customerGender,customerTypeId) VALUE (? ,? ,? ,?)";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from Customer where customerId = ?;";
    public static final String UPDATE_CUSTOMER = "update Customer set customerName = ?, customerBirthday = ?, customerGender = ?,customerTypeId = ? where customerId= ?;";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from Customer where customerId = ?;";
    public static final String FIND_CUSTOMER_BY_NAME = "select * from Customer where name like concat('%',?,'%');";


    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    int customerId = resultSet.getInt(1);
                    String customerName = resultSet.getString(2);
                    String customerBirthday = resultSet.getString(3);
                    String customerGender = resultSet.getString(4);
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt(5));
                    customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerType);
                    customerList.add(customer);
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
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
                preparedStatement.setString(1, customer.getCustomerName());
                preparedStatement.setString(2, customer.getCustomerBirthday());
                preparedStatement.setString(3, customer.getCustomerGender());
                preparedStatement.setInt(4, customer.getCustomerType().getCustomerTypeId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }

    }

    @Override
    public Customer findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String customerName = resultSet.getString(2);
                    String customerBirthday = resultSet.getString(3);
                    String customerGender = resultSet.getString(4);
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt(5));
                    customer = new Customer(id, customerName, customerBirthday, customerGender, customerType);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }

        return customer;
    }

    @Override
    public void update(int id, Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setString(1, customer.getCustomerName());
                preparedStatement.setString(2, customer.getCustomerBirthday());
                preparedStatement.setString(3, customer.getCustomerGender());
                preparedStatement.setInt(4, customer.getCustomerType().getCustomerTypeId());
                preparedStatement.setInt(5, id);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }

    }


    @Override
    public List<Customer> searchCustomer(String name) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_NAME);
                preparedStatement.setString(1, name);
                resultSet = preparedStatement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    int customerId = resultSet.getInt(1);
                    String customerName = resultSet.getString(2);
                    String customerBirthday = resultSet.getString(3);
                    String customerGender = resultSet.getString(4);
                    int customerTypeId = resultSet.getInt(5);
                    CustomerType customerType = customerTypeRepository.findById(customerTypeId);
                    customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerType);
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerList;
    }
}
