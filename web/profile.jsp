<%-- 
    Document   : profile
    Created on : Nov 8, 2021, 11:49:34 PM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp"></jsp:include>

    <div class="container">

        <div class="col-lg-12">
            <div class="product__details__tab">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Personal Details</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Order</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tabs-1" role="tabpanel">
                        <div class="row gutters">
                            <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                                <div class="card ">
                                    <div class="card-body">
                                        <div class="account-settings">
                                            <div class="user-profile">
                                                <div class="user-avatar">
                                                    <img src="img/logo233.png" alt="Maxwell Admin">
                                                </div>
                                                <h5 class="user-name">${user.getFullName()}</h5>
                                        </div>
                                        <div class="about" style="margin-top: 20px;">
                                            <p><strong>Level</strong> : ${level}</p>
                                            <div class="progress">
                                                <div class="progress-bar bg-success" style="width: ${process}%"></div>
                                            </div>
                                            <p style="text-align: center"><strong>${levelprocess}</strong>(point)</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                            <div class="card h-100">
                                <div class="card-body">

                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <h6 class="mb-2 text-primary">Personal Details</h6>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="fullName">Full Name</label>
                                                <input type="text" class="form-control" id="fullName" value="${user.getFullName()}">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="eMail">Email</label>
                                                <input type="email" class="form-control" id="eMail" value="${user.getEmail()}">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="phone">Phone</label>
                                                <input type="text" class="form-control" id="phone" value="${user.getPhone()}" placeholder="Enter phone number">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="website">Date of Birth</label>
                                                <input type="date" class="form-control disabled" id="website" value="${user.getDate_of_birth()}"d>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <h6 class="mt-3 mb-2 text-primary">Address</h6>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="Street">Street</label>
                                                <input value="${addressls[0]}" type="name" class="form-control" id="Street" placeholder="Enter Street">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="ciTy">City</label>
                                                <input value="${addressls[1]}" type="name" class="form-control" id="ciTy" placeholder="Enter City">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="sTate">State</label>
                                                <input value="${addressls[2]}" type="text" class="form-control" id="sTate" placeholder="Enter State">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="zIp">Country</label>
                                                <input value="${addressls[3]}" type="text" class="form-control" id="zIp" placeholder="Zip Code">
                                            </div>
                                        </div>
                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="zIp">Zip Code</label>
                                                <input value="${addressls[4]}" type="text" class="form-control" id="zIp" placeholder="Zip Code">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="text-right">
                                                <button type="button" id="submit" name="submit"
                                                        class="btn btn-secondary">Cancel</button>
                                                <button type="button" id="submit" name="submit"
                                                        class="btn btn-primary">Update</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-pane inactive" id="tabs-2" role="tabpanel">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">ID</th>
                                <th scope="col">Status</th>
                                <th scope="col">Day create</th>
                                <th scope="col">Payment Method</th>
                                <th scope="col">Total Price</th>
                                <th scope="col">View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${orderlistPending}" var="x" >
                                <tr>
                                    <th scope="row">1</th>
                                    <td>${x.orderID}</td>
                                    <td>${x.orderStatus}</td>
                                    <td>${x.orderDate}</td>
                                    <td>${x.orderPaymentMethod}</td>
                                    <td>${x.orderTotalPrice}</td>
                                    <td><a href="order_controller?ac=showInvoice&orderid=${x.orderID}">#</a></td>
                                </tr>
                            </c:forEach>
                            <tr><th scope="row">Done Order</th></tr>
                                    <c:forEach items="${orderlistSuccess}" var="x" >
                                <tr>
                                    <th scope="row">1</th>
                                    <td>${x.orderID}</td>
                                    <td>${x.orderStatus}</td>
                                    <td>${x.orderDate}</td>
                                    <td>${x.orderPaymentMethod}</td>
                                    <td>${x.orderTotalPrice}</td>
                                    <td><a href="order_controller?ac=showInvoice&orderid=${x.orderID}">#</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>


<jsp:include page="inc/footer.jsp"></jsp:include>
