package org.ffmoyano.repository;

import org.ffmoyano.dataSource.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {

    public void findByUserNameAndPassword() throws SQLException {
        Connection connection = DataSource.getConnection();
    }


}
