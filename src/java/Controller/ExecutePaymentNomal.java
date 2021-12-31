/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Order;
import Entity.Product;
import Entity.User;
import Model.order_model;
import Model.product_model;
import Model.sendMail;
import Model.user_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quoch
 */
@WebServlet(name = "ExecutePaymentNomal", urlPatterns = {"/ExecutePaymentNomal"})
public class ExecutePaymentNomal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.mail.MessagingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String oridpre = request.getParameter("orderid");
       
            order_model om = new order_model();
            Order pre = om.get_Order(oridpre);
            System.out.println(oridpre);
            HttpSession session = request.getSession();
            
            product_model pm = new product_model();
            List<Product> list =(ArrayList<Product>) session.getAttribute("cart");
            String orid = oridpre;
            /* TODO output your page here. You may use following sample code. */
           
            for (Product p : list) {
                pm.take_Product(p.getpID(), p.getTake());
                pm.set_Product_to_order(orid, p.getpID(), p.getTake(), p.getpPrice());
            }
            // phan nay de xoa cac phan tu torng cookie di 
            sendMail send = new sendMail();
            

            if (pre.getUserID() != null) {
                user_Model um = new user_Model();
                int point = (int) pre.getOrderTotalPrice();
                point = point * 1 / 4;
                User u = um.search_User_Data(pre.getUserID());
                send.sendOrderLink(u.getEmail(), orid);
                
                um.update_User_Data(u.getUserID(),
                        u.getFullName(),
                        u.getAddress(),
                        u.getGender(),
                        u.getPhone(),
                        u.getEmail(),
                        u.getDate_of_birth(),
                        u.getPassword(),
                        u.getPoint() +point,
                        u.getRoleID());
            }
            session.removeAttribute("cart");
            response.sendRedirect("home");
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ExecutePaymentNomal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ExecutePaymentNomal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
