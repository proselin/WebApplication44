<%-- 
    Document   : testvou
    Created on : Nov 22, 2021, 6:06:10 PM
    Author     : quoch
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp"/>
<div class="container my-5">
    <div  class="row" >
        <div class="col-md-6 sm-6">
            <h3 style="margin: 20px 0px 20px 0px; text-align: center">Your voucher</h3>
        </div>
        <div class="col-md-6 sm-6">
            <h3 style="margin: 20px 0px 20px 0px; text-align: center">Voucher available for you</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-sm-6">
            <c:forEach var="x" items="${requestScope.listv}" >

                <div class="coupon bg-white rounded mb-3 d-flex justify-content-between" >
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
                                        <p> <fmt:formatDate type="date" pattern="dd-MM" value="${x.getVoucher_info().getVouDate_Expired()}" /></p>
                                    </span>
                                </div>
                                <a href="cart?ac=doshow" target="_blank" class="btn btn-sm btn-outline-danger btn-block">
                                    Using
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-md-6 col-sm-6">

            <c:forEach var="x" items="${requestScope.listvn}" >
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
                                        <p> <fmt:formatDate type="date" pattern="dd-MM" value="${x.getVouDate_Expired()}" /></p>
                                    </span>
                                </div>
                                <a href="vou?ac=doadd&id=${x.getVouID()}" target="_blank" class="btn btn-sm btn-outline-danger btn-block ClaimButton">
                                    claim
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="inc/footer.jsp"/>