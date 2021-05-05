package repository.service_furuma;

import model.service.RentType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    private static final String SELECT_FROM_RENT_TYPE = "SELECT * FROM rent_type";
    private static final String GET_RENT_TYPE_BY_ID = "SELECT * FROM rent_type where rent_type_id = ?";


    @Override
    public RentType findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RentType rentType = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_RENT_TYPE_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String rent_type_name = resultSet.getString(2);
                    double rent_type_cost = resultSet.getDouble(3);
                    rentType = new RentType(id, rent_type_name,rent_type_cost);
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
        return rentType;
    }

    @Override
    public List<RentType> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<RentType> rentTypes = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_FROM_RENT_TYPE);
                resultSet = preparedStatement.executeQuery();
                RentType rentType = null;
                while (resultSet.next()) {
                    int rent_type_id = resultSet.getInt(1);
                    String rent_type_name = resultSet.getString(2);
                    double rent_type_cost=resultSet.getDouble(3);
                    rentType=new RentType(rent_type_id,rent_type_name,rent_type_cost);
                    rentTypes.add(rentType);
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
        return rentTypes;
    }
}
