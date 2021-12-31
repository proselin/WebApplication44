/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoch
 */
public class checkLogin {

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(20);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM tblUser WHERE _UserName = ?";
//        password = getMd5(password);
        GetConnection cn = new GetConnection();
        user_Model um = new user_Model();
        Connection conn = cn.getConnection();
        boolean result = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next() != false) {
                result = true;
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String checkEmail(String email) {
        String sql = "SELECT * FROM tblUser WHERE email = ?";
        GetConnection cn = new GetConnection();
        user_Model um = new user_Model();
        Connection conn = cn.getConnection();
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next() != false) {
                result = rs.getString(1);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String checkLoginByEveryThing(String userNameOrEmailOrPhone, String password) {
        String sql = "SELECT * FROM tblUser WHERE _UserName = ? AND _PassWord = ? or Phone = ? OR email = ?";
        password = getMd5(password);
        GetConnection cn = new GetConnection();
        user_Model um = new user_Model();
        Connection conn = cn.getConnection();
        String us = "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userNameOrEmailOrPhone);
            ps.setString(2, password);
            ps.setString(3, userNameOrEmailOrPhone);
            ps.setString(4, userNameOrEmailOrPhone);
            ResultSet rs = ps.executeQuery();
            if (rs.next() != false) {
                us = rs.getString("UserID");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(checkLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

}
