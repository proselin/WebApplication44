/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Entity.*;
import Model.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author quoch
 */
@WebServlet(name = "user", urlPatterns = {"/user"})
public class user_controller extends HttpServlet {

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
        HttpSession session = request.getSession();

        if ((session.getAttribute("use") != null)) {
            String userid = session.getAttribute("use").toString();
            if (ac.equals("doshowprofile")) {
                try {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    user_Model usm = new user_Model();
                    User us = usm.search_User_Data(userid);
                    String levelprocess = "";
                    double process = (double) us.getPoint();
                    if (0 <= us.getPoint() && us.getPoint() < 100) {
                        request.setAttribute("level", "newbie");
                        process = (process / 100) * 100;
                        levelprocess = us.getPoint() + "/100";
                    }
                    if (100 <= us.getPoint() && us.getPoint() < 300) {
                        request.setAttribute("level", "Iron");
                        process = (process / 300) * 100;
                        levelprocess = us.getPoint() + "/300";
                    }
                    if (300 <= us.getPoint() && us.getPoint() < 600) {
                        request.setAttribute("level", "Silver");
                        process = (process / 600) * 100;
                        levelprocess = us.getPoint() + "/600";
                    }
                    if (600 <= us.getPoint() && us.getPoint() < 1200) {
                        request.setAttribute("level", "Gold");
                        process = (process / 1200) * 100;
                        levelprocess = us.getPoint() + "/1200";
                    }
                    if (1200 <= us.getPoint()) {
                        request.setAttribute("level", "Diamond");
                        process = 100;
                    }
                    if (us.getPoint() == 0) {
                        process = 0;
                    }

                    String[] addss = us.getAddress().split(";");
                    request.setAttribute("addressls", addss);
                    request.setAttribute("process", process);
                    request.setAttribute("user", us);
                    request.setAttribute("levelprocess", levelprocess);
                    // show orrder
                    order_model om = new order_model();
                    ArrayList<Order> orderlist = om.get_User_Order(userid);
                    ArrayList<Order> orderlistPending = new ArrayList<>();
                    ArrayList<Order> orderlistSuccess = new ArrayList<>();

                    for (Order or : orderlist) {
                        if ("Done".equals(or.getOrderStatus())) {
                            orderlistSuccess.add(or);
                        } else {
                            orderlistPending.add(or);
                        }
                    }
                    request.setAttribute("orderlistPending", orderlistPending);
                    request.setAttribute("orderlistSuccess", orderlistSuccess);
                    System.out.println(orderlistPending);
                    System.out.println(orderlistSuccess);

                    request.getRequestDispatcher("profile.jsp").forward(request, response);
                } catch (IOException | ServletException e) {
                    System.out.println(e);
                }
            }
            if (ac.equals("logout")) {
               session.removeAttribute("use");
               session.invalidate();
               request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (ac.equals("Show_voucher")) {
                voucher vou = new voucher();
                voucher_Model vm = new voucher_Model();
                ArrayList<voucher_user> listvou = vm.get_user_Voucher(userid);
                request.setAttribute("listvou", listvou);

                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }

        } else {
            response.sendRedirect("login.jsp");
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
