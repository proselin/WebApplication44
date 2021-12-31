<%-- 
    Document   : edit_order
    Created on : Oct 27, 2021, 8:33:49 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page = "header.jsp" />
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Update status</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
              <li class="breadcrumb-item active">Order Detail</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">Order Detail</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
              <div class="form-group">
               Order ID
               <input type="text" id="inputID" class="form-control" value="#001">
              </div>
              <div class="form-group">
                Customer Name
                <input type="text" id="inputName" class="form-control" value="Andrew">
              </div>
              <div class="form-group">
                Email
                <input type="text" id="inputEmail" class="form-control" value="andrew@gmail.com">
              </div>
              <div class="form-group">
                Address
                <input type="text" id="inputAddress" class="form-control" value="Ha Noi">
              </div>
              <div class="form-group">
               Phone
                <input type="text" id="inputPhone" class="form-control" value="0123456789">
              </div>
              <div class="form-group">
               Product Name
                <input type="text" id="inputProductName" class="form-control" value="Product1">
              </div>
              <div class="form-group">
               Quantity
                <input type="text" id="inputQuantity" class="form-control" value="1">
              </div>
              <div class="form-group">
               Total price
                <input type="text" id="inputPhone" class="form-control" value="15$">
              </div>
              <div class="form-group">
               Phone
                <input type="text" id="inputPhone" class="form-control" value="0123456789">
              </div>
              <div class="form-group">
               Start date
                <input type="text" id="inputPhone" class="form-control" value="10/10/2021">
              </div>
              <div class="form-group">
               Delivery date
                <input type="text" id="inputPhone" class="form-control" value="10/27/2021">
              </div>
              <div class="form-group">
              Payment method
                <input type="text" id="inputPhone" class="form-control" value="Paypal">
              </div>
               <div class="form-group">
              Status
                <input type="text" id="inputPhone" class="form-control" value="Pending">
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <div class="col-md-6">
          <div class="card card-secondary">
            <div class="card-header">
              <h3 class="card-title">Update</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
              <div class="form-group">
                <div class="form-group">
                    Order ID
                    <input type="text" id="inputID" class="form-control" value="#001">
              
              </div>
              <div class="form-group">
                
                Customer Name
                <input type="text" id="inputName" class="form-control" value="Andrew">
              
              </div>
              <div class="form-group">
               Address
                <input type="text" id="inputName" class="form-control" value="Ha Noi">
              </div>
              <div class="form-group">
               Start date
               <input type="text" id="start_date" class="form-control" placeholder="dd/mm/yyyy" >
              </div>
              <div class="form-group">
               Delivery date
                <input type="text" id="delivery_date" class="form-control" placeholder="dd/mm/yyyy" >
              </div>
              <div class="form-group">
	             <label for="input-2">Status</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-status" required aria-invalid="false">
	                        <option value="0">Pending</option>
	                        <option value="1">Delivered</option>
                                <option value="2">Shipped</option>
	                    </select>
	                  </div>
	          </div>
                  <div>
                      <a href="#" class="btn btn-secondary">Cancel</a>
                      <input type="submit" value="Save changes" class="btn btn-success float-right">
                  </div>
            </div>
                
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
      </div>
     </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


<script>
      $(function() {
        $("#start_date").datepicker();
      });
      
      $(function() {
        $("#delivery_date").datepicker();
      });
</script>











<jsp:include page = "footer.jsp" />
