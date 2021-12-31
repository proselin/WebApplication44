/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoch
 */
public class GetConnection {

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String un = "se";
            String pw = "admin";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=SHOPS";
            try {
                conn = DriverManager.getConnection(url, un, pw);
//                conn = DriverManager.getConnection(url)
            } catch (SQLException ex) {
                Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public Connection getConnection(String un, String pw, String db) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + db;
            try {
                conn = DriverManager.getConnection(url, un, pw);
            } catch (SQLException ex) {
                Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

}
