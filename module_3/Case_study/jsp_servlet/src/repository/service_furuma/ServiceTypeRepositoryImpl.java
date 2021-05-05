package repository.service_furuma;

import model.service.ServiceType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private static final String SELECT_FROM_SERVICE_TYPE = "SELECT * FROM service_type";
    private static final String GET_SERVICE_TYPE_BY_ID = "SELECT * FROM service_type where service_type_id = ?";

    @Override
    public ServiceType findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ServiceType serviceType = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_SERVICE_TYPE_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String service_type_name = resultSet.getString(2);
                    serviceType = new ServiceType(id, service_type_name);
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
        return serviceType;
    }

    @Override
    public List<ServiceType> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ServiceType> serviceTypes = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_FROM_SERVICE_TYPE);
                resultSet = preparedStatement.executeQuery();
                ServiceType serviceType = null;
                while (resultSet.next()) {
                    int customer_type_id = resultSet.getInt(1);
                    String customer_type_name = resultSet.getString(2);
                    serviceType = new ServiceType(customer_type_id, customer_type_name);
                    serviceTypes.add(serviceType);
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
        return serviceTypes;
    }
}

