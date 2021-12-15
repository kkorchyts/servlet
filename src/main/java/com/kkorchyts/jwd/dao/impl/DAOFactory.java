package com.kkorchyts.jwd.dao.impl;

import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.User;

import java.util.HashMap;
import java.util.Map;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final Map<Class<?>, BaseDao<?, ?>> mapDao = new HashMap<>();
    {
        mapDao.put(Role.class, new RoleDaoImpl());
        mapDao.put(User.class, new UserDaoImpl());
    }

    private DAOFactory() {
    }

    public BaseDao<?, ?> getDAO(Class<?> cl) {
        return mapDao.get(cl);
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}