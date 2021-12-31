/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.User;
import Model.checkLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.sendMail;
import Model.user_Model;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author quoch
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

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
        String ac = request.getParameter("ac");
        checkLogin ck = new checkLogin();
        String id = ck.getMd5("useronly");
        if (ac.equals("sendEmailConfirm")) {
            sendMail sm = new sendMail();
            String emailConfirm = request.getParameter("email");
            if (!ck.checkEmail(emailConfirm).equals("")) {
                response.getWriter().write("false");
            } else {
                sm.sendRegisterConfirmEmail(emailConfirm, id);
                response.getWriter().write("true");
            }

        }
        if (ac.equals("registerNewAccount")) {
            if (request.getParameter("id").equals(id)) {
                String username = request.getParameter("username");
                String password = request.getParameter("pass");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String postCode = request.getParameter("postcode");
                String country = request.getParameter("country");
                String city = request.getParameter("city");
                String gender = request.getParameter("gender");
                String state = request.getParameter("state");
                String phone = request.getParameter("phone");
                String address = street + ";" + city + ";" + state + ";" + country + ";" + postCode;
                String date = request.getParameter("dob");
                
                
         
                String passwordhash = ck.getMd5(password);
                Date dob = Date.valueOf(date);
                user_Model um = new user_Model();
                if (um.create_New_User(name, address, gender, phone, email, dob, username, passwordhash, "User012")) {
                    response.sendRedirect("login?ac=requestLogin&usernameOrEmailOrPhone=" + username + "&pass=" + password);
                } else {
                    response.sendRedirect("register.jsp?email=" + email + "&id=" + id);
                }
            }
        }

        if (ac.equals("checkUsername")) {
            String username = request.getParameter("username");
            if (ck.checkUsername(username)) {
                response.getWriter().write("False");
            } else {
                response.getWriter().write("true");
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
