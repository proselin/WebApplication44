/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author quoch
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entity.Product;
import Entity.category;
import Entity.img;
import Entity.orderDetail;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class product_model {

    public ArrayList<Product> search_product_by_pName(String search) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE pName LIKE ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> search_product_by_gender(String gender) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE pGender = ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gender);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> search_product_by_price(float start, float end) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE pPrice > ? AND pPrice< ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, start);
            ps.setFloat(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> search_product_by_cate(String cate) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE CateID = ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> search_product_by_brand(String brandname) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE pbrand = ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, brandname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }
    
      public ArrayList<Product> search_product_by_Status(String status) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT * FROM tblproduct WHERE pStatus = ? ORDER BY pGet_Date DESC , pID DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<orderDetail> get_order_product(String orderid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<orderDetail> detail = new ArrayList();
        
        String sql = "SELECT * FROM tblOrder_Detail WHERE orderid = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, orderid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                orderDetail dt = new orderDetail();
                dt.setOrderid(rs.getString(2));
                dt.setPid(rs.getString(1));
                dt.setPrice(rs.getFloat(4));
                dt.setQuantity(rs.getString(3));
                dt.setProduct(get_product_info(rs.getString(1)));
                detail.add(dt);
            }
        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return detail;
    }

    public ArrayList<Product> get_all_product() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        
        String sql = "SELECT * FROM tblproduct ORDER by pGet_Date DESC";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);

                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> get_list_product(int offset, int fetch) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Product> pro = new ArrayList();
        String sql = "SELECT *\n"
                + "\n"
                + "FROM tblProduct WHERE pStatus = 'Available'\n"
                + "ORDER BY pGet_Date DESC  , pid DESC\n"
                + "OFFSET ?  ROWS FETCH NEXT ? ROWS ONLY ";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, offset);
            st.setInt(2, fetch);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                String id = rs.getString(1);
                p.setpID(id);
                p.setpName(rs.getString(2));
                p.setpPrice(rs.getFloat(3));
                p.setpDes(rs.getString(4));
                p.setpSale_Quantity(rs.getInt(5));
                p.setpCurrent_Quantity(rs.getInt(6));
                p.setpYear(rs.getInt(7));
                p.setpGet_Date(rs.getDate(8));
                p.setpBrand(rs.getString(9));
                p.setpGender(rs.getString(10));
                p.setpIncense(rs.getString(11));
                p.setpMadeIn(rs.getString(12));
                p.setpRate_Count(rs.getInt(13));
                p.setpStatus(rs.getString(14));
                p.setCateID(rs.getString(15));
                cate_model cs = new cate_model();
                category ca = cs.get_category(rs.getString(15));
                p.setCateinfo(ca);
                img_model img = new img_model();
                p.setImgs(img.show_image(id));
                pro.add(p);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public boolean Create_product(String pName, Float pPrice, String pDes, int pCurrent_Quantity, int pYear, String pBrand, String pGender, String pIncense, String pMadeIn, String cateID) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String sql = "INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, create_id_product());
            ps.setString(2, pName);
            ps.setFloat(3, pPrice);
            ps.setString(4, pDes);
            ps.setInt(5, 0);
            ps.setInt(6, pCurrent_Quantity);
            ps.setInt(7, pYear);
            ps.setDate(8, date);
            ps.setString(9, pBrand);
            ps.setString(10, pGender);
            ps.setString(11, pIncense);
            ps.setString(12, pMadeIn);
            ps.setInt(13, 0);
            ps.setString(14, "Available");
            ps.setString(15, cateID);
            if (ps.executeUpdate() != 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
      public String Create_product(String pName, Float pPrice, String pDes, int pCurrent_Quantity, int pYear, String pBrand, String pGender, String pIncense, String pMadeIn, String cateID,String ad) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        String result = "";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String sql = "INSERT INTO tblProduct VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String id = create_id_product();
            ps.setString(1, id);
            ps.setString(2, pName);
            ps.setFloat(3, pPrice);
            ps.setString(4, pDes);
            ps.setInt(5, 0);
            ps.setInt(6, pCurrent_Quantity);
            ps.setInt(7, pYear);
            ps.setDate(8, date);
            ps.setString(9, pBrand);
            ps.setString(10, pGender);
            ps.setString(11, pIncense);
            ps.setString(12, pMadeIn);
            ps.setInt(13, 0);
            ps.setString(14, "Available");
            ps.setString(15, cateID);
            if (ps.executeUpdate() != 0) {
               result = id;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public boolean update_product(String pID, String pName, Float pPrice, String pDes, int pCurrent_Quantity, int pYear, String pBrand, String pGender, String pIncense, String pMadeIn, String pStatus, int pRate_Count) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = "UPDATE [dbo].[tblProduct]\n"
                + "   SET \n"
                + "      [pName] = ?\n"
                + "      ,[pPrice] = ?\n"
                + "      ,[pDes] = ?\n"
                + "      ,[pCurent_Quantity] = ?\n"
                + "      ,[pYear] = ? \n"
                + "      ,[pBrand] = ?\n"
                + "      ,[pGender] = ?\n"
                + "      ,[pIncense] = ?\n"
                + "      ,[pMadeIn] = ?\n"
                + "      ,[pStatus] = ?\n"
                + "      ,[pRate_Count] = ?\n"
                + " WHERE pID = ?  ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pName);
            ps.setFloat(2, pPrice);
            ps.setString(3, pDes);
            ps.setInt(4, pCurrent_Quantity);
            ps.setInt(5, pYear);
            ps.setString(6, pBrand);
            ps.setString(7, pGender);
            ps.setString(8, pIncense);
            ps.setString(9, pMadeIn);
            ps.setString(10, pStatus);
            ps.setInt(11, pRate_Count);
            ps.setString(12, pID);
            if (ps.executeUpdate() != 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public String create_id_product() {
        ArrayList<Product> prlist = get_all_product();
        ArrayList<Integer> id = new ArrayList<>();
        int pre = 0;
        for (Product pr : prlist) {
            String[] in = pr.getpID().split("PRO");
            if (pre < Integer.parseInt(in[1])) {
                pre = Integer.parseInt(in[1]);
            }
        }
        pre += 1;
        return "PRO" + pre;
    }

    public List<String> brandname() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        List<String> rsl = new ArrayList<String>();
        String sql = "SELECT COUNT(pID), pBrand FROM tblProduct\n"
                + "GROUP BY pBrand \n"
                + "ORDER BY COUNT(pID) DESC";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rsl.add(rs.getString(2));

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return rsl;
    }

    public Product get_product_info(String productId) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        Product p = new Product();
        String sql = "Select * from tblProduct Where pID =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            //get data
            rs.next();
            String id = rs.getString(1);
            p.setpID(id);
            p.setpName(rs.getString(2));
            p.setpPrice(rs.getFloat(3));
            p.setpDes(rs.getString(4));
            p.setpSale_Quantity(rs.getInt(5));
            p.setpCurrent_Quantity(rs.getInt(6));
            p.setpYear(rs.getInt(7));
            p.setpGet_Date(rs.getDate(8));
            p.setpBrand(rs.getString(9));
            p.setpGender(rs.getString(10));
            p.setpIncense(rs.getString(11));
            p.setpMadeIn(rs.getString(12));
            p.setpRate_Count(rs.getInt(13));
            p.setpStatus(rs.getString(14));
            cate_model cs = new cate_model();
            category ca = cs.get_category(rs.getString(15));
            p.setCateinfo(ca);
            img_model img = new img_model();
            p.setImgs(img.show_image(id));

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return p;
    }

    public boolean take_Product(String id, int quantity) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        //check current quantity
        String sql = "Update tblProduct Set pCurent_quantity = ?,pSale_Quantity=? Where pID =?";
        try {
            Product pr = get_product_info(id);
            int sale = pr.getpSale_Quantity() + quantity;
            int check = pr.getpCurrent_Quantity() - quantity;

            if (check > 0) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, check);
                ps.setInt(2, sale);
                ps.setString(3, id);

                if (ps.executeUpdate() > 0) {
                    result = true;
                }
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;

    }

    public boolean set_Product_to_order(String id, String pid, int quantity, float price) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        //check current quantity
        boolean result = false;
        String sql = " INSERT INTO tblOrder_detail VALUES (?,?,?,?)";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setString(2, id);
            ps.setInt(3, quantity);
            ps.setFloat(4, price);

            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);

        }
        return result;

    }

    public boolean add_New_Quantity_Product(String id, int quantity) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        //check current quantity
        String sql = "Update tblProduct Set pCurent_quantity = pCurent_quantity + ? Where pID =?";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);

            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();;
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(product_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;

    }

}
