/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package Controller;

import Entity.User;
import Model.user_Model;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author quoch
 */
@WebFilter(filterName = "adminAccess", urlPatterns = {"/admin/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class adminAccess implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public adminAccess() {
    }

    /**
     *
     * @param req The servlet request we are processing
     * @param res The servlet response we are creating
     * @param chain The filter chain we are processing
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        Object userIDprepare = session.getAttribute("use");
        if (userIDprepare != null) {
            String userid = userIDprepare.toString();
            user_Model um = new user_Model();
            User us = um.search_User_Data(userid);
            if (!us.getRoleID().equals("Admin012") && !us.getRoleID().equals("Staff012")) {
                response.sendRedirect("../404page.html");
            } else {
                chain.doFilter(req, res);
            }
        } else {
            response.sendRedirect("../404page.html");
        }

    }

}
