package repository.customer;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();

    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer;";
    public static final String INSERT_NEW_CUSTOMER = "INSERT INTO customer(customer_id,customer_type_id, customer_name,customer_birthday ,customer_gender ,customer_id_card ,customer_phone,customer_email , customer_address) VALUE (? ,? ,? ,?, ?, ?, ?,?,?);";
    public static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?;";
    public static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?,customer_gender = ?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id= ?;";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from Customer where customer_id = ?;";
    public static final String FIND_CUSTOMER_BY_NAME = "select * from Customer where customer_name like ?;";


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
                    String customer_id = resultSet.getString("customer_id");
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt("customer_type_id"));
                    String customer_name = resultSet.getString("customer_name");
                    Date customer_birthday = resultSet.getDate("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");

                    customer = new Customer(customer_id, customerType, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
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
                preparedStatement.setString(1,customer.getCustomer_id());
                preparedStatement.setInt(2,customer.getCustomerType().getCustomer_type_id());
                preparedStatement.setString(3, customer.getCustomer_name());
                preparedStatement.setDate(4,customer.getCustomer_birthday());
                preparedStatement.setBoolean(5,customer.getCustomer_gender());
                preparedStatement.setString(6,customer.getCustomer_id_card());
                preparedStatement.setString(7,customer.getCustomer_phone());
                preparedStatement.setString(8,customer.getCustomer_email());
                preparedStatement.setString(9,customer.getCustomer_address());

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
    public Customer findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt(2));
                    String customer_name = resultSet.getString(3);
                    Date customer_birthday = resultSet.getDate(4);
                    Boolean customer_gender = resultSet.getBoolean(5);
                    String customer_id_card = resultSet.getString(6);
                    String customer_phone = resultSet.getString(7);
                    String customer_email=resultSet.getString(8);
                    String customer_address = resultSet.getString(9);
                    customer = new Customer(id,customerType,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);
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
    public void update(String id, Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setInt(1, customer.getCustomerType().getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setDate(3,customer.getCustomer_birthday());
                preparedStatement.setBoolean(4,customer.getCustomer_gender());
                preparedStatement.setString(5,customer.getCustomer_id_card());
                preparedStatement.setString(6,customer.getCustomer_email());
                preparedStatement.setString(7,customer.getCustomer_phone());
                preparedStatement.setString(8,customer.getCustomer_address());
                preparedStatement.setString(9,id);

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
    public void remove(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setString(1, id);
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
                preparedStatement.setString(1, '%' + name + '%');
                resultSet = preparedStatement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    String customer_id=resultSet.getString(1);
                    CustomerType customerType;
                    customerType = customerTypeRepository.findById(resultSet.getInt(2));
                    String customer_name;
                    customer_name = resultSet.getString(3);
                    Date customer_birthday;
                    customer_birthday = resultSet.getDate(4);
                    Boolean customer_gender;
                    customer_gender = resultSet.getBoolean(5);
                    String customer_id_card;
                    customer_id_card = resultSet.getString(6);
                    String customer_phone = resultSet.getString(7);
                    String customer_email=resultSet.getString(8);
                    String customer_address = resultSet.getString(9);
                    customer = new Customer(customer_id,customerType,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address);

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
