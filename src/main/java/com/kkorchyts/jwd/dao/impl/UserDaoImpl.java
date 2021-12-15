package com.kkorchyts.jwd.dao.impl;

import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPool;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPoolException;
import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements BaseDao<User, Integer> {
    private static final String SQL_INSERT_USER = "INSERT INTO USER (LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_USER_TO_ROLES = "INSERT INTO USER_TO_ROLES (USER_ID, ROLE_ID) VALUES (?, ?)";
    private static final String SQL_CHECK_USER_TO_ROLES = "SELECT COUNT(USER_ID) FROM USER_TO_ROLES WHERE USER_ID = ? AND ROLE_ID = ?";
    private static final String SQL_SELECT_USERS = "SELECT ID, LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS FROM USERS";


    @Override
    public Integer add(User user) throws SQLException {
        Connection connection = null;
        ResultSet generatedKeys = null;
        Integer generatedId = null;
        boolean oldAutocommit = true;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            oldAutocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirsName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getAddress());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                    user.setId(generatedId);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            } else {
                throw new SQLException("Creating user failed/ Affected rows number is wrong.");
            }

            for (Role role : user.getRoles()) {
                statement = connection.prepareStatement(SQL_INSERT_USER_TO_ROLES);
                statement.setInt(1, user.getId());
                statement.setInt(2, role.getId());
                statement.executeUpdate();
            }

            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw new SQLException(e);
        } finally {
            closeConnection(connection, oldAutocommit, generatedKeys);
        }
        return generatedId;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User src) {

    }

    @Override
    public Set<User> getAll() throws SQLException {
        Connection connection = null;
        ResultSet rs = null;
        Set<User> users = new HashSet<User>();
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(SQL_SELECT_USERS);
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirsName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setAddress(rs.getString(7));
                users.add(user);
            }

        } catch (ConnectionPoolException | SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw new SQLException(e);
        } finally {

            closeConnection(connection, true, rs);
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    private void closeConnection(Connection connection, boolean oldAutocommit, ResultSet rs) {
        try{
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.setAutoCommit(oldAutocommit);
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
