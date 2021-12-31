
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page = "header.jsp" />


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>User Management</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">User Profile</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <c:set value="${userinfo}" var="x"/>
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">

                    <!-- Profile Image -->
                    <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                            <div class="text-center">
                                <img class="profile-user-img img-fluid img-circle"
                                     src="dist/img/user4-128x128.jpg"
                                     alt="User profile picture">
                            </div>

                            <h3 class="profile-username text-center">${x.getFullName()}</h3>
                            <h5 class="profile-username text-center" >${x.getUserID()}</h5>
                            <ul class="list-group list-group-unbordered mb-3">
                                <li class="list-group-item">
                                    <b>Point</b> <a class="float-right">${x.getPoint()}</a>
                                </li>
                            </ul>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->


                    <!-- /.card -->
                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <div class="card">
                        <div class="card-header p-2">
                            <ul class="nav nav-pills">
                                <li class="nav-item"><a class="nav-link active" href="#profile" data-toggle="tab">Profile</a></li>
                                <li class="nav-item"><a class="nav-link" href="#timeline" data-toggle="tab">Purchase history</a></li>
                            </ul>
                        </div><!-- /.card-header -->
                        <div class="card-body">
                            <div class="tab-content">
                                <div class="active tab-pane" id="profile">
                                    <form class="form-horizontal" method="POST" action="user_ad?ac=edit">
                                        <div class="form-group row">

                                            
                                            <input hidden type="text" class="form-control" name="userid" value="${x.getUserID()}" >

                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="inputName" >Name</label>
                                                <input type="text" class="form-control" id="inputName" placeholder="Name" name="fullname" value="${x.getFullName()}" disabled readonly>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="inputEmail" >Email</label>
                                                <input type="email" name="email" class="form-control" id="inputEmail" placeholder="user@gmail.com"  value="${x.getEmail()}" required>
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="username" >Username</label>
                                                <input type="email" class="form-control" id="username" placeholder="Username" name="username" value="${x.getUserName()}" disabled readonly>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="password" >Password</label>
                                                <input type="password" class="form-control validate" name="password" id="password" placeholder="••••••" value="${x.getPassword()}">
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Street</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Street" name="street" value="${address[0]}" >
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >City/Town</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="City" name="city" value="${address[1]}">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >State</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="State" name="state" value="${address[2]}">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Country</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Country" name="country" value="${address[3]}">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Postcode</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Post Code" name="postcode" value="${address[4]}">
                                        </div>
                                        <div class="form-group row">
                                            <div class="mb-3 col-md-6">							
                                                <label class="form-label" for="inputDOB">Date of birth</label>
                                                <input type="date" class="form-control" id="inputDOB" name="dob" value="${x.getDate_of_birth()}" required >	
                                            </div>
                                            <div class="mb-3 col-md-4">
                                                <label class="form-label" for="inputPhone">Phone</label>
                                                <input type="text" class="form-control" id="inputPhone" name="phone" value="${x.getPhone()}" required>
                                            </div>
                                            <div class="mb-3 col-md-2">
                                                <label class="form-label" for="inputGender">Gender</label>
                                                <input type="text" class="form-control" id="inputGender" value="${x.getGender()}" disabled>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <button type="submit" class="btn btn-primary">Update</button>
                                        </div>
                                    </form>

                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="timeline">
                                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                                        <div class="tm-product-table-container">
                                            <table class="table table-hover tm-table-small tm-product-table">
                                                <thead class="table-light">
                                                    <tr>	
                                                        <th>Order#</th>
                                                        <th>Payment Method</th>
                                                        <th>Total</th>
                                                        <th>Create Date</th>
                                                        <th>Status</th>
                                                        <th>View</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${order}" var="o">
                                                        <tr>
                                                            <td>#${o.getOrderID()}</td>
                                                            <td>${o.getOrderPaymentMethod()}</td>
                                                            <td>$${o.getOrderTotalPrice()}</td>
                                                            <td ><fmt:formatDate value="${o.getOrderDate()}"/> </td>
                                                            <td><span class="badge badge-${o.getOrderStatus()=="Done"?"success":"warning"}">${o.getOrderStatus()}</span></td>
                                                            <td>
                                                                <a href="order_ad?ac=showInvoice&orderid=${o.getOrderID()}" class=""><i class="fas fa-eye"></i></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- table container -->
                                    </div>
                                </div>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div><!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


<jsp:include page = "footer.jsp" />
