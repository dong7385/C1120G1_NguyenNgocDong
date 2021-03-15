package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {

    public static final String SELECT_ALL_STUDENT = "select * from student";
    public static final String INSERT_NEW_STUDENT = "INSERT INTO student(name, gender, point, image) VALUE (? ,? ,? ,?)";

//    private static Map<Integer, Student> studentList;
//
//    static {
//        studentList = new HashMap<>();
//        studentList.put(1, new Student(1, "Khoa", 1, 90, ""));
//        studentList.put(2, new Student(2, "Dong", 1, 100, "avatar_1.jpg"));
//        studentList.put(3, new Student(3, "Hong", 0, 50, "avatar_2.png"));
//        studentList.put(4, new Student(4, "Hue", 2, 80, "avatar_3.jpg"));
//    }

    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_STUDENT);
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");
                    student = new Student(id, name, gender, point, image);
                    studentList.add(student);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_STUDENT);
                statement.setString(1, student.getName());
                statement.setInt(2, student.getGender());
                statement.setInt(3, student.getPoint());
                statement.setString(4, student.getImage());

                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
