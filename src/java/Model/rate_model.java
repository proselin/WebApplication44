/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.rate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quoch
 */
public class rate_model {

    public ArrayList<rate> doShow(String productid) {
        GetConnection cn = new GetConnection();
        ArrayList<rate> rtlist = new ArrayList<>();
        Connection conn = cn.getConnection();
        String sql = "SELECT tblRate.* ,tblProduct.pName , tblUser.FullName , tblUser._Point  FROM tblRate , tblProduct , tblUser\n"
                + "WHERE tblRate.UserID = tblUser.UserID AND tblProduct.pID = tblRate.pID AND tblRate.pID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rate rt = new rate(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(6),
                        rs.getInt(9)
                );
                rtlist.add(rt);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return rtlist;
    }
    

    public boolean doadd(String productid, String comment, int rateStar, String userid) {
        GetConnection cn = new GetConnection();
        boolean rt = false;
        Connection conn = cn.getConnection();
        String sql = "INSERT INTO [dbo].[tblRate]\n"
                + "           ([rateID]\n"
                + "           ,[rateStar]\n"
                + "           ,[Comment]\n"
                + "           ,[pID]\n"
                + "           ,[UserID]\n"
                + "           ,[_date])\n"
                + "     VALUES (?,?,?,?,?,?)";
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, create_id());
            ps.setInt(2, rateStar);
            ps.setString(3, comment);
            ps.setString(4, productid);
            ps.setString(5, userid);
            ps.setDate(6, date);
            if (ps.executeUpdate() > 0 ? rt = true : false);
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return rt;
    }

    public String create_id() {
        GetConnection cn = new GetConnection();
        String rt = "RATE";
        int max = 0;
        Connection conn = cn.getConnection();
        String sql = "SELECT * FROM tblRate";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String first = rs.getString(1);
                int check = Integer.parseInt(first.split("RATE")[1]);
                if(max < check ){
                    max = check;
                }
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        max ++;
        return rt + max;

    }

    public boolean doDelete(String rateid) {
        GetConnection cn = new GetConnection();
        boolean rt = false;
        Connection conn = cn.getConnection();
        String sql = "DELETE FROM tblRate WHERE rateID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rateid);
            if (ps.executeUpdate() > 0 ? rt = true : false);
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rt;
    }

    public ArrayList<rate> get_all_rate() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<rate> rtlist = new ArrayList();

        String sql = "SELECT tblRate.* ,tblProduct.pName , tblUser.FullName , tblUser._Point  FROM tblRate , tblProduct , tblUser\n"
                + "WHERE tblRate.UserID = tblUser.UserID AND tblProduct.pID = tblRate.pID";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rate rt = new rate(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(6),
                        rs.getInt(9)
                );
                rtlist.add(rt);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return rtlist;
    }
}
