/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.order_model;
import java.io.IOException;
import java.io.PrintWriter;
import Entity.*;
import Model.product_model;
import Model.user_Model;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "payment", urlPatterns = {"/payment"})
public class payment extends HttpServlet {

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
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String address = request.getParameter("address");
        String towncity = request.getParameter("towncity");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String des = request.getParameter("des");
        Float total = Float.parseFloat(request.getParameter("total"));
        String addresss = address + ";" + towncity + ";" + state + ";" + country + ";" + postcode;
        String payment = request.getParameter("payment");
        
        double subtotal = Double.parseDouble(request.getParameter("sum"));
        
        order_model om = new order_model();
        
        Order or = null;

        if (session.getAttribute("use") == null) {
            if ("pay".equals(payment)) {
                or = new Order(des, addresss, name, email, phone, total, payment, null, null);
            } else {
                or = new Order(des, addresss, name, email, phone, total, payment, null, null);
                session.setAttribute("order", or);
            }
            
        } else {
            String userid = session.getAttribute("use").toString();
            if (request.getParameter("vouid") != null) {
                if ("pay".equals(payment)) {
                    or = new Order(des, addresss, name, email, phone, total, payment, userid, request.getParameter("vouid"));
                } else {
                    
                    or = new Order(des, addresss, name, email, phone, total, payment, userid, request.getParameter("vouid"));
                    session.setAttribute("order", or);
                }
                
            } else {
                if ("pay".equals(payment)) {
                    or = new Order(des, addresss, name, email, phone, total, payment, userid, null);
                } else {
                    or = new Order(des, addresss, name, email, phone, total, payment, userid, null);
                    session.setAttribute("order", or);
                }
                
            }
        }

        /* Neu nguoi dung da thuc viec thanh cong viec them order thi se duoc cong them diem hoac neu dung 
        paypal thi se duoc chuyen qua ben paypal de thuc hien viec thanh toan*/
        if (or != null) {
            user_Model um = new user_Model();
            ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cart");
            product_model pm = new product_model();

            // lay cac phan tu trong cookie ra thuc te khong can lam the nay vi o ben cart de thuc hien xu ly 
            // chi can lay ra luon cung dc 
            // tiep theo la lay gia tri cac phan tu neu su dung paypal thi khong de nguoi dung thuc hien o day
            if ("paypal".equals(payment)) {
                
                or.setSubtotal((float) subtotal);
                or.setOrderTotalPrice((float) (subtotal + subtotal * 0.1));
                request.setAttribute("orderinfo", or);
                request.setAttribute("product_list", list);
                
                request.getRequestDispatcher("auth").forward(request, response);
            }
            if ("pay".equals(payment)) {
                
                Order pre = om.create_order(or.getOrderDes(),
                        "Wait",
                        or.getOrderAddress(),
                        or.getOrderCustommerName(),
                        or.getOrderEmailContract(),
                        or.getOrderPhoneNumber(),
                        or.getOrderTotalPrice(),
                        or.getOrderPaymentMethod(),
                        or.getUserID(),
                        or.getVouID());
                
                request.setAttribute("payment", payment);
                request.setAttribute("country", country);
                request.setAttribute("address", address);
                request.setAttribute("towncity", towncity);
                request.setAttribute("state", state);
                request.setAttribute("postcode", postcode);
                request.setAttribute("orderid", pre.getOrderID());
                or.setSubtotal((float) subtotal);
                or.setTax((float)(subtotal *0.1));
                request.setAttribute("order", or);
                
                request.getRequestDispatcher("review_pay.jsp").forward(request, response);
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
