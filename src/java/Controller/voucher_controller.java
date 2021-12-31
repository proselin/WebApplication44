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
import java.util.ArrayList;

/**
 *
 * @author quoch
 */
@WebServlet(name = "voucher_controller", urlPatterns = {"/vou"})
public class voucher_controller extends HttpServlet {

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
        if (null != (session.getAttribute("use"))) {
            String userid = session.getAttribute("use").toString();
            String ac = request.getParameter("ac");
            if (ac.equals("doshow")) {
                if (request.getAttribute("listvou") != null || request.getAttribute("listvuse") != null) {
                    request.removeAttribute("listvou");
                    request.removeAttribute("listvuse");
                }

                voucher_Model vm = new voucher_Model();
                vm.check_status_all_voucher();
                //voucher ma nguoi su dung dang co
                ArrayList<voucher_user> listvou = vm.get_user_Voucher(userid);
                ArrayList<voucher> listvuse = vm.show_All_Voucher(userid);
                ArrayList<voucher> os = new ArrayList<>();
                for (voucher o : listvuse) {
                    for (voucher_user b : listvou) {
                        if (o.getVouID().equals(b.getVouID())) {
                            os.add(o);
                        }
                    }
                }
                listvuse.removeAll(os);
                request.setAttribute("listv", listvou);
                request.setAttribute("listvn", listvuse);
                request.getRequestDispatcher("voucher.jsp").forward(request, response);

            }
            if (ac.equals("doadd")) {
                String id = request.getParameter("id");
                voucher_Model vm = new voucher_Model();
                vm.check_status_all_voucher();
                if (vm.check_Status_voucher(id, userid)) {
                    response.sendRedirect("vou?ac=doshow");
                } else {
                    user_Model usm = new user_Model();
                    User us = usm.search_User_Data(userid);

                    voucher csc = vm.get_voucher(id);
                    int[] rule = vm.explainrule(csc.getVouRule());
                    int point = us.getPoint();
                    //check status and check rule
                    if (csc.getVouStatus().equals("Available") && rule[0] <= point && point <= rule[1]) {
                        vm.claim_vocher(id, userid);
                    } else {
                        request.setAttribute("error", "Your account dont meet the conditions");
                    }
                    response.sendRedirect("vou?ac=doshow");
                }

            }
        } else {
            response.sendRedirect("login");
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
