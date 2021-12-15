package com.kkorchyts.jwd.controller.executing.impl.redirection;

import com.kkorchyts.jwd.controller.executing.Command;
import com.kkorchyts.jwd.model.User;
import com.kkorchyts.jwd.model.building.UserBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToGreetingPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserBuilder.builder().firsName("Kazimir").lastName("Korchyts").build();
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/greeting.jsp");
        dispatcher.forward(request, response);
    }
}