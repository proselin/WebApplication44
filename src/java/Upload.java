/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author quoch
 */
@WebServlet(urlPatterns = {"/admin/Upload"})
public class Upload extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public class UploadFileServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                // refines the fileName in case it is an absolute path
                fileName = new File(fileName).getName();
                System.out.println("OK");
                part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
            }
            request.setAttribute("message", "Upload File Success!");
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Extracts file name from HTTP header content-disposition
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

        public File getFolderUpload() {
            File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
            if (!folderUpload.exists()) {
                folderUpload.mkdirs();
            }
            return folderUpload;
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
