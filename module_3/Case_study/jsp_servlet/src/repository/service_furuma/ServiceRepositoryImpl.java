package repository.service_furuma;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static RentTypeRepositoryImpl rentTypeRepository = new RentTypeRepositoryImpl();
    private static ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();

    public static final String SELECT_ALL_SERVICE = "SELECT * FROM service;";
    public static final String INSERT_NEW_CUSTOMER = "INSERT INTO service(service_id,service_name, service_area,service_cost ,service_max_people ,rent_type_id ,service_type_id,standard_room , description_other_convenience,pool_area,number_of_floors) VALUE (? ,? ,? ,?, ?, ?, ?,?,?,?,?);";
    public static final String SELECT_SERVICE_BY_ID = "select * from service where service_id = ?;";
    public static final String UPDATE_SERVICE = "update service set service_name = ?, service_area = ?, service_cost = ?,service_max_people = ?,rent_type_id=?,service_type_id=?,standard_room=?,description_other_convenience=?,pool_area=?,number_of_floors=? where service_id= ?;";
    public static final String DELETE_SERVICE_BY_ID = "delete from service where service_id = ?;";
    public static final String FIND_SERVICE_BY_NAME = "select * from service where service_name like ?;";

    @Override
    public List<Service> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = preparedStatement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    String service_id = resultSet.getString("service_id");
                    String service_name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double service_cost = resultSet.getDouble("service_cost");
                    int service_max_people = resultSet.getInt("service_max_people");
                    RentType rentType = rentTypeRepository.findById(resultSet.getInt("rent_type_id"));
                    ServiceType serviceType = serviceTypeRepository.findById(resultSet.getInt("service_type_id"));
                    String standard_room = resultSet.getString("standard_room");
                    String description_other_convenience = resultSet.getString("description_other_convenience");
                    double pool_area = resultSet.getDouble("pool_area");
                    int number_of_floors = resultSet.getInt("number_of_floors");
                    service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rentType, serviceType, standard_room, description_other_convenience, pool_area, number_of_floors);
                    serviceList.add(service);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return serviceList;
    }

    @Override
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);
                preparedStatement.setString(1, service.getService_id());
                preparedStatement.setString(2, service.getService_name());
                preparedStatement.setInt(3, service.getService_area());
                preparedStatement.setDouble(4, service.getService_cost());
                preparedStatement.setInt(5, service.getService_max_people());

                preparedStatement.setInt(6, service.getRentType().getRent_type_id());
                preparedStatement.setInt(7, service.getServiceType().getService_type_id());
                preparedStatement.setString(8, service.getStandard_room());
                preparedStatement.setString(9, service.getDescription_other_convenience());
                preparedStatement.setDouble(10, service.getPool_area());
                preparedStatement.setInt(11, service.getNumber_of_floors());

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
    public Service findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Service service = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String service_name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double service_cost = resultSet.getDouble("service_cost");
                    int service_max_people = resultSet.getInt("service_max_people");
                    RentType rentType = rentTypeRepository.findById(resultSet.getInt("rent_type_id"));
                    ServiceType serviceType = serviceTypeRepository.findById(resultSet.getInt("service_type_id"));
                    String standard_room = resultSet.getString("standard_room");
                    String description_other_convenience = resultSet.getString("description_other_convenience");
                    double pool_area = resultSet.getDouble("pool_area");
                    int number_of_floors = resultSet.getInt("number_of_floors");
                    service = new Service(id, service_name, service_area, service_cost, service_max_people, rentType, serviceType, standard_room, description_other_convenience, pool_area, number_of_floors);

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
        return service;
    }

    @Override
    public void update(String id, Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_SERVICE);

                preparedStatement.setString(1, service.getService_name());
                preparedStatement.setInt(2, service.getService_area());
                preparedStatement.setDouble(3, service.getService_cost());
                preparedStatement.setInt(4, service.getService_max_people());

                preparedStatement.setInt(5, service.getRentType().getRent_type_id());
                preparedStatement.setInt(6, service.getServiceType().getService_type_id());
                preparedStatement.setString(7, service.getStandard_room());
                preparedStatement.setString(8, service.getDescription_other_convenience());
                preparedStatement.setDouble(9, service.getPool_area());
                preparedStatement.setInt(10, service.getNumber_of_floors());
                preparedStatement.setString(11,id);

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
                preparedStatement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
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
    public List<Service> searchCustomer(String name) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(FIND_SERVICE_BY_NAME);
                preparedStatement.setString(1, '%' + name + '%');
                resultSet = preparedStatement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    String service_id = resultSet.getString("service_id");
                    String service_name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double service_cost = resultSet.getDouble("service_cost");
                    int service_max_people = resultSet.getInt("service_max_people");
                    RentType rentType = rentTypeRepository.findById(resultSet.getInt("rent_type_id"));
                    ServiceType serviceType = serviceTypeRepository.findById(resultSet.getInt("service_type_id"));
                    String standard_room = resultSet.getString("standard_room");
                    String description_other_convenience = resultSet.getString("description_other_convenience");
                    double pool_area = resultSet.getDouble("pool_area");
                    int number_of_floors = resultSet.getInt("number_of_floors");
                    service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rentType, serviceType, standard_room, description_other_convenience, pool_area, number_of_floors);
                    serviceList.add(service);
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
        return serviceList;
    }
}
