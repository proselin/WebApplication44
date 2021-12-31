<%-- 
    Document   : index
    Created on : Oct 13, 2021, 10:39:00 AM
    Author     : HP
--%>

<%@page import="Entity.User"%>
<%@page import="Model.user_Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
   <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AdminLTE 3 | DataTables</title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
        <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
    </head>
    <body class="hold-transition sidebar-mini layout-fixed">


            <!-- Preloader -->


            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="index.jsp" class="nav-link">Home</a>
                    </li>
                </ul>

                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">


                    <li class="nav-item">
                        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                            <i class="fas fa-expand-arrows-alt"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="index3.html" class="brand-link">

                    <span class="brand-text font-weight-light">Charmaine website</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="info">
                            <a href="#" class="d-block">Hi! ${sessionScope.Fullname}</a>
                        </div>
                    </div>


                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->
                            <li class="nav-item">
                                <a href="#" class="nav-link active">
                                    <i class="nav-icon fas fa-tachometer-alt"></i>
                                    <p>
                                        Home
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="./index.jsp" class="nav-link ">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Home</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-users"></i>
                                    <p>
                                        User Management
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="user_ad?ac=getUserList" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>List User</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="add_user.jsp" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Add User</p>
                                        </a>
                                    </li>  
                                </ul>
                            </li>


                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-th"></i>
                                    <p>
                                        Product Management
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="product_ad?ac=doshowad" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>List Product</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="product_ad?ac=showAddForm" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Add product</p>
                                        </a>
                                    </li>

                                </ul>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-shopping-cart"></i>
                                    <p>
                                        Order Management
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="order_ad?ac=showListOrder" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>List Order</p>
                                        </a>
                                    </li> 
                                </ul>
                            </li>



                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon far fa-envelope"></i>
                                    <p>
                                        Comment Management
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="comment_admin?ac=doshow" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>View comment</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nav-icon fas fa-book"></i>
                                    <p>
                                        Voucher management
                                        <i class="fas fa-angle-left right"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="voucher_ad?ac=view" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>List voucher</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="voucher_ad?ac=showaddform" class="nav-link">
                                            <i class="far fa-circle nav-icon"></i>
                                            <p>Add voucher</p>
                                        </a>
                                    </li>

                                </ul>
                            </li>

                        </ul>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>
