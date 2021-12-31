/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import Entity.category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quoch
 */
public class cate_model {

    public category get_category(String cateid) {
        String sql = "SELECT * FROM tblCategory WHERE cateID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        category cate = new category();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cateid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cate.setCateid(cateid);
            cate.setCateName(rs.getString(2));
            cate.setCateDes(rs.getString(3));
            rs.close();
            ps.close();
            conn.close();

        }catch(SQLException e){
           Logger.getLogger(cate_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return cate;
    }
}
