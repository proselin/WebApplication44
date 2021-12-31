<%-- 
    Document   : voucher.jsp
    Created on : Oct 15, 2021, 9:33:01 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page = "header.jsp" />

<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Voucher Section Begin -->

<div class="content-wrapper">

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
                                        <th scope="col">VOUCHER ID</th>
                                        <th scope="col">VOUCHER NAME</th>
                                        <th scope="col">VALUES</th>
                                        <th scope="col">EXPIRE DATE</th>
                                        <th scope="col">STATUS</th>
                                        <th scope="col">LIMIT POINT(MIN)</th>
                                        <th scope="col">LIMIT POINT(MAX)</th>
                                        <th scope="col">LIMIT PRODUCT</th>
                                        <th scope="col">UPDATE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="x" items="${requestScope.listVoucher}">
                                        <tr>
                                            <td>${x.vouID}</td>
                                            <td class="tm-voucher-name">${x.vouName}</td>
                                            <td>${x.vouValues}</td>
                                            <td>${x.vouDate_Expired}</td>

                                            <c:choose>
                                                <c:when test="${x.getVouStatus() eq 'Available'}">
                                                    <td> <select class="form-select lg mb-3" style="width: 100%" aria-label="Default select example" name="voustatus">
                                                            <option value="Unavailable" style="color: red">Invalid</option>
                                                            <option value="Available"  selected=""style="color: green">Valid</option>
                                                        </select></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td style="color: red">Invalid</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${x.getVouRuleEx()[0]}</td>
                                            <td>${x.getVouRuleEx()[1]}</td>
                                            <td>${x.getVouRuleEx()[2]}</td>
                                            <td>
                                                <a href="voucher_ad?ac=edit&vouID=${x.vouID}" class="tm-product-delete-link">
                                                    <i class="fas fa-pencil-alt "></i>
                                                </a>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th scope="col">VOUCHER ID</th>
                                        <th scope="col">VOUCHER NAME</th>
                                        <th scope="col">VALUES</th>
                                        <th scope="col">EXPIRE DATE</th>
                                        <th scope="col">STATUS</th>
                                        <th scope="col">LIMIT POINT(MIN)</th>
                                        <th scope="col">LIMIT POINT(MAX)</th>
                                        <th scope="col">LIMIT PRODUCT</th>
                                        <th scope="col">UPDATE</th>
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