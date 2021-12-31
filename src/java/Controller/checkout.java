/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Product;
import Entity.User;
import Entity.voucher;
import Model.product_model;
import Model.user_Model;
import Model.voucher_Model;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {

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
        // Lay thong tin trong cart +
        HttpSession session = request.getSession();
        List<Product> list = new ArrayList<>();
        product_model pm = new product_model();
        if (session.getAttribute("cart") == null) {
            response.sendRedirect("shop-cart.jsp");
        }
        list = (ArrayList<Product>) session.getAttribute("cart");
        if (list.isEmpty()) {
            response.sendRedirect("shop-cart.jsp");
        }

        // tinh tien 
        int count = 0;
        double total = 0;
        for (Product o : list) {
            total = total + o.getTake() * o.getpPrice();
            count = count + o.getTake();
        }
        double sum = total;
        double vat = total * 0.1;
        total = total + vat;

        //lay du lieu ng dung 
        if (session.getAttribute("use") != null) {
            String userid = session.getAttribute("use").toString();
            // hien thong tin nguoi dung 
            user_Model um = new user_Model();
            User us = um.search_User_Data(userid);
            String[] address = us.getAddress().split(";");

            request.setAttribute("address", address);
            request.setAttribute("userinfo", us);
            //xu ly voucher
            String vouid = request.getParameter("vouid");
            if (null != vouid) {
                // lay du lieu voucher ma nguoi dung da nhap
                voucher_Model vm = new voucher_Model();
                voucher vs = vm.get_voucher(vouid);
                request.setAttribute("vou", vs);
                total = total - vs.getVouValues();
                if (total <= 0) {
                    total = 1;
                }

            }
        }

        request.setAttribute("list", list);
        request.setAttribute("sum", sum);

        request.setAttribute("total", total);
        request.setAttribute("vat", vat);
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
