/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Order;
import Entity.User;
import Model.checkLogin;
import Model.order_model;
import Model.user_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quoch
 */
@WebServlet(name = "user_admin", urlPatterns = {"/admin/user_ad"})
public class user_admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        user_Model um = new user_Model();
        String ac = request.getParameter("ac");
        if (ac.equals("getUserList")) {
            ArrayList<User> uslist = um.User_Data();
            for (User user : uslist) {
                user.setAddresslist(user.getAddress().split(";"));
            }
            request.setAttribute("userList", uslist);
            request.getRequestDispatcher("list_user.jsp").forward(request, response);
        }
        if (ac.equals("viewUser")) {
            String userid = request.getParameter("userid");
            User us = um.search_User_Data(userid);
            order_model om = new order_model();
            String[] address = us.getAddress().split(";");
            ArrayList<Order> orlist = om.get_User_Order(us.getUserID());
            request.setAttribute("userinfo", us);
            request.setAttribute("order", orlist);
            request.setAttribute("address", address);
            request.getRequestDispatcher("view_user.jsp").forward(request, response);
        }

        if (ac.equals("edit")) {

            String password = request.getParameter("password");
            String userid = request.getParameter("userid");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String street = request.getParameter("street");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String postcode = request.getParameter("postcode");
            Date dob = Date.valueOf(request.getParameter("dob"));
            String address = street + ";" + city + ";" + state + ";" + country + ";" + postcode + "";
            
            
            checkLogin ck = new checkLogin();
            password = ck.getMd5(password);
            user_Model us = new user_Model();
            User user = us.search_User_Data(userid);
            if (!us.search_User_Data(userid).getPassword().equals(password)) {
                boolean se = us.update_User_Data(userid, user.getFullName(), address, user.getGender(), phone, email, dob, password, user.getPoint(), user.getRoleID());
                System.out.println(se);
            } else {
                boolean se = us.update_User_Data(userid, user.getFullName(), address, user.getGender(), phone, email, dob, password, user.getPoint(), user.getRoleID());
                System.out.println(se);
            }
        }
        if (ac.equals("add")) {
            String username = request.getParameter("username");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");
            checkLogin ck = new checkLogin();
            password = ck.getMd5(password);
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String roleid = request.getParameter("role");
            String phone = request.getParameter("phone");
            String street = request.getParameter("street");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String postcode = request.getParameter("postcode");
            Date dob = Date.valueOf(request.getParameter("dob"));

            String address = street + ";" + city + ";" + state + ";" + country + ";" + postcode + "";
            user_Model us = new user_Model();

            if (us.create_New_User(name, address, gender, phone, email, dob, username, password, roleid)) {
                System.out.println("true");
                response.sendRedirect("user_ad?ac=getUserList");
            } else {
                System.out.println("else");
                response.sendRedirect("add_user.jsp");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
