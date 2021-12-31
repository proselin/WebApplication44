<%-- 
    Document   : list_order
    Created on : Oct 24, 2021, 9:36:42 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <h3 class="card-title">ListOrder</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>	

                                        <th>OrderID</th>
                                        <th>Customer Name</th>
                                        <th>Status</th>
                                        <th>Total</th>
                                        <th>Date</th>
                                        <th>Phone</th> 
                                        <th>Email</th> 
                                        <th>Street</th>
                                        <th>City/town</th>
                                        <th>State</th>
                                        <th>Country</th>
                                        <th>Postcode</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listO}" var="x">
                                        <tr>
                                    
                                            <td class="tm-order-id" >${x.orderID}</td>
                                            <td class="tm-order-name">
                                                <c:choose>
                                                    <c:when test="${x.getUserID() ne null}">
                                                        <a href="user_ad?ac=viewUser&userid=${x.getUserID()}">${x.getOrderCustommerName()}</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${x.getOrderCustommerName()}
                                                    </c:otherwise>
                                                </c:choose>
                                                
                                            </td>
                                            
                                            <td><c:choose>
                                                    <c:when test="${x.orderStatus eq 'Wait'}">
                                                        <span class="badge badge-warning">Shipping (cash on delivery)</span></td>
                                                    </c:when>
                                                    <c:when test="${x.orderStatus eq 'Paid'}">
                                                        <span class="badge badge-warning">Shipping (Paid)</span></td>
                                                    </c:when>
                                                    <c:when test="${x.orderStatus eq 'cancel'}">
                                                        <span class="badge badge-dark">Cancel</span></td>
                                                    </c:when>
                                                    <c:when test="${x.orderStatus eq 'done'}">
                                                        <span class="badge badge-success">Done</span></td>
                                                    </c:when>
                                            </c:choose>
                                                
                                            <td>${x.orderTotalPrice}</td>				
                                            <td>${x.orderDate}</td>

                                            <td>
                                                ${x.orderPhoneNumber}
                                            </td>
                                            <td>
                                                ${x.orderEmailContract}
                                            </td>
                                            <td>
                                                ${x.getAddress()[0]}
                                            </td>
                                            <td>
                                                ${x.getAddress()[1]}
                                            </td>

                                            <td>
                                                ${x.getAddress()[2]}
                                            </td>
                                            <td>
                                                ${x.getAddress()[3]}
                                            </td>
                                            <td>
                                                ${x.getAddress()[4]}
                                            </td>

                                            <td>
                                                <a href="order_ad?ac=showInvoice&orderid=${x.getOrderID()}" class=""><i class="fas fa-eye"></i></a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>	

                                        <th>OrderID</th>
                                        <th>Customer Name</th>
                                        <th>Status</th>
                                        <th>Total</th>
                                        <th>Date</th>
                                        <th>Phone</th> 
                                        <th>Email</th> 
                                        <th>Street</th>
                                        <th>City/town</th>
                                        <th>State</th>
                                        <th>Country</th>
                                        <th>Postcode</th>
                                        <th>&nbsp;</th>
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