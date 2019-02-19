package repository;

import java.sql.Connection;

public abstract class SQLRepository {

    private Connection connection;

    protected SQLRepository(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }
}
