<%-- 
    Document   : list_user
    Created on : Oct 24, 2021, 8:51:02 PM
    Author     : HP
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page = "header.jsp" />

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>User</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">User</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">ListUser</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">USER ID</th>
                                        <th scope="col">USER NAME</th>
                                        <th scope="col">STREET</th>
                                        <th scope="col">CITY</th>
                                        <th scope="col">STATE</th>
                                        <th scope="col">COUNTRY</th>
                                        <th scope="col">POSTCODE</th>
                                        <th scope="col">GENDER</th>
                                        <th scope="col">DATE OF BIRTH</th>
                                        <th scope="col">PHONE</th>
                                        <th scope="col">EMAIL</th>
                                        <th scope="col">POINT</th>
                                        <th scope="col">ROLE</th>
                                        <th scope="col">VIEW</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${userList}" var="x">
                                        <tr>
                                            <td>#${x.getUserID()}</td>
                                            <td class="tm-user-name">${x.getFullName()}</td>
                                            <td>${x.getAddresslist()[0] eq ' '?"-":x.getAddresslist()[0]}</td>
                                            <td>${x.getAddresslist()[1] eq ' '?"-":x.getAddresslist()[1]}</td>
                                            <td>${x.getAddresslist()[2] eq ' '?"-":x.getAddresslist()[2]}</td>
                                            <td>${x.getAddresslist()[3] eq ' '?"-":x.getAddresslist()[3]}</td>
                                            <td>${x.getAddresslist()[4] eq ' '?"-":x.getAddresslist()[4]}</td>
                                            <td>${x.getGender()}</td>
                                            <td>${x.getDate_of_birth()}</td>
                                            <td>${x.getPhone()}</td>
                                            <td>${x.getEmail() }</td>
                                            <td>${x.getPoint()}</td>
                                            <td>${x.getRoleID()}</td>
                                            <td>
                                                <a href="user_ad?ac=viewUser&userid=${x.getUserID()}" class=""><i class="fas fa-eye"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th scope="col">USER ID</th>
                                        <th scope="col">USER NAME</th>
                                        <th scope="col">STREET</th>
                                        <th scope="col">CITY</th>
                                        <th scope="col">STATE</th>
                                        <th scope="col">COUNTRY</th>
                                        <th scope="col">POSTCODE</th>
                                        <th scope="col">GENDER</th>
                                        <th scope="col">DATE OF BIRTH</th>
                                        <th scope="col">PHONE</th>
                                        <th scope="col">EMAIL</th>
                                        <th scope="col">POINT</th>
                                        <th scope="col">ROLE</th>
                                        <th scope="col">VIEW</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->

</div>


<script>
    $(function () {
        $(".tm-user-name").on("click", function () {
            window.location.href = "edit_user.jsp";
        });
    });
</script>

<jsp:include page="footer.jsp"></jsp:include>
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>