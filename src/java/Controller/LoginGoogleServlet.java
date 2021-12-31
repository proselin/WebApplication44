package Controller;

import Entity.User;
import Model.checkLogin;
import Model.user_Model;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.GooglePojo;
import common.GoogleUtils;
import java.sql.Date;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);

            String email = googlePojo.getEmail();
            System.out.println(email);
            checkLogin ck = new checkLogin();
            user_Model um = new user_Model();
            String userid = ck.checkEmail(email);
            if ("".equals(userid)) {
                String name = googlePojo.getName();
                String accountid = googlePojo.getId();
                 System.out.println(name +accountid);
                java.sql.Date date = new Date(System.currentTimeMillis());
                String pass = ck.getMd5(accountid);
                System.out.println(pass);
                um.create_New_User(name, ";;;;","", "", email, date, email, pass, "User012");
                request.setAttribute("usernameOrEmailOrPhone", email);
                request.setAttribute("pass", accountid);
              
            } else {
                User us= um.search_User_Data(userid);
                System.out.println(us.toString());
                request.setAttribute("usernameOrEmailOrPhone", email);
                System.out.println(us.getPassword());
                request.setAttribute("pass", us.getPassword());
            }
            request.getRequestDispatcher("login?ac=requestLogin").forward(request, response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
