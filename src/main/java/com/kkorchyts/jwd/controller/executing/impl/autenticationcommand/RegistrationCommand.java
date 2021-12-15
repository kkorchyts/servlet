package com.kkorchyts.jwd.controller.executing.impl.autenticationcommand;

import com.kkorchyts.jwd.controller.executing.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        out.println("<body>");
        out.println("name = " + name);
        out.println("<br/>");
        out.println("surname" +
                " = " + surname);
        out.println("<br/>");
        out.println("<a href=\"MyController?command=GO_TO_REGISTRATION_PAGE\">Back to Registration page</a>");
        out.println("</body>");
    }
}
