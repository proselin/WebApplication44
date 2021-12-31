<%-- 
   Document   : edit_product
   Created on : Oct 15, 2021, 10:25:31 AM
   Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start header section -->
<jsp:include page = "header.jsp"  />
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Edit product</div>
                        <hr>

                        <div class="col-md-10">
                            <div class="card card-secondary">
                                <div class="card-header">
                                    <h3 class="card-title">Update image</h3>

                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                            <i class="fas fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">

                                    <br>
                                    <!-------------->
                                    <div class="col-md-12">                     
                                        <div class="row form-group">
                                            <form method="post" action="product_ad?ac=updateSelectedImage" enctype="multipart/form-data">
                                                <input hidden value="${detail.getpID()}" name="pid">

                                                <div class="row"> 
                                                    <c:forEach var ="x" items="${detail.getImgs()}">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="imageid" value="${x.getImgID()}" id="flexRadioDefault1">
                                                            <img src="../${x.getImgURL()}" alt="alt" style="width: 200px ;height: 200px"/>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-12 col-md-12"> 

                                                    <div class="control-group" id="fields">

                                                        <label class="control-label" for="field1"> </label>
                                                        <div class="controls">
                                                            <div class="entry input-group upload-input-group">
                                                                <input  class="form-control" name="fields[]" type="file">
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <button class="btn btn-primary">Upload</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <div class="overlay toggle-menu"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;

    var today = year + "-" + month + "-" + day;


    document.getElementById('the-date').value = today;
</script>


<jsp:include page = "footer.jsp" />


