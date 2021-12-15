package com.kkorchyts.jwd.controller.executing.impl.rolecommand;

import com.kkorchyts.jwd.controller.executing.Command;
import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.impl.DAOFactory;
import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.building.RoleBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

public class AddNewRoleCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Role role = RoleBuilder.builder()
                    .role(request.getParameter("role"))
                    .description(request.getParameter("description"))
                    .build();
            BaseDao<Role, Integer> roleDao = (BaseDao<Role, Integer>) DAOFactory.getInstance().getDAO(Role.class);
            roleDao.add(role);
            out.println("Added: " + role);
        } catch (SQLException e) {
            out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
