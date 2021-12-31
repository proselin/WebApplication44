<%-- 
    Document   : show_orderdetail
    Created on : Oct 25, 2021, 7:07:09 PM
    Author     : HP
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp"  />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Invoice</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Invoice</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">


                    <!-- Main content -->
                    <div class="invoice p-3 mb-3">
                        <!-- title row -->
                        <div class="row">
                            <div class="col-12">
                                <h4>
                                    <i class="fas fa-globe"></i> Charmaine

                                </h4>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- info row -->
                        <div class="row invoice-info">
                            <div class="col-sm-4 invoice-col">
                                From
                                <address>
                                    <strong>Admin, Inc.</strong><br>
                                    Cau Giay<br>
                                    Ha Noi<br>
                                    Phone: (804) 123-5432<br>
                                    Email: info@almasaeedstudio.com
                                </address>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-4 invoice-col">
                                To
                                <address>
                                    <strong>${order_info.getOrderCustommerName()}</strong><br>
                                    Street :${address[0]}<br>
                                    City/town:${address[1]}<br>
                                    State: ${address[2]}<br>
                                    Country: ${address[3]}<br>
                                    Postcode ${address[4]}<br>
                                    Phone: ${order_info.getOrderPhoneNumber()}<br>
                                    Email: ${order_info.getOrderEmailContract()}
                                </address>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-4 invoice-col">

                                <b>Order ID:</b> ${order_info.getOrderID()}<br>
                                <b>Payment Due:</b>${order_info.getOrderDate()}<br>

                                <b>Status:</b>${order_info.getOrderStatus()}
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                        <!-- Table row -->
                        <div class="row">
                            <div class="col-12 table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Qty</th>
                                            <th>Name Product</th>
                                            <th>Price</th>
                                        
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach items="${orderdetail}" var="o">

                                            <tr>
                                                <td>#</td>
                                                <td>${o.getQuantity()}</td>
                                                <td><a href="product_ad?ac=doshowdetail&pid=${o.getProduct().getpID()}">${o.getProduct().getpName()}</a></td>
                                                <td>${o.getPrice()}</td>
                                              
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                        <div class="row">
                            <!-- accepted payments column -->
                            <div class="col-6">
                                <p class="lead">Payment Methods:</p>
                                <img src="dist/img/credit/paypal2.png" alt="Paypal">
                            </div>
                            <!-- /.col -->
                            <div class="col-6">
                                <p class="lead">Amount Due 2/22/2021</p>

                                <div class="table-responsive">
                                    <table class="table">
                                        <tr>
                                            <th style="width:50%">Subtotal:</th>
                                            <td>$<fmt:formatNumber maxFractionDigits="3" value="${subtotal}" /></td>
                                        </tr>
                                        <tr>
                                            <th>Tax (10.0%)</th>
                                            <td>$<fmt:formatNumber maxFractionDigits="3" value="${tax}" /></td>
                                        </tr>
                                        <tr>
                                            <th>Shipping:</th>
                                            <td>$0.0</td>
                                        </tr>
                                        <tr>
                                            <th>Total:</th>
                                            <td>$<fmt:formatNumber maxFractionDigits="3" value="${order_info.getOrderTotalPrice()}" /></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                        <!-- this row will not appear when printing -->
                        <div class="row no-print">
                            <div class="col-12">
                                <a href="javascript:;" onclick="window.print()" class="btn btn-sm btn-white m-b-10 p-l-5"><i class="fa fa-print t-plus-1 fa-fw fa-lg"></i> Print</a>
                                <a type="button" href="order_ad?ac=doneOrder&orderid=" class="btn btn-success float-right"><i class="far fa-credit-card"></i> Confirm   
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- /.invoice -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page = "footer.jsp"  />
