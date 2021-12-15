package com.kkorchyts.jwd.controller.executing.impl.rolecommand;

import com.kkorchyts.jwd.controller.executing.Command;
import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.impl.DAOFactory;
import com.kkorchyts.jwd.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GetAllRolesCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Set<Role> roles = new HashSet<>();
        try {
            BaseDao<Role, Integer> roleDao = (BaseDao<Role, Integer>) DAOFactory.getInstance().getDAO(Role.class);
            roles = roleDao.getAll();
            for (Role role : roles) {
                out.println(role);
            }

        } catch (SQLException e) {
            out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
