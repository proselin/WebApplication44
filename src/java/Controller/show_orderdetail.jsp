<%-- 
    Document   : show_orderdetail
    Created on : Oct 25, 2021, 7:07:09 PM
    Author     : HP
--%>

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
                    <div class="callout callout-info">
                        <h5><i class="fas fa-info"></i> Note:</h5>
                        This page has been enhanced for printing. Click the print button at the bottom of the invoice to test.
                    </div>


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
                                    ${order_info.getOrderAddress()}<br>
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
                                            <th>View</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach items="${de}" var="o">

                                            <tr>
                                                <td>#</td>
                                                <td>${o.getQuantity()}</td>
                                                <td>${o.getProduct().getpName()}</td>
                                                <td>${o.getPrice()}</td>
                                                <td><a href="load_order">Detail</a></td>
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
                                            <td>$250.30</td>
                                        </tr>
                                        <tr>
                                            <th>Tax (9.3%)</th>
                                            <td>$10.34</td>
                                        </tr>
                                        <tr>
                                            <th>Shipping:</th>
                                            <td>$5.80</td>
                                        </tr>
                                        <tr>
                                            <th>Total:</th>
                                            <td>$265.24</td>
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
                                <button type="button" class="btn btn-success float-right"><i class="far fa-credit-card"></i> Confirm   
                                </button>
                                <button type="button" class="btn btn-primary float-right" style="margin-right: 5px;">
                                    <i class="fas fa-download"></i> Generate PDF
                                </button>
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
