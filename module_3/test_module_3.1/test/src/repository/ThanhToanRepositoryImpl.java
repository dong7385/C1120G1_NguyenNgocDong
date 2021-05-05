package repository;

import model.ThanhToan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThanhToanRepositoryImpl implements ThanhToanRepository {
    private static final String SELECT_THANH_TOAN_TYPE = "SELECT * FROM thanhToan";
    private static final String GET_THANH_TOAN_TYPE_BY_ID = "SELECT * FROM thanhToan where hinhThucThanhToanId = ?";

    @Override
    public ThanhToan findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ThanhToan thanhToan = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_THANH_TOAN_TYPE_BY_ID);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String hinhThucThanhToanTen = resultSet.getString(2);
                    thanhToan = new ThanhToan(id, hinhThucThanhToanTen);
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
        return thanhToan;
    }

    @Override
    public List<ThanhToan> findAll() {
        Connection connection= DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<ThanhToan>thanhToans=new ArrayList<>();
        if(connection!=null){
            try {
                preparedStatement=connection.prepareStatement(SELECT_THANH_TOAN_TYPE);
                resultSet=preparedStatement.executeQuery();
                ThanhToan thanhToan=null;
                while (resultSet.next()){
                    int hinhThucThanhToanId=resultSet.getInt(1);
                    String hinhThucThanhToanTen=resultSet.getString(2);
                    thanhToan=new ThanhToan(hinhThucThanhToanId,hinhThucThanhToanTen);
                    thanhToans.add(thanhToan);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
        return thanhToans;
    }
}
