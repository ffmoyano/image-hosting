package org.ffmoyano.vm;

import org.ffmoyano.model.User;
import org.ffmoyano.repository.UserRepository;
import org.ffmoyano.service.UserService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import java.sql.SQLException;

public class IndexVM {
	private final UserService userService;
	private User loggedUser;
	private int count;

    public IndexVM(UserService userService) {
        this.userService = userService;
    }

    @Init
	public void init() {
		loggedUser = userService.getSessionUser();
		if(loggedUser == null) {
			Executions.sendRedirect("login");
		}
		count = 100;
	}

	@Command
	@NotifyChange("count")
	public void cmd() throws SQLException {
		new UserRepository().findByUserNameAndPassword();
	}

	public int getCount() {
		return count;
	}
}
