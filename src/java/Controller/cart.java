package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Entity.Product;
import Entity.voucher;
import Entity.voucher_user;
import Model.product_model;
import Model.voucher_Model;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
@WebServlet(urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     *
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        ArrayList<Product> list;
        //String of product list|| format of a product in session is : ||| pID : take |||
        if (session.getAttribute("cart") == null) {
            list = new ArrayList<>();

        } else {
            list = (ArrayList<Product>) session.getAttribute("cart");
        }

        String ac = request.getParameter("ac");

        if (ac.equals("doremove")) {
            Product pr = null;
            String id = request.getParameter("pid"); // get id from link 
            for (Product product : list) {
                if (product.getpID().equals(id)) {
                    pr = product;
                }
            }
            list.remove(pr);
            session.removeAttribute("cart");
            session.setAttribute("cart", list);

        }

        if (ac.equals("dochange")) {
            product_model pm = new product_model();
            String id = request.getParameter("pid");
            int take = Integer.parseInt(request.getParameter("take"));
            System.out.println(list);
            Product pre = null;

            if (id != null) {
                int check = 0;
                Product pr = pm.get_product_info(id);
                if (list.isEmpty()) {
                    pr.setTake(1);
                    list.add(pr);
                    check++;
                } else {
                    for (Product product : list) {
                        if (product.getpID().equals(id)) {
                            pre = product;
                            product.setTake(take);
                            pr = product;
                            check++;
                        }
                    }
                    list.remove(pre);
                    list.add(pr);
                }
                if (check == 0) {
                    pr.setTake(take);
                    list.add(pr);
                }
                System.out.println(list.size());
                session.removeAttribute("cart");
                session.setAttribute("cart", list);

                String json = new Gson().toJson(pr);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

                if (request.getParameter("redirect") != null) {
                    response.sendRedirect(request.getParameter("redirect"));
                }
            } else {
                response.sendRedirect("home");
            }
        }

        if (ac.equals("doshow")) {
            String json = new Gson().toJson(list);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (ac.equals("requestVoucher")) {
            if (null != (session.getAttribute("use"))) {
                voucher_Model vm = new voucher_Model();
                String userid = session.getAttribute("use").toString();
                ArrayList<voucher_user> listvou = vm.get_user_Voucher(userid);
                //push information of voucher to page
                String jsonlistvoucher = new Gson().toJson(listvou);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(jsonlistvoucher);
            }

            // voucher show
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
