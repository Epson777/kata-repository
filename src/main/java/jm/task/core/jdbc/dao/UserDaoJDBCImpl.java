package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    User user = new User();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(40) NOT NULL," +
                "lastName VARCHAR(50) NOT NULL," +
                "age TINYINT (4) NOT NULL);";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close prepared statement");
                }
            }
            if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection");
                }
            }
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS user";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close prepared statement");
                }
                if (getConnection() != null) {
                    try {
                        getConnection().close();
                    } catch (SQLException e) {
                        System.out.println("Failed to close connection");
                    }
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);

            System.out.println("User с именем " + name + " добавлен в базу данных");

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close prepared statement");
                }
            }
            if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection");
                }
            }
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close prepared statement");
                }
            }
            if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection");
                }
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM user;";

        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getByte("age"));

                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close statement");
                }
            } if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection");
                }
            }
        }
        return list;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM user;";
        PreparedStatement ps = null;

        try {
            ps = getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close prepared statement");
                }
            } if (getConnection() != null) {
                try {
                    getConnection().close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection");
                }
            }
        }
    }
}