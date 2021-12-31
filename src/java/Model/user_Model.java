/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author quoch
 */
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class user_Model {

    public User search_User_Data(String userid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        User us = new User();

        String sql = "Select * from tblUser WHERE UserID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Get data
                us.setUserID(rs.getString(1));
                us.setFullName(rs.getString(2));
                us.setAddress(rs.getString(3));
                us.setGender(rs.getString(4));
                us.setPhone(rs.getString(5));
                us.setEmail(rs.getString(6));
                us.setDate_of_birth(rs.getDate(7));
                us.setUserName(rs.getString(8));
                us.setPassword(rs.getString(9));
                us.setPoint(rs.getInt(10));
                us.setRoleID(rs.getString(11));
            }
            //close port
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(user_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

    public ArrayList<User> User_Data() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();

        ArrayList<User> listuser = new ArrayList<>();
        String sql = "Select * from tblUser WHERE roleID =? OR roleID =?  ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "User012");
            ps.setString(2, "Staff012");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Get data
                User us = new User();
                us.setUserID(rs.getString(1));
                us.setFullName(rs.getString(2));
                us.setAddress(rs.getString(3));
                us.setGender(rs.getString(4));
                us.setPhone(rs.getString(5));
                us.setEmail(rs.getString(6));
                us.setDate_of_birth(rs.getDate(7));
                us.setUserName(rs.getString(8));
                us.setPassword(rs.getString(9));
                us.setPoint(rs.getInt(10));
                us.setRoleID(rs.getString(11));
                listuser.add(us);
            }
            //close port
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(user_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listuser;
    }

    

    public boolean create_New_User(String FullName, String _Address, String Gender, String Phone, String Email, Date Date_of_birth, String _UserName, String _Password, String RoleID) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        User us = new User();
        String sql = " INSERT INTO tblUser Values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, create_New_ID());
            ps.setString(2, FullName);
            ps.setString(3, _Address);
            ps.setString(4, Gender);
            ps.setString(5, Phone);
            ps.setString(6, Email);
            ps.setDate(7, Date_of_birth);
            ps.setString(8, _UserName);
            ps.setString(9, _Password);
            ps.setInt(10, 0);
            ps.setString(11, RoleID);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public String create_New_ID() {

        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String result = null;
        int max = 0;
        String sql = "SELECT UserID FROM  tblUser WHERE RoleID = 'User012' ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int check = Integer.parseInt(rs.getString(1).split("USER")[1]);
                if (max < check) {
                    max = check;
                }
            }
            max++;
            result = "USER" + max;

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;

    }

    public boolean update_User_Data(String uid, String FullName, String _Address, String Gender, String Phone, String Email, Date Date_of_birth, String _Password, int point, String RoleID) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = "UPDATE tblUser\n"
                + "   SET \n"
                + "      [FullName] = ?\n"
                + "      ,[_Address] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Date_of_birth] = ? \n"
                + "      ,[_PassWord] = ?\n"
                + "      ,[_Point] = ?\n"
                + "      ,[RoleID] = ?\n"
                + " WHERE UserID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, FullName);
            ps.setString(2, _Address);
            ps.setString(3, Gender);
            ps.setString(4, Phone);
            ps.setString(5, Email);
            ps.setDate(6, Date_of_birth);
            ps.setString(7, _Password);
            ps.setInt(8, point);
            ps.setString(9, RoleID);
            ps.setString(10, uid);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
        }
        return result;
    }

//    public boolean Delete_User(String ) {
//        String RoleID = "User012";
//        boolean result = false;
//        if ("Admin012".equals(RoleID)) {
//            return result;
//        }
//        GetConnection cn = new GetConnection();
//        Connection conn = cn.getConnection();
//        String sql = "DELETE FROM tblUser Where UserID = ? and RoleID = ?";
//
//        try {
//            try (PreparedStatement ps = conn.prepareStatement(sql)) {
//                ps.setString(1, "USER004");
//                ps.setString(2, RoleID);
//                if (ps.executeUpdate() > 0) {
//                    result = true;
//                }
//            }
//            conn.close();
//        } catch (SQLException e) {
//        }
//        return result;
//    }

}
