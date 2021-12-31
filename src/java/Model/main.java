/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Order;
import Entity.Product;
import Entity.User;
import Entity.category;
import Entity.rate;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicHttpRequest;

/**
 *
 * @author quoch
 */
public class main {

    public class object

    {
        ArrayList<rate> str;
    }

    public static void main(String[] args) {
        product_model pm = new product_model();
        user_Model us = new user_Model();
        img_model im = new img_model();
        cate_model cate = new cate_model();
        voucher_Model vou = new voucher_Model();
        order_model om = new order_model();
        rate_model rm = new rate_model();
        checkLogin ck = new checkLogin();
       
    }
}
