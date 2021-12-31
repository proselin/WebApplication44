/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Product;
import Entity.img;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoch
 */
public class img_model {

    public static void main(String[] args) {

    }

    public boolean add_new_image(String url, String pid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = "Insert into tblimage values (?, ? ,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, createid());
            ps.setString(2, url);
            ps.setString(3, pid);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(img_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public ArrayList<img> show_image(String pid) {
        String sql
                = "Select * from tblImage Where pID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<img> imls = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                img im = new img();
                im.setImgID(rs.getString(1));
                im.setImgURL(rs.getString(2));
                im.setpID(rs.getString(3));
                imls.add(im);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(img_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return imls;
    }

    public ArrayList<img> show_image() {
        String sql
                = "Select * from tblImage";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<img> imls = new ArrayList<>();
        try {
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                img im = new img();
                im.setImgID(rs.getString(1));
                im.setImgURL(rs.getString(2));
                im.setpID(rs.getString(3));
                imls.add(im);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(img_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return imls;
    }

    public String createid() {
        ArrayList<img> ims = show_image();
        int n = ims.size();
        return ("IMG" + (n + 1));
    }

    public boolean delete(String pid, String img) {
        boolean result = false;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "DETELE FROM tblImage WHERE imgID = ? and pID = ?";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(2, pid);
                ps.setString(1, img);
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            }
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(img_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
     public boolean replaceImg(String url, String imgid) {
        boolean result = false;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String sql = "Update tblImage set imgUrl = ? WHERE imageID = ? ";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(2, imgid);
                ps.setString(1, url);
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            }
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(img_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
}
