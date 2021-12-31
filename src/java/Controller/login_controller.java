/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.checkLogin;
import Entity.User;
import Model.user_Model;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
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
@WebServlet(name = "login_controller", urlPatterns = {"/login"})
public class login_controller extends HttpServlet {

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
        String ac = request.getParameter("ac");
        if (ac.equals("requestLogin")) {
            if (session.getAttribute("use") == null) {
                String usernameOrEmailOrPhone;
                String password;
                if (request.getAttribute("usernameOrEmailOrPhone") == null) {
                    usernameOrEmailOrPhone = request.getParameter("usernameOrEmailOrPhone");
                    password = request.getParameter("pass");
                } else {
                    usernameOrEmailOrPhone = request.getAttribute("usernameOrEmailOrPhone").toString();
                    password = request.getAttribute("pass").toString();
                }
                // tao Session
                checkLogin cl = new checkLogin();
                String us = cl.checkLoginByEveryThing(usernameOrEmailOrPhone, password);
                user_Model um = new user_Model();
                if (!us.equals("")) {
                    // take the infor of user
                    session.setAttribute("use", us);
                    System.out.println(session.getAttribute("use").toString());
                    User user = um.search_User_Data(us);
                    session.setAttribute("fullname", user.getFullName());
                    
                    if ("Admin012".equals(user.getRoleID()) || "Staff012".equals(user.getRoleID())) {
                        response.sendRedirect("admin/index.jsp");
                    }
                    if ("User012".equals(user.getRoleID())) {
                        response.sendRedirect("home");
                    }
                } else {
                    response.sendRedirect("login.jsp");
                }
            } else {
                response.sendRedirect("home");
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
