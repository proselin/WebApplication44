<%-- 
    Document   : Checkout
    Created on : Oct 29, 2021, 2:42:57 AM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp"></jsp:include>
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="home"><i class="fa fa-home"></i> Home</a>
                        <a href="cart.jsp">Shopping cart</a>
                        <span>Checkout</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">

            <form action="payment" method="POST" class="checkout__form">
                <div class="row">
                    <div class="col-lg-8">
                        <h5>Billing detail</h5>
                        <div class="row">
                        <c:choose>
                            <c:when test="${userinfo !=null}">
                                <c:set var="ad" value="${address}"/>
                                <c:set var="u" value="${userinfo}"/>
                                <div class="col-lg-12">
                                    <div class="checkout__form__input">
                                        <p>Name <span>*</span></p>
                                        <input type="text" name ="name" value="${u.getFullName()}" required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Country <span>*</span></p>
                                        <input type="text" name="country" placeholder="Your country you want we ship product" value="${ad[3]}" required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Address <span>*</span></p>
                                        <input type="text" placeholder="Street Address" name="address" value="${ad[0]}" required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Town/City <span>*</span></p>
                                        <input type="text" name="towncity" value="${ad[1]}" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Country/State <span>*</span></p>
                                        <input type="text" name="state" value="${ad[2]}" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Postcode <span>*</span></p>
                                        <input type="text" name="postcode" value="${ad[4]}" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Phone <span>*</span></p>
                                        <input type="number" name="phone" placeholder="ex : 012345677" value="${u.getPhone()}" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Email <span>*</span></p>
                                        <input type="email" name="email" placeholder=s"ex : Example@email" value="${u.getEmail()}" required>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-lg-12">
                                    <div class="checkout__form__input">
                                        <p>Name <span>*</span></p>
                                        <input type="text" name ="name" placeholder="Your Name"  required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Country <span>*</span></p>
                                        <input type="text" name='country' placeholder="Your country you want we ship product to" required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Address <span>*</span></p>
                                        <input type="text" placeholder="Street Address" name='address' required>
                                    </div>
                                    <div class="checkout__form__input">
                                        <p>Town/City <span>*</span></p>
                                        <input type="text" name="towncity"required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Country/State <span>*</span></p>
                                        <input type="text" name="state" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Postcode <span>*</span></p>
                                        <input type="number" name="postcode" required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Phone <span>*</span></p>
                                        <input type="number" name="phone" placeholder="ex : 012345677"required>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="checkout__form__input">
                                        <p>Email <span>*</span></p>
                                        <input type="email" name="email" placeholder="ex : Example@email" required>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <div class="col-lg-12">
                            <div class="checkout__form__input">
                                <p>Oder notes <span></span></p>
                                <input type="text" name="des"
                                       placeholder="Note about your order, e.g, special noe for delivery (Optional)" >
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="checkout__order">
                        <h5>Your order</h5>
                        <div class="checkout__order__product">
                            <ul>
                                <li>
                                    <span class="top__text">Product</span>
                                    <span class="top__text__right">Total</span>
                                </li>
                                <c:forEach items="${list}" var="p" >
                                    <li>${p.getTake()} X ${p.getpName()} <span>$ <fmt:formatNumber type="number" maxFractionDigits="3" value="${p.getpPrice() * p.getTake()}" /></span></li>
                                    </c:forEach>
                            </ul>
                        </div>

                        <c:if test="${vou != null}">
                            <c:set var="voux" value="${vou}"/>
                            <div class="checkout__order__product" style="margin-top: 20px">
                                <ul>
                                    <li>
                                        <span class="top__text">Discount</span>
                                        <span class="top__text__right">Values</span>
                                    </li>
                                    <li>${voux.getVouName()} <span>$ ${voux.getVouValues()}</span></li>
                                </ul>
                            </div>
                        </c:if>
                        <div class="checkout__order__total">
                            <ul>
                                <c:if test="${vou != null}">
                                    <li>Voucher <span>$ - ${voux.getVouValues()} </span></li>
                                    </c:if>
                                <li>Shipping <span> FreeShip</span></li>
                                <li>VAT <span>$ <fmt:formatNumber type="number" maxFractionDigits="3" value="${vat}" /></span></li>
                                <li>Subtotal <span>$ <fmt:formatNumber type="number" maxFractionDigits="3" value="${sum}" /></span></li>
                                <li><strong>Total</strong> <span>$ <fmt:formatNumber type="number" maxFractionDigits="3" value="${total}" /></span></li>
                            </ul>
                            <input type="hidden" value="${total}" name="total"/>
                        </div>
                        <div class="checkout__order__widget" style="margin-bottom: 20px">
                            <h5 style="margin-top: 20px">Payment method</h5>
                             <!--   <label class="radio-inline"><input type="radio" name="optradio" checked>Option 1</label>
                                <label class="radio-inline"><input type="radio" name="optradio">Option 2</label>
                                <label class="radio-inline"><input type="radio" name="optradio">Option 3</label>-->
                            <select class="browser-default custom-select" name="payment">
                                <option selected value="pay">Pay when get product</option>
                                <option value="paypal">Pay Pal</option>
                            </select>
                        </div>
                        <input type="hidden" value="${sum}"name="sum">
                        <input type="hidden" value="${total}"name="total">
                        <input type="hidden" value="${vat}"name="vat">
                        <input type="hidden" value="0"name="shipping">
                        
                        <button type="submit" class="site-btn">Place order</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<!-- Checkout Section End -->

<jsp:include page="inc/footer.jsp"></jsp:include>