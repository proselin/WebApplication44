/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.User;
import Entity.voucher;
import Model.user_Model;
import Model.voucher_Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quoch
 */
@WebServlet(name = "voucher_ad", urlPatterns = {"/admin/voucher_ad"})
public class voucher_ad extends HttpServlet {

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
        if (ac.equals("view")) // show product 
        {
            try {
                voucher_Model vm = new voucher_Model();
                vm.check_status_all_voucher();
                ArrayList<voucher> vlist = vm.show_All_Voucher();
                for (voucher object : vlist) {
                    object.setVouRulelist(object.getVouRule().split(","));
                    object.setVouRuleEx(vm.explainrule(object.getVouRule()));
                }
                request.setAttribute("listVoucher", vlist);
                request.getRequestDispatcher("voucher.jsp").forward(request, response);
            } catch (IOException | ServletException e) {
                System.out.println(e);
            }

        }
        if (ac.equals("showaddform")) {
            user_Model um = new user_Model();
            
            ArrayList<User> userlist = um.User_Data();
            request.setAttribute("userlist", userlist);
            request.getRequestDispatcher("add_voucher.jsp").forward(request, response);
        }

        if ("add".equals(ac)) {
           
            String vouName = request.getParameter("vouName");
            float vouValues = Float.parseFloat(request.getParameter("vouValues"));
            String vouDate_Expired = request.getParameter("vouDate_Expired");
            String levelrule = request.getParameter("levellimit");
            String productlimit = request.getParameter("productlimit");
            String productrule = productlimit + "product500";
            String optionUserID = request.getParameter("user");
            String vouRule = levelrule + "," + productrule;
            System.out.println(vouDate_Expired + "" + vouRule + optionUserID + vouValues);
            if (!"".equals(optionUserID)) {
                vouRule += "," + optionUserID;
            }
            voucher_Model vm = new voucher_Model();
            Date date = Date.valueOf(vouDate_Expired);
            if (vm.add_voucher(vm.create_id_voucher(), vouName, vouValues, date, vouName, vouRule)) {
                ArrayList<voucher> vlist = vm.show_All_Voucher();
                request.setAttribute("listVoucher", vlist);
                response.sendRedirect("voucher_ad?ac=view");
            }
             vm.check_status_all_voucher();
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
