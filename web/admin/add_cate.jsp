<%-- 
    Document   : add_cate
    Created on : Oct 20, 2021, 9:15:14 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page = "header.jsp"  />
 <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12 align-items-center">
             
            <div class="card">
                <div class="card-header">
            <h3 class="card-title">Add category</h3>

            
         </div>
                
              <div class="card-body">
                
                <form action="add" method="post">
                
                  <div class="form-group ">
                    <label for="input-1">Category Name</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Category Name" name="cate-name">
                  </div>
	          <div class="form-group">
	            <label for="input-2" class="col-form-label">Description</label>
                     <div>
                        <textarea class="form-control" rows="4" id="input-17" name="product-desc"></textarea>
                     </div>
	          </div>
                 <div class="form-footer">
                    <button type="submit" class="btn btn-danger"><i class="fa fa-times"></i> Cancel </button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
 
 </style>
  
<jsp:include page = "footer.jsp"  />
