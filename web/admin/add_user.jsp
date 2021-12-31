
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header p-2">
                            <ul class="nav nav-pills">
                                <li class="nav-item"><a class="nav-link active" href="#profile" data-toggle="tab">Profile</a></li>

                            </ul>
                        </div><!-- /.card-header -->
                        <div class="card-body">
                            <div class="tab-content">
                                <div class="active tab-pane" id="profile">
                                    <form class="form-horizontal" action="user_ad?ac=add" method="post">
                                        <div class="form-group row">
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="inputName" >Name</label>
                                                <input type="text" class="form-control" id="inputName" name="name"placeholder="Name"required="" >
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="inputEmail" >Email</label>
                                                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="user@gmail.com" required>
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="username" >Username</label>
                                                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label for="password" >Password</label>
                                                <input  name="password" type="password" class="form-control validate" id="password" placeholder="••••••"required>
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Street</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Street" name="street" >
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >City/Town</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="City" name="city">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >State</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="State" name="state">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Country</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Country" name="country" ">
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputAddress" >Postcode</label>
                                            <input type="text" class="form-control" id="inputAddress" placeholder="Post Code" name="postcode" >
                                        </div>
                                        <div class="form-group row">
                                            <div class="mb-3 col-md-6">							
                                                <label class="form-label" for="inputDOB">Date of birth</label>
                                                <input
                                                    id="inputDOB"
                                                    name="dob"
                                                    type="date"
                                                    class="form-control validate"
                                                    data-large-mode="true"
                                                    required
                                                    />	
                                            </div>
                                            <div class="mb-3 col-md-4">
                                                <label class="form-label" for="inputPhone">Phone</label>
                                                <input type="text" class="form-control" id="inputPhone"  name="phone"required>
                                            </div>
                                            <div class="mb-3 col-md-2">
                                                <label class="form-label" for="inputGender">Gender</label>
                                                <div>
                                                    <select class="form-control valid" id="inputGender"  name="gender" required aria-invalid="false" required>
                                                        <option value="Male">Male</option>
                                                        <option value="Woman">Female</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="form-group mb-3 col-xs-12 col-sm-6">
                                                <label class="form-label" for="inputGender">Role</label>
                                                <div>
                                                    <select class="form-control valid" id="inputGender"  name="gender" required aria-invalid="false">
                                                        <option value="User012">User</option>
                                                        <option value="Staff012">Staff</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <button type="submit" class="btn btn-danger">Add user</button>

                                        </div>
                                    </form>

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
<script>

    $(function () {
        $("#inputDOB").datepicker();
    });
</script>

<jsp:include page = "footer.jsp" />
