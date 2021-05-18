package repository;

import model.PhongTro;
import model.ThanhToan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepositoryImpl implements PhongTroRepository {
    private static ThanhToanRepositoryImpl thanhToanRepository = new ThanhToanRepositoryImpl();
    public static final String SELECT_ALL_PHONGTRO = "SELECT * FROM phongTro;";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from phongTro where phongTroId = ?;";

    @Override
    public List<PhongTro> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<PhongTro> phongTroList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_PHONGTRO);
                resultSet = preparedStatement.executeQuery();
                PhongTro phongTro = null;
                while (resultSet.next()) {
                    String phongTroId = resultSet.getString("phongTroId");
                    String phongTroTen = resultSet.getString("phongTroTen");
                    int Sdt =resultSet.getInt("Sdt");
                    String ngayBatDauThue = resultSet.getString("ngayBatDauThue");
                    ThanhToan thanhToan = thanhToanRepository.findById(resultSet.getInt("hinhThucThanhToanId"));
                    String ghiChu = resultSet.getString("ghiChu");

                    phongTro = new PhongTro(phongTroId,phongTroTen,Sdt,ngayBatDauThue,thanhToan,ghiChu);
                    phongTroList.add(phongTro);
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
        return phongTroList;
    }

    @Override
    public void save(PhongTro phongTro) {

    }

    @Override
    public PhongTro findById(String id) {
        return null;
    }

    @Override
    public void update(String id, PhongTro phongTro) {

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
    public List<PhongTro> searchCustomer(String name) {
        return null;
    }
}
