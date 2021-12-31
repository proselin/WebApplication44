/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Product;
import Entity.rate;
import Model.product_model;
import Model.rate_model;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
@WebServlet(name = "product", urlPatterns = {"/product"})
public class product_controller extends HttpServlet {

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
        if (ac.equals("doshowdetail")) {
            try {
                product_model pm = new product_model();
                String pid = request.getParameter("pid");
                rate_model rm = new rate_model();
                Product pr = pm.get_product_info(pid);
                ArrayList<rate> rt = rm.doShow(pid);

                ArrayList<Integer> ratecount = new ArrayList<>();

                int star1 = 0;
                int star2 = 0;
                int star3 = 0;
                int star4 = 0;
                int star5 = 0;
                int total = 0;

                for (int i = 0; i < rt.size(); i++) {
                    if (rt.get(i).getRateStar() == 1) {
                        star1++;
                        total++;
                    }
                    if (rt.get(i).getRateStar() == 2) {
                        star2++;
                        total += 2;
                    }
                    if (rt.get(i).getRateStar() == 3) {
                        star3++;
                        total += 3;
                    }
                    if (rt.get(i).getRateStar() == 4) {
                        star4++;
                        total += 4;
                    }
                    if (rt.get(i).getRateStar() == 5) {
                        star5++;
                        total += 5;
                    }
                }
                int size = rt.size();

                ratecount.add(size);
                ratecount.add(star1);
                ratecount.add(star2);
                ratecount.add(star3);
                ratecount.add(star4);
                ratecount.add(star5);
                ratecount.add(total);

                double percent1 = (double) star1;
                double percent2 = (double) star2;
                double percent3 = (double) star3;
                double percent4 = (double) star4;
                double percent5 = (double) star5;
                double totald = (double) total;
                double sized = (double) size;

                ArrayList<Double> percentofrating = new ArrayList<>();
                if (total == 0) {
                    percentofrating.add(0.0);
                } else {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    percentofrating.add(totald / sized);
                    pm.update_product(pid,
                            pr.getpName(),
                            pr.getpPrice(),
                            pr.getpDes(),
                            pr.getpCurrent_Quantity(),
                            pr.getpYear(),
                            pr.getpBrand(),
                            pr.getpGender(),
                            pr.getpIncense(),
                            pr.getpMadeIn(),
                            pr.getpStatus(),
                            (int) (totald / sized));
                }

                percentofrating.add((percent1 / size) * 100);
                percentofrating.add((percent2 / size) * 100);
                percentofrating.add((percent3 / size) * 100);
                percentofrating.add((percent4 / size) * 100);
                percentofrating.add((percent5 / size) * 100);

                pr = pm.get_product_info(pid);
                System.out.println(pr.toString());
                request.setAttribute("ratecount", ratecount);
                request.setAttribute("percent", percentofrating);
                request.setAttribute("product_infor", pr);
                request.setAttribute("product_rate", rt);
                if (request.getAttribute("success") != null) {
                    request.setAttribute("success", request.getAttribute("success"));
                }
                if (request.getAttribute("error") != null) {
                    request.setAttribute("error", request.getAttribute("error"));
                }
                request.getRequestDispatcher("product-details.jsp").forward(request, response);
            } catch (IOException | ServletException e) {
                System.out.println(e);
            }
        }
        if (ac.equals("docomment")) {

            String pid = request.getParameter("pid");
            if (request.getParameter("rating") != null && request.getParameter("comment") != null && session.getAttribute("use") != null) {
                int rating = Integer.parseInt(request.getParameter("rating"));
                String comment = request.getParameter("comment");
                String use = session.getAttribute("use").toString();

                rate_model rm = new rate_model();
                if (rm.doadd(pid, comment, rating, use)) {
                    request.setAttribute("pid", pid);
                    request.setAttribute("success", "Thank for give us rating");
                    request.getRequestDispatcher("product?ac=doshowdetail").forward(request, response);

                } else {
                    request.setAttribute("pid", pid);
                    request.setAttribute("error", "We have some error to post your comment! please try againt");
                    request.getRequestDispatcher("product?ac=doshowdetail").forward(request, response);
                }

            } else {
                response.sendRedirect("product?ac=doshowdetail&pid" + pid);
            }
        }
        if (ac.equals("dodelcomment")) {
            if (session.getAttribute("use") != null) {
                String pid = request.getParameter("pid");
                String rateid = request.getParameter("rateid");

                rate_model rm = new rate_model();
                rm.doDelete(rateid);
//                if (rm.doDelete(rateid)) {
//                    request.setAttribute("success", "Delete success");
//                } else {
//                    request.setAttribute("Fail", "Something has wrong while remove your comment please contract our staff");
//                }
                response.sendRedirect("product?ac=doshowdetail&pid=" + pid);

            }

        }
        if (ac.equals("doshow")) {
            try {
                int index;

                if (request.getParameter("index") != null) {
                    index = Integer.parseInt(request.getParameter("index"));

                } else {
                    index = 1;
                }
                int tag = index;
                index = (index - 1) * 9;
                product_model pm = new product_model();
                int size = pm.get_all_product().size();
                int endpage = size / 9;
                if (size % 9 != 0) {
                    endpage++;
                }
                List<String> brendname = pm.brandname();
                ArrayList<Product> listp = pm.get_list_product(index, 9);
                brendname.size();
                request.setAttribute("product_list", listp);
                request.setAttribute("brandname", brendname);
                request.setAttribute("endpage", endpage);
                request.setAttribute("tag", tag);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            } catch (IOException | ServletException e) {
                System.out.println(e);
            }
        }
        if (ac.equals("dosearch")) {
            // Do search co the search nhieu san pham 
            // thong qua cac thong tin o tren url se cung cap cac ham cho search 
            product_model pm = new product_model();
            String searchtext = "";
            String cateid = "";
            String brand = "";
            String gender = "";

            int index;
            int page;
            ArrayList<Product> prlist = new ArrayList<>();
//            ArrayList<String> link = new ArrayList<>();
            // xu ly thong tin cua product don gian 
//            if (null == request.getParameter("reset")) {
            if (request.getParameter("s") != null) {
                searchtext = request.getParameter("s");
                prlist.addAll(pm.search_product_by_pName(searchtext));
                request.setAttribute("s_search", searchtext);
//                    link.add("searchtext:"+searchtext);
            }
            if (request.getParameter("cate") != null) {
                cateid = request.getParameter("cate");
                prlist.addAll(pm.search_product_by_cate(cateid));
                request.setAttribute("cate_search", cateid);
//                    link.add("cate:" +cateid);
            }
            if (request.getParameter("brand") != null) {
                brand = request.getParameter("brand");
                prlist.addAll(pm.search_product_by_brand(brand));
                request.setAttribute("brand_search", brand);
//                    link.add("brand:"+brand);
            }
            if (request.getParameter("gender") != null) {
                gender = request.getParameter("gender");
                prlist.addAll(pm.search_product_by_gender(gender));
                request.setAttribute("gender_search", gender);
//                    link.add("gender:"+gender);
            }

            if (request.getParameter("start") != null && request.getParameter("end") != null) {
                request.setAttribute("start_search", request.getParameter("start"));
                request.setAttribute("end_search", request.getParameter("end"));
                String start = request.getParameter("start").substring(1);
                String end = request.getParameter("end").substring(1);
                float priceSearchstart = Float.parseFloat(start);
                float priceSearchend = Float.parseFloat(end);
                prlist.addAll(pm.search_product_by_price(priceSearchstart, priceSearchend));
//                    link.add("price:"+start + "-" + end);
//                }

            }
            if (prlist.isEmpty()) {
                request.setAttribute("error", " Empty result '" + searchtext + cateid + brand + gender + "'");
            } else {
//                for (int i = 0; i < prlist.size(); i++) {
//                    for (int j = i + 1; j < prlist.size(); j++) {
//                        if (prlist.get(i).getpID().equals(prlist.get(j).getpID())) {
//                            prlist.remove(j);
//                        }
//                    }
//                }
                request.setAttribute("success", prlist.size() + " result");
            }
            List<Product> list;
            if (request.getParameter("index") != null) {
                index = Integer.parseInt(request.getParameter("index"));
            } else {
                index = 0;
            }
            page = prlist.size() / 9;
            if (prlist.size() % 9 != 0) {
                page++;
            }
            if (prlist.size() < index + 9) {

                list = prlist.subList(index, prlist.size());
            } else {
                list = prlist.subList(index, index + 9);
            }
            List<String> brandname = pm.brandname();
            request.setAttribute("brandname", brandname);
//            request.setAttribute("link", link);
            request.setAttribute("current", index);
            request.setAttribute("page", page);
            request.setAttribute("product_list", list);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
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
