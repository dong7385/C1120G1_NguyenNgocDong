package repository.product;

import model.Product;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM product";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM product where productId = ?";

    @Override
    public Product findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String productName = resultSet.getString(2);
                    product = new Product(id, productName);
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
        return product;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> productsss = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
                resultSet = preparedStatement.executeQuery();
                Product product = null;
                while (resultSet.next()) {
                    int productId = resultSet.getInt(1);
                    String productName = resultSet.getString(2);
                    product = new Product(productId, productName);
                    productsss.add(product);
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
        return productsss;
    }
}

