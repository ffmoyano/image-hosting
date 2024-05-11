package org.ffmoyano.service;

import org.ffmoyano.model.User;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class UserService {

    public User getSessionUser() {
        Session sess = Sessions.getCurrent();
        User user = (User) sess.getAttribute("userCredential");
        if (user == null) {
            user = new User();//new a anonymous user and set to session
            sess.setAttribute("userCredential", user);
        }
        return user;
    }
}
