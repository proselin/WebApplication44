<%-- 
    Document   : comment.jsp
    Created on : Oct 20, 2021, 10:46:43 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp" />
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Comment</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Comment</li>
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
                                        <th scope="col">CUSTOMER NAME</th>
                                        <th scope="col">PRODUCT</th>
                                        <th scope="col">COMMENT</th>
                                        <th scope="col">STAR</th>
                                        <th scope="col">DATE</th>
                                        <th scope="col">ACTION</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listR}" var="x">
                                        <tr>
                                            <td class="mailbox-name"><a href="user_ad?ac=viewUser&userid=${x.getUserID()}">${x.getFullname()}</a></td>
                                            <td class="mailbox-name"><a href="product_ad?pid=${x.getPid()}&ac=doshowdetail">${x.getpName()}</a></td>
                                            <td>${x.comment}</td>
                                            <td>${x.rateStar}</td>
                                            <td class="mailbox-date">${x.getDate()}</td>
                                            <td>
                                                <a href="../admin/comment_admin?ac=dodelete&id=${x.rateID}" class="tm-product-delete-link">
                                                    <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                </a>
                                            </td>                    
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>                 
                                        <th scope="col">CUSTOMER NAME</th>
                                        <th scope="col">PRODUCT ID</th>
                                        <th scope="col">COMMENT</th>
                                        <th scope="col">STAR</th>
                                        <th scope="col">DATE</th>
                                        <th scope="col">ACTION</th>
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