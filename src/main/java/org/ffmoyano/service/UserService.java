package org.ffmoyano.service;

import org.ffmoyano.model.User;
import org.ffmoyano.repository.UserRepository;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class UserService {

    private final UserRepository repository = new UserRepository();

    public User getSessionUser() {
        Session sess = Sessions.getCurrent();
        User user = (User) sess.getAttribute("userCredential");
        if (user == null) {
            user = new User();//new a anonymous user and set to session
            sess.setAttribute("userCredential", user);
        }
        return user;
    }

    public User login(String email, String password) {
        String hashedPassword = SecurityService.pbkdf2Encode(password);
        return repository.getUserByEmailAndPassword(email, hashedPassword);
    }
}
