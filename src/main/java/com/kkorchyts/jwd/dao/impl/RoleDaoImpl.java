package com.kkorchyts.jwd.dao.impl;

import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPool;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPoolException;
import com.kkorchyts.jwd.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class RoleDaoImpl implements BaseDao<Role, Integer> {
    private static final String SQL_INSERT = "INSERT INTO ROLES (ROLE, DESCRIPTION) VALUES (?, ?)";

    @Override
    public Integer add(Role role) throws SQLException {
        Connection connection = null;
        ResultSet generatedKeys = null;
        Integer generatedId = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, role.getRole());
            statement.setString(2, role.getDescription());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                    role.setId(generatedId);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            } else {
                throw new SQLException("Creating user failed/ Affected rows number is wrong.");
            }
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
                if (connection != null) {
                connection.rollback();
            }
            throw new SQLException(e);
        } finally {
            closeConnection(connection, generatedKeys);
        }
        return generatedId;
    }

    @Override
    public void remove(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public Set<Role> getAll() throws SQLException {
        Set<Role> roles = new HashSet<>();
        Connection connection = null;
        ResultSet rs = null;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                rs = statement.executeQuery("SELECT ID, ROLE, DESCRIPTION FROM ROLES");
                while (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getInt(1));
                    role.setRole(rs.getString(2));
                    role.setDescription(rs.getString(3));
                    roles.add(role);
                }
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new SQLException(e);
        } finally {
            closeConnection(connection, rs);
        }
        return roles;
    }

    private void closeConnection(Connection connection, ResultSet rs) {
        try{
          if (rs != null) {
              rs.close();
          }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Role findById(Integer id) {
        return null;
    }
}
