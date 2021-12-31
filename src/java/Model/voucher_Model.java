/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Entity.voucher;
import Entity.voucher_user;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author quoch
 */
public class voucher_Model {

    public ArrayList<voucher> show_All_Voucher() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<voucher> listvou = new ArrayList<>();
        String sql = "Select * from tblVoucher ORDER BY vouDate_Create DESC";
        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //get date from the database 
            while (rs.next()) {
                voucher vc = new voucher();
                String id = rs.getString("vouID");
                String name = rs.getString("vouName");
                float Values = rs.getFloat("vouValues");
                Date exdate = rs.getDate("vouDate_Expired");
                Date crdate = rs.getDate("vouDate_Create");
                String status = rs.getString("vouStatus");
                String rule = rs.getString("vouRule");
                vc = new voucher(id, name, Values, exdate, crdate, status, rule);
                listvou.add(vc);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
        }
        return listvou;
    }

    public ArrayList<voucher> show_All_Voucher(String uid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<voucher> listvou = new ArrayList<>();
        user_Model us = new user_Model();
        int point = us.search_User_Data(uid).getPoint();

        String sql = "Select * from tblVoucher";
        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            voucher vc;
            //get date from the database 
            while (rs.next()) {

                String id = rs.getString("vouID");
                String name = rs.getString("vouName");
                float Values = rs.getFloat("vouValues");
                Date exdate = rs.getDate("vouDate_Expired");
                Date crdate = rs.getDate("vouDate_Create");
                String status = rs.getString("vouStatus");
                String rule = rs.getString("vouRule");
                int[] x = explainrule(rule);
                if (x[0] <= point && point <= x[1] && "Available".equals(status)) {
                    vc = new voucher(id, name, Values, exdate, crdate, status, rule);
                    listvou.add(vc);
                }
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
        }
        return listvou;
    }

    public ArrayList<voucher_user> get_user_Voucher(String uid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<voucher_user> uvlist = new ArrayList<>();
        String sql = "SELECT * FROM voucher_user WHERE UserID =?";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, uid);
                ResultSet rs = ps.executeQuery();
                voucher_user vu;
                while (rs.next()) {
                    String vid = rs.getString(1);
                    String userid = rs.getString(2);
                    String status = rs.getString(3);
                    if (status.equals("Available")) {
                        vu = new voucher_user(userid, vid, status);
                        vu.setVoucher_info(get_voucher(vid));
                        uvlist.add(vu);
                    }
                }
                rs.close();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return uvlist;
    }

    public boolean check_Status_voucher(String vouid, String userid) {
        boolean result = false;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "Select _Status  "
                + "from  Voucher_user  "
                + "where UserID = ? "
                + "and vouID = ? ";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userid);
                ps.setString(2, vouid);
//            Statement st = conn.createStatement();
                ResultSet rs = ps.executeQuery();
//get String
                rs.next();
                if (rs.getString("_Status").equals("Available")) {
                    result = true;
                }
                rs.close();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;

    }

    public voucher get_voucher(String vouid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        voucher result = new voucher();
        String sql = "Select * from tblVoucher where vouID = ?";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, vouid);
                ResultSet rs = ps.executeQuery();
                rs.next();
                result.setVouID(rs.getString(1));
                result.setVouName(rs.getString(2));
                result.setVouValues(rs.getFloat(3));
                result.setVouDate_Expired(rs.getDate(4));
                result.setVouDate_Create(rs.getDate(5));
                result.setVouStatus(rs.getString(6));
                result.setVouRule(rs.getString(7));
                rs.close();
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;

    }

    public String create_id_voucher() {
        ArrayList<voucher> voulist = show_All_Voucher();
        int max = 0;
        for (voucher vo : voulist) {
            String[] in = vo.getVouID().split("VOU");
            if (max < Integer.parseInt(in[1])) {
                max = Integer.parseInt(in[1]);
            }
        }
        max++;
        return "VOU" + max;
    }

    public void use_voucher(String userid, String vouid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "Update Voucher_user set _Status =  'Unavailable' "
                + "WHERE Voucher_user.UserId = ? and Voucher_user.vouID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userid);
            ps.setString(2, vouid);
            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception ex) {

        }
    }

    public void change_status_voucher_all_user(String vouid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "Update voucher_user set _Status =  'Unavailable' "
                + "WHERE vouID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vouid);
            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean claim_vocher(String vouid, String userid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = " insert into Voucher_user "
                + "values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vouid);
            ps.setString(2, userid);
            ps.setString(3, "Available");
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public void check_status_all_voucher() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        // get date using for compare 
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        String sql = "Select vouID ,vouDate_Expired from tblVoucher where vouStatus ='Available'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Date exdate = rs.getDate("vouDate_Expired");

                if (exdate.compareTo(date) < 0) {
                    String vouid = rs.getString("vouID");
                    change_status_voucher_all_user(vouid);
                    change_status_voucher(vouid);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void change_status_voucher(String id) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "Update tblVoucher Set vouStatus = 'Unavailable' Where vouID =? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int s = ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean add_voucher(String vouID, String vouName, float vouValues, Date vouDate_Expired, String vouStatus, String vouRule) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = "Insert into tblVoucher VALUES (?,?,?,?,GETDATE(),'Available',?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vouID);
            ps.setString(2, vouName);
            ps.setFloat(3, vouValues);
            ps.setDate(4, vouDate_Expired);
            ps.setString(5, vouRule);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public int[] explainrule(String rule) {
        String[] a = rule.split(",");
        String[] point = a[0].split("point");
        String[] product = a[1].split("product");
        int[] result = new int[4];
        result[0] = Integer.parseInt(point[0]);
        result[1] = Integer.parseInt(point[1]);
        result[2] = Integer.parseInt(product[0]);
        result[3] = Integer.parseInt(product[1]);

        return result;
    }
///Rule :
//        form cua mot rule trong data base :
//        {condition user} , {condition order} 
//        Ex : "," co nghia la ap dung cho moi user va moi don hang
//            "20point1000,10product1000" co nghia la ap dung voi user co tu 20 den 100 point va don hang phai co 10 san pham , dat gia tri 1000
//    Nhung condition ve nguoi su dung va co the claim voucher : 
//    1."" ap dung cho tat ca user khong giai han
//    2.{number1} + point +{number2} la chi dinh ap dung cho nhung user co point tu number1 den number2
//    Condition ve don hang :
//    1. "" ap dung cho tat ca don hang khong gioi hang 
//    2. {number1} + product + {number2} ap dung cho don hang dat toi thieu number1 mat hang va gia tri cua don hang phai dat number2 gia tri

    public boolean delete_voucher(String vouID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
