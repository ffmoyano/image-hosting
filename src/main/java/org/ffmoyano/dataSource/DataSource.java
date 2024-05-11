package org.ffmoyano.dataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.ffmoyano.configuration.Configuration;

import java.sql.Connection;

import java.sql.SQLException;

public class DataSource {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    private static final String username = Configuration.getConfig().getString("db.username");
    private static final String password = Configuration.getConfig().getString("db.password");
    private static final String dbPath = Configuration.getConfig().getString("db.path");

    static {

        config.setJdbcUrl(dbPath);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
