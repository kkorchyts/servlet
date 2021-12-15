package com.kkorchyts.jwd.controller;

import com.kkorchyts.jwd.controller.executing.Command;
import com.kkorchyts.jwd.controller.executing.CommandProvider;
import com.kkorchyts.jwd.dao.BaseDao;
import com.kkorchyts.jwd.dao.impl.DAOFactory;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPool;
import com.kkorchyts.jwd.dao.mysql.connectionpool.ConnectionPoolException;
import com.kkorchyts.jwd.model.Role;
import com.kkorchyts.jwd.model.building.RoleBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Controller extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            throw new ServletException(e);
        }
    }

    private final CommandProvider commandProvider = new CommandProvider();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runCommand(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runCommand(request, response);
    }

    private void runCommand(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String commandName = request.getParameter("command");
        if (commandName == null) {
            commandName = "NOOPERATION";
        }
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);
    }
}
