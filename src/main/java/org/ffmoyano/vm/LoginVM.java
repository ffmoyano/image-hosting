package org.ffmoyano.vm;

import org.ffmoyano.model.User;
import org.ffmoyano.service.UserService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class LoginVM {

	private final UserService userService;
	private User loggedUser;
	private String error;
	private int count;

	public LoginVM(UserService userService) {
		this.userService = userService;
	}

	@Init
	public void init() {
		loggedUser = userService.getSessionUser();
		if(loggedUser != null) {
			Executions.sendRedirect("index");
		}
	}

	@Command("login")
	@NotifyChange("error")
	public void login(@BindingParam("email") String email, @BindingParam("password") String password) {
		Session sess = Sessions.getCurrent();
		User user = userService.getUserByEmailAndPassword(email, password);
		if(user != null) {
			sess.setAttribute("userCredential", user);
			Executions.sendRedirect("index");
		} else {
			error = "No se encuentra un usuario con ese email y/o contraseña.";
		}
	}
}
