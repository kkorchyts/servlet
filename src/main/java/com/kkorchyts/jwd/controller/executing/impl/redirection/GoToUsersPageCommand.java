package com.kkorchyts.jwd.controller.executing.impl.redirection;

import com.kkorchyts.jwd.controller.executing.Command;
import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.impl.DAOFactory;
import com.kkorchyts.jwd.dao.impl.RoleDaoImpl;
import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.User;
import com.kkorchyts.jwd.model.building.UserBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public class GoToUsersPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        User user = UserBuilder.builder().firsName("Kazimir").lastName("Korchyts").build();
        request.setAttribute("user", user);
*/
        BaseDao<User, Integer> userDao = (BaseDao<User, Integer>) DAOFactory.getInstance().getDAO(User.class);
        Set<User> users;
        try {
            users = userDao.getAll();
        } catch (SQLException throwables) {
            users = null;
        }
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/users.jsp");
        dispatcher.forward(request, response);
    }
}
