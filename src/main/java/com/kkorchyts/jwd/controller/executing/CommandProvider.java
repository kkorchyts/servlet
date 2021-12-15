package com.kkorchyts.jwd.controller.executing;

import com.kkorchyts.jwd.controller.executing.impl.autenticationcommand.LoginCommand;
import com.kkorchyts.jwd.controller.executing.impl.autenticationcommand.RegistrationCommand;
import com.kkorchyts.jwd.controller.executing.impl.redirection.GoToGreetingPageCommand;
import com.kkorchyts.jwd.controller.executing.impl.redirection.GoToLoginPageCommand;
import com.kkorchyts.jwd.controller.executing.impl.redirection.GoToMainPageCommand;
import com.kkorchyts.jwd.controller.executing.impl.redirection.GoToRegistrationPageCommand;
import com.kkorchyts.jwd.controller.executing.impl.redirection.GoToUsersPageCommand;
import com.kkorchyts.jwd.controller.executing.impl.rolecommand.AddNewRoleCommand;
import com.kkorchyts.jwd.controller.executing.impl.rolecommand.GetAllRolesCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider() {
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("add_role", new AddNewRoleCommand());
        commands.put("get_all_roles", new GetAllRolesCommand());
        commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegistrationPageCommand());
        commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
        commands.put("GO_TO_LOGIN_PAGE", new GoToLoginPageCommand());
        commands.put("GO_TO_GREETING_PAGE", new GoToGreetingPageCommand());
        commands.put("GO_TO_USERS_PAGE", new GoToUsersPageCommand());
    }

    public final Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }

}
