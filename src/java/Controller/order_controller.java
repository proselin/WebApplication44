/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Order;
import Entity.Product;
import Entity.orderDetail;

import Model.order_model;
import Model.product_model;
import Model.voucher_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "order_controller", urlPatterns = {"/order_controller"})
public class order_controller extends HttpServlet {

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
        if (ac.equals("cart")) {
            product_model pm = new product_model();
            HttpSession session = request.getSession();
            String pid = request.getParameter("pid");
            int quantitytaking = Integer.parseInt(request.getParameter("quantity"));
            if (session.getAttribute("prlist") == null) {
                ArrayList<Product> prlist = new ArrayList<>();
                Product pr = pm.get_product_info(pid);
                pr.setTake(quantitytaking);
                prlist.add(pr);
                session.setAttribute("prlist", prlist);
                String url = request.getHeader("referer");
                response.sendRedirect(url);

            } else {
                ArrayList<Product> prlist = (ArrayList<Product>) session.getAttribute("prlist");
                session.removeAttribute("prlist");
                boolean st = false;
                Product pr = pm.get_product_info(pid);
                for (Product psd : prlist) {
                    if (psd.getpID().equals(pr.getpID())) {
                        psd.setTake(1 + psd.getTake());
                        st = true;
                    }
                }
                if (st == false) {
                    prlist.add(pr);
                }
                session.setAttribute("prlist", prlist);
                String url = request.getHeader("referer");
                response.sendRedirect(url);

            }
        }

        if (ac.equals("showcard")) {
            HttpSession session = request.getSession();
            ArrayList<Product> prlist = (ArrayList<Product>) session.getAttribute("prlist");
            request.setAttribute("prlist", prlist);
            request.getRequestDispatcher("shop-cart.jsp").forward(request, response);
        }
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
            request.getRequestDispatcher("invoice.jsp").forward(request, response);
        }
        if (ac.equals("cancelOrder")) {
            HttpSession session = request.getSession();
            String orderid = request.getParameter("orderid");
            if (session.getAttribute("use") != null) {
                order_model om = new order_model();
                Order or = om.get_Order(orderid);
                if (session.getAttribute("use").toString().equals(or.getUserID())) {
                    System.out.println(om.upadateStatusOrder(orderid, "Cancel"));
                }
                response.sendRedirect("order_controller?ac=showInvoice&orderid=" + orderid);
            } else {
                response.sendRedirect("order_controller?ac=showInvoice&orderid=" + orderid);
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
