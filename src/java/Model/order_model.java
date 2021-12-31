/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;

/**
 *
 * @author quoch
 */
public class order_model {
//    public void Show_order(){}
//    public Order create_order(){}
//    public boolean update_order(){}
//    public boolean update_status_order(){}
//    public Order create_order(String userid ){}

    public boolean upadateStatusOrder(String orderid, String status) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
       
        String sql = "UPDATE tblOrder SET orderStatus =?  Where OrderID = ?";
        try {
            try (PreparedStatement preparestatement = conn.prepareStatement(sql)) {
                preparestatement.setString(1,status);
                preparestatement.setString(2, orderid);
                if (preparestatement.executeUpdate() != 0) {
                    result = true;
                }
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }
    

    public Order get_Order(String orid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        Order or = new Order();
        String sql = "SELECT * FROM tblOrder WHERE orderID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, orid);
            ResultSet rs = ps.executeQuery();
            rs.next();

            or.setOrderID(rs.getString(1));
            or.setOrderDate(rs.getDate(2));
            or.setOrderDes(rs.getString(3));
            or.setOrderStatus(rs.getString(4));
            or.setOrderAddress(rs.getString(5));
            or.setOrderCustommerName(rs.getString(6));
            or.setOrderEmailContract(rs.getString(7));
            or.setOrderPhoneNumber(rs.getString(8));
            or.setOrderTotalPrice(rs.getFloat(9));
            or.setOrderPaymentMethod(rs.getString(10));
            or.setUserID(rs.getString(11));
            or.setVouID(rs.getString(12));

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return or;
    }

    public boolean insert_Product_To_Order(String productid, String orderid, int quantity, float price) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        String sql = "INSERT INTO [dbo].[tblOrder_Detail]\n"
                + "           ([pID]\n"
                + "           ,[orderID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Current_Price])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)\n"
                + "GO";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productid);
            ps.setString(2, orderid);
            ps.setInt(3, quantity);
            ps.setFloat(4, price);

            if (ps.executeUpdate() > 0) {
                result = true;
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;

    }

    public Order create_order(String orderDes, String orderStatus, String orderAddress, String orderCustommerName, String orderEmailContract, String orderPhoneNumber, float orderTotalPrice, String orderPaymentMethod, String UserID, String vouID) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        //Create new order ;
        Order or = null;
        String sql = "INSERT INTO tblOrder "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            // time for comapre
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            //start insert
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(11, UserID);
            ps.setString(12, vouID);
            ps.setString(10, orderPaymentMethod);
            ps.setFloat(9, orderTotalPrice);
            ps.setString(8, orderPhoneNumber);
            ps.setString(7, orderEmailContract);
            ps.setString(6, orderCustommerName);
            ps.setString(5, orderAddress);
            ps.setString(4, orderStatus);
            ps.setString(3, orderDes);
            ps.setDate(2, date);
            String id = create_New_ID();
            ps.setString(1, id);

            if (ps.executeUpdate() > 0) {
                or = new Order(id, date, orderDes, orderStatus, orderAddress, orderCustommerName, orderPhoneNumber, orderTotalPrice, orderPaymentMethod, UserID, vouID);
            }
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return or;

    }

    public Order create_order(Order or) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        //Create new order ;
        Order cr = null;

        String sql = "INSERT INTO tblOrder "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            // time for comapre
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            try ( //start insert
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(11, or.getUserID());
                ps.setString(12, or.getVouID());
                ps.setString(10, or.getOrderPaymentMethod());
                ps.setFloat(9, or.getOrderTotalPrice());
                ps.setString(8, or.getOrderPhoneNumber());
                ps.setString(7, or.getOrderEmailContract());
                ps.setString(6, or.getOrderCustommerName());
                ps.setString(5, or.getOrderAddress());
                ps.setString(4, or.getOrderStatus());
                ps.setString(3, or.getOrderDes());
                ps.setDate(2, date);
                String id = create_New_ID();
                ps.setString(1, id);

                if (ps.executeUpdate() > 0) {
                    cr = new Order(id,
                            date,
                            or.getOrderDes(),
                            or.getOrderStatus(),
                            or.getOrderAddress(),
                            or.getOrderCustommerName(),
                            or.getOrderPhoneNumber(),
                            or.getOrderTotalPrice(),
                            or.getOrderPaymentMethod(),
                            or.getUserID(),
                            or.getVouID());
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cr;

    }

    public ArrayList<Order> show_All_Order() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Order> ors = new ArrayList<>();

        String sql = "SELECT * FROM tblOrder";
        try {
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderDate(rs.getDate(2));
                or.setOrderDes(rs.getString(3));
                or.setOrderStatus(rs.getString(4));
                or.setOrderAddress(rs.getString(5));
                or.setOrderCustommerName(rs.getString(6));
                or.setOrderEmailContract(rs.getString(7));
                or.setOrderPhoneNumber(rs.getString(8));
                or.setOrderTotalPrice(rs.getFloat(9));
                or.setOrderPaymentMethod(rs.getString(10));
                or.setUserID(rs.getString(11));
                or.setVouID(rs.getString(12));
                ors.add(or);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ors;
    }

    public ArrayList<Order> get_User_Order(String uid) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Order> ors = new ArrayList<>();

        String sql = "SELECT * FROM tblOrder WHERE UserID = ? ORDER BY OrderDate DESC ,OrderStatus DESC ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderDate(rs.getDate(2));
                or.setOrderDes(rs.getString(3));
                or.setOrderStatus(rs.getString(4));
                or.setOrderAddress(rs.getString(5));
                or.setOrderCustommerName(rs.getString(6));
                or.setOrderEmailContract(rs.getString(7));
                or.setOrderPhoneNumber(rs.getString(8));
                or.setOrderTotalPrice(rs.getFloat(9));
                or.setOrderPaymentMethod(rs.getString(10));
                or.setUserID(rs.getString(11));
                or.setVouID(rs.getString(12));
                ors.add(or);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ors;
    }

    public boolean update_order(String orderid, String orderDes, String orderStatus, String orderAddress, String orderEmailContract, String orderPhoneNumber) {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        boolean result = false;
        //Create new order ;
        String sql = "UPDATE [dbo].[tblOrder]\n"
                + "   SET \n"
                + "      [orderDes] = ?\n"
                + "      ,[orderStatus] = ?\n"
                + "      ,[orderAddress] = ?\n"
                + "      ,[orderEmailContract] = ?\n"
                + "      ,[orderPhoneNumber] = ?\n"
                + " WHERE \n"
                + "      [orderID] = ?";
        try {
            // time for comapre
            //start insert
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, orderid);
            ps.setString(5, orderPhoneNumber);
            ps.setString(4, orderEmailContract);
            ps.setString(3, orderAddress);
            ps.setString(2, orderStatus);
            ps.setString(1, orderDes);

            if (ps.executeUpdate() != 0) {
                result = true;
            }
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(order_model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public String create_New_ID() {
        ArrayList<Order> or = show_All_Order();
        int max = 0;
        for (Order order : or) {
            int check = Integer.parseInt(order.getOrderID().split("ORDER")[1]);
            if (check > max) {
                max = check;
            }
        }
        return "ORDER" + (max + 1);
    }

    public ArrayList<Order> get_All_Order() {
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        ArrayList<Order> ors = new ArrayList<>();

        String sql = "SELECT * FROM tblOrder";
        try {
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderDate(rs.getDate(2));
                or.setOrderDes(rs.getString(3));
                or.setOrderStatus(rs.getString(4));
                or.setOrderAddress(rs.getString(5));
                or.setOrderCustommerName(rs.getString(6));
                or.setOrderEmailContract(rs.getString(7));
                or.setOrderPhoneNumber(rs.getString(8));
                or.setOrderTotalPrice(rs.getFloat(9));
                or.setOrderPaymentMethod(rs.getString(10));
                or.setUserID(rs.getString(11));
                or.setVouID(rs.getString(12));
                ors.add(or);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ors;
    }
}
