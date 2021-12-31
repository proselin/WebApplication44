
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.voucher_user"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->


<jsp:include page="inc/header.jsp"/>

<html>
    <head>
        <title>title</title>
        <style>
            body {
                background-color: black ;
            }
            .coupon .kanan {
                border-left: 1px dashed #ddd;
                width: 40% !important;
                position:relative;
                margin-top: 20px;
            }

            .coupon .kanan .info::after, .coupon .kanan .info::before {
                content: '';
                position: absolute;
                width: 20px;
                height: 20px;
                background: #dedede;
                border-radius: 100%;
            }
            .coupon .kanan .info::before {
                top: -10px;
                left: -10px;
            }

            .coupon .kanan .info::after {
                bottom: -10px;
                left: -10px;
            }
            .coupon .time {
                font-size: 1.6rem;
            }
            .disabled-link{
                cursor: default;
                pointer-events: none;
                text-decoration: none;
                color: grey;
            }
        </style>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>
    <body>
        <c:if test="${empty requestScope.listv}">
            <jsp:forward page="/voucher_controller?ac=showvoucher"/>
        </c:if>

        <div class="container my-5">
            <div class="row">
                <c:forEach var="x" items="${requestScope.listv}" >
                    <div class="col-sm-6">
                        <div class="coupon bg-white rounded mb-3 d-flex justify-content-between">
                            <div class="kiri p-3">
                                <div class="icon-container ">
                                    <div class="icon-container_box" >
                                        <img src="img/coupon/p1.jpg" width="170px" height="120px" alt=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="tengah py-3 d-flex w-100 justify-content-start">

                                <div>

                                    <c:choose>
                                        <c:when test="${x.getStatus() == 'Available'}">
                                            <span class="badge badge-success">Valid</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-success" style="background-color: red;color: black">Invalidok</span>
                                        </c:otherwise>
                                    </c:choose>

                                    <h3 class="lead">${x.getVoucher_info().getVouName()}</h3>
                                    <p class="text-muted mb-0"> Values :  ${x.getVoucher_info().getVouValues()} $</p>
                                </div>
                            </div>
                            <div class="kanan">
                                <div class="info m-3 d-flex align-items-center">
                                    <div class="w-100">
                                        <div class="block">
                                            <span class="time font-weight-light">
                                                <p >Expired:</p>
                                                <p> <fmt:formatDate type="date" pattern="dd-MM" value="${x.getVoucher_info().getVouDate_Create()}" /></p>
                                            </span>

                                        </div>
                                        <c:choose>
                                            <c:when test="${x.getStatus() == 'Available'}">
                                                <a href="shop-cart.jsp" target="_blank" class="btn btn-sm btn-outline-danger btn-block">
                                                    Using
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>



                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <h1>Highly voucher</h1>
        <div class="container my-5">
            <div class="row">
                <c:forEach var="x" items="${requestScope.listvn}" >
                    <c:if test="${x.getVouStatus() == 'Available'}">
                          <div class="col-sm-6">
                              <div class="coupon bg-white rounded mb-3 d-flex justify-content-between">
                                  <div class="kiri p-3">
                                      <div class="icon-container ">
                                          <div class="icon-container_box" >
                                              <img src="img/coupon/p1.jpg" width="170px" height="120px" alt=""/>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="tengah py-3 d-flex w-100 justify-content-start">

                                      <div>
                                          <span class="badge badge-success">Valid</span>

                                          <h3 class="lead">${x.getVouName()}</h3>
                                          <p class="text-muted mb-0"> Values :  ${x.getVouValues()} $</p>
                                      </div>
                                  </div>
                                  <div class="kanan">
                                      <div class="info m-3 d-flex align-items-center">
                                          <div class="w-100">
                                              <div class="block">
                                                  <span class="time font-weight-light">
                                                      <p >Expired:</p>
                                                      <p> <fmt:formatDate type="date" pattern="dd-MM" value="${x.getVouDate_Create()}" /></p>
                                                  </span>

                                              </div>
                                              <a href="shop-cart.jsp" target="_blank" class="btn btn-sm btn-outline-danger btn-block">
                                                  Using
                                              </a>




                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="inc/footer.jsp"/>
