<%-- 
    Document   : shop-cart
    Created on : Nov 13, 2021, 12:21:44 AM
    Author     : quoch
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp" ></jsp:include>
    <style >
        .coupon_Container{
            border: solid gray 0.001px;
            margin-top: 20px;
            overflow: hidden;

        }
        .image_coupon{
            background-color:#2FDD92;
            height: 100%;
            width: 100%
        }
        .name{
            font-size: 20px;
            margin-top: 10px

        }
        .div_col_12{
            margin-left: 10px
        }
        .button_Container{

        }
        .btn {
            width: 100%;
            height: 100%;
        }
    </style>
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.jsp"><i class="fa fa-home"></i> Home</a>
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Cart Section Begin -->
    <section class="shop-cart spad">
        <div class="container">
            <div class="row">
            <c:if test="${sessionScope.use == null}">
                <div class="col-lg-12">
                    <h6 class="coupon__link"><span class="icon_tag_alt"></span> Have a voucher?<a href="login.jsp"> Click here to login.</a></h6>
                </div>
            </c:if>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shop__cart__table">
                    <table>
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="tables">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="cart__btn">
                    <a href="#">Continue Shopping</a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="cart__btn update__btn">
                    <a href="javascript:{}" onclick="window.window.location.reload()"><span class="icon_loading"></span> Update cart</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="discount__content">
                    <h6>Discount</h6>
                    <div class="current_select_voucher"></div>


                    <c:choose>
                        <c:when test="${sessionScope.use == null}">
                            <a href="login.jsp">Please login to using the voucher</a>
                        </c:when>
                        <c:otherwise>
                            <div class="model_voucher" style="margin-top:  30px;margin-bottom: 20px">
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                                    Choosing Voucher
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">Choosing a voucher touse</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 list_voucher_can_using" >
                                                        <!-- end coupontitem -->
                                                    </div>
                                                    <div class="col-lg-12 col-md-12 col-sm-12 " id="voucher_cannot_use">
                                                        <!--<!-- end coupontitem -->
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <div class="col-lg-4 offset-lg-2">
                <div class="cart__total__procced">
                    <h6>Cart total</h6>
                    <ul>

                        <li id = "discount_value">Discount <span>$0 </span></li>
                        <li class="cart_tax_price">VAT <span>$0 </span></li>
                        <li class="cart_shipping_price">Shipping <span>$0</span></li>
                        <li class="cart_subtotal_price">Subtotal <span> $0</span></li>
                        <li class="cart_total_price">Total <span>$0 </span></li>
                    </ul>
                    <form action="checkout" method="POST" id="my_form">
                        <input type="hidden" name="vouid" value="${vouid}">
                    <a class="primary-btn" href="javascript:{}" onclick="${empty sessionScope.cart?"#":"document.getElementById('my_form').submit();"}" >Proceed to checkout </a>
                    </form>

                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Cart Section End -->



<jsp:include page="inc/footer.jsp" ></jsp:include>
<script src="js/cart.js"></script>
<script src="js/voucher.js"></script>