package com.kkorchyts.jwd.dao.mysql.connectionpool;

public final class DBParameter {
    private DBParameter(){}
    public static final String DB_DRIVER = "connection.driver";
    public static final String DB_URL = "connection.url";
    public static final String DB_USER = "connection.user";
    public static final String DB_PASSWORD = "connection.password";
    public static final String DB_POLL_SIZE = "connection.poolsize";
}
