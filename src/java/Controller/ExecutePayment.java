/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Order;
import Entity.Product;
import Entity.User;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PaymentServices;
import Model.order_model;
import Model.product_model;
import Model.sendMail;
import Model.user_Model;
import com.paypal.api.payments.Payer;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quoch
 */
@WebServlet(name = "ExecutePayment", urlPatterns = {"/execute_payment"})
public class ExecutePayment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws com.paypal.base.rest.PayPalRESTException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PayPalRESTException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");

        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        PaymentServices paymentServices = new PaymentServices();
        Payment payment = paymentServices.executePayment(paymentId, payerId);
        PayerInfo payerInfo = payment.getPayer().getPayerInfo();
        Transaction transaction = payment.getTransactions().get(0);

        HttpSession session = request.getSession();

        Order or = (Order) session.getAttribute("order");
        order_model om = new order_model();
        or.setOrderStatus("Paid");
        Order cr = om.create_order(or);
        if (or == null) {
            response.sendRedirect("checkout");

        } else {
            String rid = cr.getOrderID();
            String uid = cr.getUserID();

            user_Model um = new user_Model();

            product_model pm = new product_model();
            ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cart");
            for (Product p : list) {
                pm.take_Product(p.getpID(), p.getTake());
                pm.set_Product_to_order(rid, p.getpID(), p.getTake(), p.getpPrice());
            }

            if (uid != null) {

                int point = (int) cr.getOrderTotalPrice();
                point = point * 1 / 4;
                User u = um.search_User_Data(uid);
                sendMail send = new sendMail();
                send.sendOrderLink(cr.getOrderEmailContract(), cr.getOrderID());
                um.update_User_Data(u.getUserID(),
                        u.getFullName(),
                        u.getAddress(),
                        u.getGender(),
                        u.getPhone(),
                        u.getEmail(),
                        u.getDate_of_birth(),
                        u.getPassword(),
                        u.getPoint() + point,
                        u.getRoleID());

            }
            session.removeAttribute("order");
            session.removeAttribute("cart");
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);
            request.getRequestDispatcher("receipt.jsp").forward(request, response);
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
        } catch (PayPalRESTException ex) {
            Logger.getLogger(ExecutePayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ExecutePayment.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (PayPalRESTException ex) {
            Logger.getLogger(ExecutePayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ExecutePayment.class.getName()).log(Level.SEVERE, null, ex);
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
