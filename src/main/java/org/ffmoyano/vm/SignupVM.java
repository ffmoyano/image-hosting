package org.ffmoyano.vm;

import org.ffmoyano.model.User;
import org.ffmoyano.service.UserService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

public class SignupVM {

    private final UserService userService;
    private User loggedUser;


    public SignupVM(UserService userService) {
        this.userService = userService;
    }

    @Init
    public void init() {
        loggedUser = userService.getSessionUser();
        if (loggedUser != null) {
            Executions.sendRedirect("index");
        }
    }

}
