<%-- 
    Document   : add_voucher
    Created on : Oct 15, 2021, 10:31:25 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "header.jsp"  />
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1></h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Add voucher</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>

    <section class="content h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-md-9">
                <div class="card card-primary">
                    <div class="card-header">
                        <h3 class="card-title">${vou!=null?"Update voucher":"Add voucher"}</h3>

                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                                <i class="fas fa-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${empty vou}">
                                <form action="voucher_ad?ac=add" method="post">
                                    <div class="form-group">
                                        <label for="input-1">Voucher Name</label>
                                        <input type="text" class="form-control" id="input-1" placeholder="Voucher Name" name="vouName" required>            
                                    </div>
                                    <div class="form-group">
                                        <label for="inputValue">Value(USD)</label>
                                        <input type="number" id="inputValue" class="form-control" name="vouValues" required placeholder="value of the voucher">
                                    </div>

                                    <div class="form-group">
                                        <label for="input-1">Limit level to use this voucher</label>
                                        <div id="input-1">
                                            <select class="form-select lg mb-3" style="width: 100%; height: 50px" aria-label="Default select example" name="levellimit" required>
                                                <option value="0point99999999">For every level</option>
                                                <option value="0point100">newbie</option>
                                                <option value="100point300">Iron</option>
                                                <option value="300point600">Silver</option>
                                                <option value="600point1200">Gold</option>
                                                <option value="1200point999999">Diamond</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="input-1">Limit Product in cart to use this voucher</label>
                                        <div id="input-1">
                                            <input type="text" class="form-control"  name="productlimit" list="Product" placeholder="Limit of the product in cart to use this voucher "required />
                                            <datalist id="Product">
                                                <option>3</option>
                                                <option>5</option>
                                                <option>10</option>
                                            </datalist>
                                        </div>
                                    </div>
                 
                                    <div class="form-group">
                                        <label class="form-label" for="expire_date">Expire date</label>
                                        <input id="expire_date" name="vouDate_Expired" type="date" required class="form-control validate"
                                               data-large-mode="true"/>
                                    </div> 
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add voucher</button>
                                    </div>
                                </form> 
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form action="voucher_ad?ac=edit" method="post">
                                <div class="form-group">
                                    <label for="input-1">Voucher ID :   #${vou.getVouID()}}</label>

                                </div>
                                <div class="form-group">
                                    <label for="input-1">Voucher Name</label>
                                    <input type="text" class="form-control" id="input-1" placeholder="Voucher Name" name="vouName" value="${vou.getVouName()}"}>            
                                </div>
                                <div class="form-group">
                                    <label for="inputValue">Value(USD)</label>
                                    <input type="text" id="inputValue" class="form-control" name="vouValues"value="${vou.getVouValues()}">
                                </div>

                                <div class="form-group">
                                    <label for="input-1">Rule</label>
                                    <input type="text" class="form-control" id="input-1"  name="vouRule" value="${vou.getVouRule()}" >            
                                </div>

                                <div class="form-group">
                                    <label class="form-label" for="expire_date">Expire date</label>
                                    <input id="expire_date" name="vouDate_Expired" type="text" class="form-control validate"
                                           data-large-mode="true"/>
                                </div> 
                                <div class="form-group">
                                    <button  class="btn btn-danger"><i class="fa fa-times"></i> <a href="voucher_ad?ac=view">Cancel</a></button>
                                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add voucher</button>
                                </div>
                            </form> 
                        </div>
                    </c:otherwise>
                </c:choose>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->
        </div>
    </section>

</div>


<jsp:include page = "footer.jsp"  />
