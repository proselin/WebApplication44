/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Product;
import Model.checkLogin;
import Model.img_model;
import Model.product_model;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author quoch
 */
@WebServlet(name = "product_ad", urlPatterns = {"/admin/product_ad"})
public class product_ad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload(String path) {
        File folderUpload = new File(path);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        String ac = request.getParameter("ac");
        /*
        * Get Parameter from the form in the add_product.jsp 
        * Return the list_product if  can insert new product 
        * return add_product.jsp if cannot insert product
         */
        if (ac.equals("doaddad")) {
            checkLogin ck = new checkLogin();
            String pName = "";
            String pDes = "";
            String pBrand = "";
            Float pPrice = (float) 0.00;
            int pCurrent_Quantity = 0;
            int pYear = 0;
            String pIncense = "";
            String pMadeIn = "";
            String CateID = "";
            String pGender = "";

            ArrayList<String> listImageName = new ArrayList<>();

            String path = request.getServletContext().getRealPath("/img/product");
            String uploadPath = path + File.separator;
            System.out.println(uploadPath);
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            int i = 0;
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    // ... (do your job here)
                    if (fieldName.equals("pname")) {
                        pName = fieldValue;
                    }
                    if (fieldName.equals("pdes")) {
                        pDes = fieldValue;
                    }
                    if (fieldName.equals("pBrand")) {
                        pBrand = fieldValue;
                    }
                    if (fieldName.equals("pprice")) {
                        pPrice = Float.parseFloat(fieldValue);
                    }
                    if (fieldName.equals("pcurrent")) {
                        pCurrent_Quantity = Integer.parseInt(fieldValue);
                    }
                    if (fieldName.equals("pyear")) {
                        pYear = Integer.parseInt(fieldValue);
                    }
                    if (fieldName.equals("pinc")) {
                        pIncense = fieldValue;
                    }
                    if (fieldName.equals("pmadein")) {
                        pMadeIn = fieldValue;
                    }
                    if (fieldName.equals("cateid")) {
                        CateID = fieldValue;
                    }
                    if (fieldName.equals("gender")) {
                        pGender = fieldValue;
                    }

                } else {
                    File file = new File(item.getName());
                    String fileName = file.getName().trim();
                    String filePath = uploadPath + File.separator +Math.random()+fileName;
                    File storeFile = new File(filePath);
                    item.write(storeFile);
                    listImageName.add(fileName);
                    
                }
            }

            product_model pro = new product_model();
            String proid = pro.Create_product(pName, pPrice, pDes, pCurrent_Quantity, pYear, pBrand, pGender, pIncense, pMadeIn, CateID, "ok");
            if (!"".equals(proid)) {
                for (String imagename : listImageName) {
                    String url = "img/product/" + imagename;
                    img_model im = new img_model();
                    System.out.println(im.add_new_image(url, proid));
                }
                response.sendRedirect("product_ad?ac=doshowad");
            } else {
                response.sendRedirect("product_ad?ac=showAddForm");
            }
            System.out.println("Done");
        }

        if (ac.equals("doshowad")) {
            product_model pro = new product_model();
            List<Product> list = pro.get_all_product();
            //b2: set data to jsp
            request.setAttribute("listP", list);
            request.getRequestDispatcher("list_product.jsp").forward(request, response);
        }
        if(ac.equals("showAddForm")){
            product_model pm = new product_model();
            List<String> listBrand  = pm.brandname();
            request.setAttribute("listbrand", listBrand);
            request.getRequestDispatcher("add_product.jsp").forward(request, response);
        }

        if (ac.equals("doupdate")) {
            String pID = request.getParameter("pid");
            String pName = request.getParameter("pname");
            String pDes = request.getParameter("pdes");
            String pBrand = request.getParameter("pbrand");
            Float pPrice = Float.parseFloat(request.getParameter("pprice"));
            int pCurrent_Quantity = Integer.parseInt(request.getParameter("pcurrent"));
            int pYear = Integer.parseInt(request.getParameter("pyear"));
            String pIncense = request.getParameter("pinc");
            String pGender = request.getParameter("gender");
            String pMadeIn = request.getParameter("pmadein");
            String status = request.getParameter("status");

            product_model pro = new product_model();
            int pros = pro.get_product_info(pID).getpRate_Count();

            if (pro.update_product(pID,
                    pName,
                    pPrice,
                    pDes,
                    pCurrent_Quantity,
                    pYear,
                    pBrand,
                    pGender,
                    pIncense,
                    pMadeIn,
                    status,
                    pros)) {
                response.sendRedirect("product_ad?ac=doshowad");
            } else {
                response.sendRedirect("product_ad?pid="+pID+"&ac=doshowdetail");
            }
        }
        if (ac.equals("showFormEditImage")) {
            String id = request.getParameter("pid");
            product_model pro = new product_model();
            Product p = pro.get_product_info(id);
            request.setAttribute("detail", p);
            request.getRequestDispatcher("edit_product_image.jsp").forward(request, response);
        }
        if (ac.equals("doshowdetail")) {
            String id = request.getParameter("pid");
            product_model pro = new product_model();
            Product p = pro.get_product_info(id);

            request.setAttribute("detail", p);
            request.getRequestDispatcher("update_product.jsp").forward(request, response);
        }
        if (ac.equals("updateSelectedImage")) {
            String imgId = "";
            String pid = "";
            String url = "";
            String path = request.getServletContext().getRealPath("/img/product");
            String uploadPath = path + File.separator;
            System.out.println(uploadPath);
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            int i = 0;
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    // ... (do your job here)
                    if (fieldName.equals("imageid")) {
                        imgId = fieldValue;
                    }
                    if (fieldName.equals("pid")) {
                        pid = fieldValue;
                    }
                    System.out.println(fieldName +fieldValue);

                } else {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + Math.random()+fileName;
                    File storeFile = new File(filePath);
                    item.write(storeFile);
                    url = "img/product/" + fileName;
                }
                
            }
            System.out.println(url);
            img_model im = new img_model();
            if (im.replaceImg(url, imgId)) {
                response.sendRedirect("product_ad?ac=showFormEditImage&pid=" + pid);
                System.out.println("ok");
            } else {
                response.sendRedirect("product_ad?ac=showFormEditImage&pid=" + pid);
                System.out.println("fail");
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
        } catch (FileUploadException ex) {
            Logger.getLogger(product_ad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(product_ad.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (FileUploadException ex) {
            Logger.getLogger(product_ad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(product_ad.class.getName()).log(Level.SEVERE, null, ex);
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
