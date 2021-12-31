/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Order;
import Entity.orderDetail;
import Model.order_model;
import Model.product_model;
import Model.voucher_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "order_admin", urlPatterns = {"/admin/order_ad"})
public class order_admin extends HttpServlet {

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
        String ac = request.getParameter("ac");
        if (ac.equals("showInvoice")) {
            String orderid = request.getParameter("orderid");
            order_model om = new order_model();
            Order or = om.get_Order(orderid);
            voucher_Model vm = new voucher_Model();
            if (or.getVouID() != null) {
                request.setAttribute("voucher", vm.get_voucher(or.getVouID()));
            }

            product_model pm = new product_model();
            ArrayList<orderDetail> prinorder = pm.get_order_product(orderid);
            double subtotal = 0;
            for (orderDetail detail : prinorder) {
                subtotal += detail.getPrice();
            }
            double tax = (subtotal * 10) / 100;
            String[] addss = or.getOrderAddress().split(";");
            request.setAttribute("address", addss);
            request.setAttribute("subtotal", subtotal);
            request.setAttribute("tax", tax);
            request.setAttribute("order_info", or);
            request.setAttribute("orderdetail", prinorder);
            request.getRequestDispatcher("show_orderdetail.jsp").forward(request, response);
        }
        if (ac.equals("showListOrder")) {
            order_model ord = new order_model();
            List<Order> list = ord.get_All_Order();
            for (Order order : list) {
                order.setAddress(order.getOrderAddress().split(";"));
            }
            //b2: set data to jsp
            request.setAttribute("listO", list);
            request.getRequestDispatcher("list_order.jsp").forward(request, response);
        }
        if (ac.equals("doneOrder")) {
            HttpSession session = request.getSession();
            String orderid = request.getParameter("orderid");
            if (session.getAttribute("use") != null) {
                order_model om = new order_model();
                Order or = om.get_Order(orderid);
                if (session.getAttribute("use").toString().equals(or.getUserID())) {

                    System.out.println(om.upadateStatusOrder(orderid, "Done"));
                }
                response.sendRedirect("order_ad?ac=showInvoice&orderid="+orderid);
            } else {
                 response.sendRedirect("order_ad?ac=showInvoice&orderid="+orderid);
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
