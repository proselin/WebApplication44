<%-- 
    Document   : login
    Created on : Nov 9, 2021, 12:20:13 AM
    Author     : quoch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="img/png" href="img/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body style="background-color: #666666;">
        <c:if test="${error != null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>SomeThings Wrong!</strong> You should check in on some of those fields below.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" Method="POST" action="login?ac=requestLogin">
                        <span class="login100-form-title p-b-43">
                            Hi! Charmaine Website
                        </span>
                        <br>


                        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="usernameOrEmailOrPhone">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Enter Username</span>
                        </div>


                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <input class="input100" type="password" name="pass">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Password</span>
                        </div>

                        <div class="flex-sb-m w-full p-t-3 p-b-32">
                            <br>
                            <div>
                                <a href="checkEmail.html" class="txt1">
                                    Register?
                                </a>
                                <br>
                                <a href="home" class="txt1">
                                  return homepage?
                                </a>
                            </div>
                        </div>


                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">
                                Login
                            </button>
                        </div>
                        <br>

                        <div class="text-center p-t-46 p-b-20">
                            <span class="txt2">
                                or sign up using
                            </span>
                        </div>


                        <div class="login100-form-social flex-c-m">
                            <button class="login100-form-social-item flex-c-m bg3 m-r-5">
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile&redirect_uri=http://localhost:8080/WebApplication3/login-google&response_type=code
                                   &client_id=145686931623-40voomh8o85h18n4146q6uihg4meu3n1.apps.googleusercontent.com&approval_prompt=force">	<i class="fa fa-google" aria-hidden="true"></i></a>
                            </button>

                        </div>
                    </form>

                    <div class="login100-more" style="background-image: url('img/bg-02.jpg');">
                    </div>
                </div>
            </div>
        </div>





        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/login.js"></script>

    </body>
</html>
