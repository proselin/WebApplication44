<%-- 
    Document   : list_product
    Created on : Oct 14, 2021, 2:39:47 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start header section -->
<jsp:include page = "header.jsp"  />
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Product</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Product </li>
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
                            <h3 class="card-title">List Product</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Product ID</th>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Sale_quantity</th>
                                        <th scope="col">Current_Quantity</th>
                                  
                                        <th scope="col">Edit</th> 
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${listP}" var="x">
                                        <tr style="max-height: 20px">

                                            <td>${x.pID}</td>
                                            <td class="tm-product-name">${x.pName}</td>
                                            <td>${x.pPrice}</td>
                                            <td>${x.pStatus}</td>
                                            <td>${x.getCateinfo().getCateName()}</td>
                                            <td>${x.pSale_Quantity}</td>
                                            <td>${x.pCurrent_Quantity}</td>

                                            <td>
                                                <a href="product_ad?pid=${x.pID}&ac=doshowdetail" class="fas fa-pencil-alt mr-1"></a> 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>

                                        <th scope="col">Product ID</th>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Sale_quantity</th>
                                        <th scope="col">Current_Quantity</th>
                                         
                                        <th scope="col">Edit</th> 
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

<jsp:include page = "footer.jsp" />
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