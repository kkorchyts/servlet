package com.kkorchyts.jwd.controller.executing.impl.autenticationcommand;

import com.kkorchyts.jwd.controller.executing.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        out.println("<body>");
        out.println("Login = " + login);
        out.println("<br/>");
        out.println("password = " + password);
        out.println("<br/>");
        out.println("<a href=\"MyController?command=GO_TO_LOGIN_PAGE\">Back to Login page</a>");
        out.println("</body>");

    }
}
