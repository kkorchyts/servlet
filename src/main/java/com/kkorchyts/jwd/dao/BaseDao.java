package com.kkorchyts.jwd.dao;

import java.sql.SQLException;
import java.util.Set;

public interface BaseDao<T, PK> {
    PK add(T t) throws SQLException;

    void remove(T t);

    void update(T src);

    Set<T> getAll() throws SQLException;

    T findById(Integer id);
}