<%-- 
    Document   : invoice
    Created on : Dec 21, 2021, 2:08:18 PM
    Author     : quoch
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title> Invoice|| Charmaine</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <div class="col-md-12">
                <div class="invoice">
                    <!-- begin invoice-company -->
                    <div class="invoice-company text-inverse f-w-600">
                        <span class="pull-right hidden-print">
                            <c:if test="${use eq order_info.getUserID() && order_info.getOrderStatus() eq 'Paid' ||order_info.getOrderStatus() eq 'Wait'   }">
                            <a href="order_controller?ac=cancelOrder&orderid=${order_info.getOrderID()}" class="btn btn-sm btn-white"> Cancel Order</a>
                            </c:if>
                            <a href="javascript:;" onclick="window.print()" class="btn btn-sm btn-white m-b-10 p-l-5"><i class="fa fa-print t-plus-1 fa-fw fa-lg"></i> Print</a>
                        </span>
                        Charmaine
                    </div>
                    <!-- end invoice-company -->
                    <!-- begin invoice-header -->
                    <c:set var="ord" value="${order_info}"></c:set>

                        <div class="invoice-header">
                            <div class="invoice-from">
                                <small>from</small>
                                <address>
                                    <strong class="text-inverse">Customer</strong><br>
                                    Street Address: 123 Bach Mai<br>
                                    Country:Viet Nam <br>
                                    State: Ha Noi<br>
                                    City: Hanoi , Zip Code: 100000<br>
                                    Phone: (123) 456-7890<br>
                                    Email: Example@email
                                </address>
                            </div>
                            <div class="invoice-to">
                                <small>to</small>
                                <address class="m-t-5 m-b-5">
                                    <strong class="text-inverse">Customer</strong><br>
                                    Street Address:${address[0]}<br>
                                Country:${address[3]}<br>
                                State:${address[2]}<br>
                                City:${address[1]} , Zip Code:${address[4]}<br>
                                Phone: ${ord.orderPhoneNumber}  <br>
                                Email:${ord.orderEmailContract}
                            </address>
                        </div>
                        <div class="invoice-date">
                            <small>Invoice</small>
                            <div class="date text-inverse m-t-5"><fmt:formatDate value="${ord.orderDate}"/></div>
                            <div class="invoice-detail">
                                #${order_info.getOrderID()}<br>
                                Order Status :<strong>${ order_info.getOrderStatus()}</strong>
                            </div>
                        </div>
                    </div>
                    <!-- end invoice-header -->
                    <!-- begin invoice-content -->
                    <div class="invoice-content">
                        <!-- begin table-responsive -->
                        <div class="table-responsive">
                            <table class="table table-invoice">
                                <thead>
                                    <tr>
                                        <th>PRODUCT</th>
                                        <th class="text-center" width="10%">PRICE</th>
                                        <th class="text-center" width="10%">QUANTITY</th>
                                        <th class="text-right" width="20%">LINE TOTAL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dt" items="${orderdetail}">
                                        <tr>
                                            <td>
                                                <span class="text-inverse">${dt.getProduct().getpName()}</span><br>

                                            </td>
                                            <td class="text-center">$ ${dt.getPrice()}</td>
                                            <td class="text-center">${dt.getQuantity()}</td>
                                            <td class="text-right"> $<fmt:formatNumber value="${dt.getPrice() *dt.getQuantity()}"/></td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${voucher != null}">
                                        <tr>
                                            <td>
                                                <span class="text-inverse">${voucher.getVouName()}</span><br>
                                            </td>
                                            <td class="text-center">- ${voucher.getVouValues()}</td>
                                            <td class="text-center">1</td>
                                            <td class="text-right">- ${voucher.getVouValues()}</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                        <!-- end table-responsive -->
                        <!-- begin invoice-price -->
                        <div class="col-md-12 col-sm-12">
                            <div class="invoice-price">
                                <div class="invoice-price-left">
                                    <div class="invoice-price-row">
                                         <div class="sub-price">
                                            <small>SUBTOTAL</small>
                                            <span class="text-inverse">$ <fmt:formatNumber maxFractionDigits="3" value=" ${subtotal}"/></span>
                                        </div>
                                        <div class="sub-price">
                                            <i class="fa fa-plus text-muted"></i>
                                        </div>
                                        <div class="sub-price">
                                            <small>TAX FEE (10%)</small>
                                            <span class="text-inverse">$<fmt:formatNumber maxFractionDigits="3" value=" ${tax}"/></span>
                                        </div>
                                        <div class="sub-price">
                                            <i class="fa fa-plus text-muted"></i>
                                        </div>
                                        <div class="sub-price">
                                            <small>SHIPPING </small>
                                            <span class="text-inverse">$0.00</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="invoice-price-right">
                                    <small>TOTAL</small> <span class="f-w-600">$<fmt:formatNumber maxFractionDigits="3" value=" ${ord.getOrderTotalPrice()}"/></span>
                                </div>
                            </div>
                            <!-- end invoice-price -->
                        </div>
                    </div>
                    <!-- end invoice-content -->
                    <!-- begin invoice-note -->
                    <div class="invoice-note">
                        * Make all cheques payable to Charmain<br>
                        * For the paypal we have technical difficult so the voucher cannot apply to paypal<br>
                        * Payment is due within 30 days<br>
                        * If you have any questions concerning this invoice, contact  Nguyen Quoc Hung || quochung9401@gmail.com
                    </div>
                    <!-- end invoice-note -->
                    <!-- begin invoice-footer -->
                    <div class="invoice-footer">
                        <p class="text-center m-b-5 f-w-600">
                            THANK YOU FOR YOUR BUSINESS
                        </p>
                        <p class="text-center">
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-globe"></i> charmain.com</span>
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-phone-volume"></i> T:016-18192302</span>
                            <span class="m-r-10"><i class="fa fa-fw fa-lg fa-envelope"></i> quochung9401@gmail.com</span>
                        </p>
                    </div>
                    <!-- end invoice-footer -->
                </div>
            </div>
        </div>

        <style type="text/css">
            body{
                margin-top:20px;
                background:#eee;
            }

            .invoice {
                background: #fff;
                padding: 20px
            }

            .invoice-company {
                font-size: 20px
            }

            .invoice-header {
                margin: 0 -20px;
                background: #f0f3f4;
                padding: 20px
            }

            .invoice-date,
            .invoice-from,
            .invoice-to {
                display: table-cell;
                width: 1%
            }

            .invoice-from,
            .invoice-to {
                padding-right: 20px
            }

            .invoice-date .date,
            .invoice-from strong,
            .invoice-to strong {
                font-size: 16px;
                font-weight: 600
            }

            .invoice-date {
                text-align: right;
                padding-left: 20px
            }

            .invoice-price {
                background: #f0f3f4;
                display: table;
                width: 100%
            }

            .invoice-price .invoice-price-left,
            .invoice-price .invoice-price-right {
                display: table-cell;
                padding: 20px;
                font-size: 20px;
                font-weight: 600;
                width: 75%;
                position: relative;
                vertical-align: middle
            }

            .invoice-price .invoice-price-left .sub-price {
                display: table-cell;
                vertical-align: middle;
                padding: 0 20px
            }

            .invoice-price small {
                font-size: 12px;
                font-weight: 400;
                display: block
            }

            .invoice-price .invoice-price-row {
                display: table;
                float: left
            }

            .invoice-price .invoice-price-right {
                width: 25%;
                background: #2d353c;
                color: #fff;
                font-size: 28px;
                text-align: right;
                vertical-align: bottom;
                font-weight: 300
            }

            .invoice-price .invoice-price-right small {
                display: block;
                opacity: .6;
                position: absolute;
                top: 10px;
                left: 10px;
                font-size: 12px
            }

            .invoice-footer {
                border-top: 1px solid #ddd;
                padding-top: 10px;
                font-size: 10px
            }

            .invoice-note {
                color: #999;
                margin-top: 80px;
                font-size: 85%
            }

            .invoice>div:not(.invoice-footer) {
                margin-bottom: 20px
            }

            .btn.btn-white, .btn.btn-white.disabled, .btn.btn-white.disabled:focus, .btn.btn-white.disabled:hover, .btn.btn-white[disabled], .btn.btn-white[disabled]:focus, .btn.btn-white[disabled]:hover {
                color: #2d353c;
                background: #fff;
                border-color: #d9dfe3;
            }
        </style>

        <script type="text/javascript">

        </script>
    </body>
</html>