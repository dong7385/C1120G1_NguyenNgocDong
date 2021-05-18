package repository.employee;

import model.Employee;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM employee";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM employee where employeeId = ?";
    @Override
    public Employee findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String employeeName = resultSet.getString(2);
                    employee = new Employee(id, employeeName);
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
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
                resultSet = preparedStatement.executeQuery();
                Employee employee = null;
                while (resultSet.next()) {
                    int productId = resultSet.getInt(1);
                    String productName = resultSet.getString(2);
                    employee = new Employee(productId, productName);
                    employees.add(employee);
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
        return employees;
    }

}
