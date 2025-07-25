package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public void dropUsersTable() throws SQLException {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {

    }

    @Override
    public void removeUserById(long id) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return List.of();
    }

    @Override
    public void cleanUsersTable() throws SQLException {

    }
}

//    public void createUsersTable() throws SQLException { // DDL
//        String sql = "CREATE TABLE IF NOT EXISTS user (" +
//                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
//                "name VARCHAR(40) NOT NULL," +
//                "lastName VARCHAR(50) NOT NULL," +
//                "age TINYINT (4) NOT NULL);";
//        Connection connection = null;
//        try {
//            connection = Util.getConnection();
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.executeUpdate();
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dropUsersTable() throws SQLException { // DDL
//        String sql = "DROP TABLE IF EXISTS user";
//        Connection connection = null;
//        try {
//            connection = Util.getConnection();
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.executeUpdate();
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) throws SQLException { // DML
//        String sql = "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?)";
//        Connection connection = null;
//        try {
//            connection = Util.getConnection();
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, name);
//                preparedStatement.setString(2, lastName);
//                preparedStatement.setByte(3, age);
//                preparedStatement.executeUpdate();
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeUserById(long id) throws SQLException { // DML
//        String sql = "DELETE FROM user WHERE id = ?";
//        Connection connection = null;
//        try {
//            connection = Util.getConnection();
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setLong(1, id);
//                preparedStatement.executeUpdate();
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<User> getAllUsers() throws SQLException { // DML
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT id, name, lastName, age FROM user;";
//        Connection connection = null;
//        try {
//                connection = Util.getConnection();
//            try (Statement statement = connection.createStatement()) {
//                var resultSet = statement.executeQuery(sql);
//
//                while (resultSet.next()) {
//                    User user = new User();
//                    user.setId(resultSet.getLong("id"));
//                    user.setName(resultSet.getString("name"));
//                    user.setLastName(resultSet.getString("lastName"));
//                    user.setAge(resultSet.getByte("age"));
//                    list.add(user);
//                }
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//
//    public void cleanUsersTable() throws SQLException { // DDL
//        String sql = "TRUNCATE user;";
//        Connection connection = null;
//        try {
//            connection = Util.getConnection();
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.executeUpdate();
//            }
//            Util.commitAndClose(connection);
//        } catch (SQLException e) {
//            Util.rollbackAndClose(connection);
//            throw new RuntimeException(e);
//        }
//    }
//}