package com.jasper.demo.demojasper.reports.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConection {
    public static Connection conectar() {
        Connection con = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/jasper_demo?user=admin&password=123";
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conexion Satisfactoria");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
