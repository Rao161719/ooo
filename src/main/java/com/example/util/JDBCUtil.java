package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cgb2022?characterEncoding=utf8",
                "root", "");
        return conn;
    }
}
