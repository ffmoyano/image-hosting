package org.ffmoyano.repository;

import org.ffmoyano.dataSource.DataSource;
import org.ffmoyano.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {

    public User getUserByEmailAndPassword(String email, String password)  {
        Connection con = null;
        try {
            Connection connection = DataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}
