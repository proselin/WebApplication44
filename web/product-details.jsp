<%-- 
    Document   : product-details
    Created on : Nov 11, 2021, 3:02:02 PM
    Author     : quoch
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__links">
                    <a href="index.jsp"><i class="fa fa-home"></i> Home</a>
                    <a href="product?ac=dosearch&gender=${requestScope.product_infor.getpGender()}">${requestScope.product_infor.getpGender()}</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <c:choose>
            <c:when test="${success !=null}">
                <div class="alert alert-success alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> ${success}
                </div>
            </c:when>
            <c:when test="${error !=null}">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Error!</strong> ${error}
                </div>
            </c:when>

        </c:choose>
        <div class="row">
            <div class="col-lg-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__left product__thumb nice-scroll">
                        <%
                            int b = 0;
                        %>
                        <c:forEach items="${product_infor.getImgs()}" var="x">
                            <a class="pt" href="#product-<% out.print(b += 1); %>">
                                <img src="${x.getImgURL()}" alt="">
                            </a>
                        </c:forEach>


                    </div>
                    <div class="product__details__slider__content">
                        <div class="product__details__pic__slider owl-carousel">
                            <%
                                int a = 0;
                            %>
                            <c:forEach items="${product_infor.getImgs()}" var="x">
                                <img data-hash="product-<% out.print(a += 1);%>" class="product__big__img"
                                     src="${x.getImgURL()}" alt="">
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product__details__text">
                    <h3>${product_infor.getpName()}</h3>  
                    <h2>${product_infor.getpStatus() eq 'Unavailable'?"(Stop selling this product)":""}</h2>
                    <p>Brand: ${requestScope.product_infor.getpBrand()} </p>
                    <div class="rating">
                        <c:forEach begin="1" end="${product_infor.getpRate_Count()}" var="rt">
                            <i class="fa ${product_infor.getpRate_Count()>=rt?"fa-star":"fa-star-o"}"></i>
                        </c:forEach>

                        <span>(${ratecount.get(0)})</span>
                    </div>
                    <div class="product__details__price">$ ${requestScope.product_infor.getpPrice()} <!--<span>$ 83.0</span>--></div>
                    <p id="des">${requestScope.product_infor.getpName()} has a scent like ${requestScope.product_infor.getpIncense()}</p>


                    <div class="product__details__button">
                        <form action="cart" method="POST" id="addcart">
                            <input type="hidden" name="ac" value="dochange">
                            <input type="hidden" name="pid" value="${product_infor.getpID()}">
                            <input type="hidden" name="take" value="1">
                            <input type="hidden" name="redirect" value="shop-cart.jsp">
                            <a href="javascript:{}"  class="cart-btn" onclick="${product_infor.getpStatus() eq 'Unavailable'?"#":"document.getElementById('addcart').submit()"}"  ><span class="icon_bag_alt"></span> Add to cart</a>
                        </form>
                    </div>
                    <div class="product__details__widget">
                        <ul>
                            <li>
                                <span>Status: </span>

                                <p>${product_infor.getpStatus()}</p>
                            </li>
                            <li>
                                <span>Stock left: </span>

                                <p>${product_infor.getpCurrent_Quantity()}</p>
                            </li>
                            <li>
                                <span>Sold: </span>

                                <p>${product_infor.getpSale_Quantity()}</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Information</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <h6>About</h6>
                            <div class="product__details__widget">
                                <ul style="margin-left: 10px; margin-bottom: 20px;">
                                    <li>
                                        <span>Brand</span>
                                        <p>${product_infor.getpBrand()} </p>
                                    </li>
                                    <li>
                                        <span>From</span>
                                        <p>${requestScope.product_infor.getpMadeIn()} </p>
                                    </li>
                                    <li>
                                        <span>Year</span>
                                        <p>${requestScope.product_infor.getpYear()}</p>
                                    </li>
                                    <li>
                                        <span>Concentration</span>
                                        <p>${requestScope.product_infor.getCateinfo().getCateName()} </p>

                                    </li>
                                    <li>
                                        <span>
                                            Incense</span>
                                        <p>${requestScope.product_infor.getpIncense()}</p>

                                    </li>
                                    <li>
                                        <span>
                                            For Gender</span>
                                        <p>${requestScope.product_infor.getpGender()}  </p>

                                    </li>

                                </ul>
                            </div> 
                        </div>
                        <div class="tab-pane inactive" id="tabs-2" role="tabpanel">

                            <span>Descriptions</span>
                            <p> ${requestScope.product_infor.getpDes()} 
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Rate and comment -->
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="related__title">
                    <h3>Rate & Comment</h3>
                </div>
                <div class="justify-content-center">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-12 text-center mb-5">
                        <div class="card">
                            <div class="row justify-content-left d-flex">
                                <div class="col-md-4 d-flex flex-column">
                                    <div class="rating-box" style="border-radius: 25px;">
                                        <h1 class="pt-4"><fmt:formatNumber type = "number" 
                                                          maxFractionDigits = "2" value = "${percent.get(0)}"></fmt:formatNumber></h1>
                                            <p style="margin-top: 5 px; text-size-adjust: 14;">out of 5</p>
                                        </div>

                                        <div>
                                        <c:forEach begin="1" end="${product_infor.getpRate_Count()}" var="rt">
                                            <span class="fa fa-star ${product_infor.getpRate_Count()>=rt?"star-active":"star-inactive"} mx-1"></span>
                                        </c:forEach>

                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="rating-bar0 justify-content-center">
                                        <table class="text-left mx-auto">
                                            <tr>
                                                <td class="rating-label">Excellent</td>
                                                <td class="rating-bar">
                                                    <div class="bar-container">
                                                        <div class="bar" style="width: ${percent.get(5)}%"></div>
                                                    </div>
                                                </td>
                                                <td class="text-right">${ratecount.get(5)}</td>
                                            </tr>
                                            <tr>
                                                <td class="rating-label">Good</td>
                                                <td class="rating-bar">
                                                    <div class="bar-container">
                                                        <div class="bar" style="width: ${percent.get(4)}%"></div>
                                                    </div>
                                                </td>
                                                <td class="text-right">${ratecount.get(4)}</td>
                                            </tr>
                                            <tr>
                                                <td class="rating-label">Average</td>
                                                <td class="rating-bar">
                                                    <div class="bar-container">
                                                        <div class="bar" style="width: ${percent.get(3)}%"></div>
                                                    </div>
                                                </td>
                                                <td class="text-right">${ratecount.get(3)}</td>
                                            </tr>
                                            <tr>
                                                <td class="rating-label">Poor</td>
                                                <td class="rating-bar">
                                                    <div class="bar-container">
                                                        <div class="bar" style="width: ${percent.get(2)}%"></div>
                                                    </div>
                                                </td>
                                                <td class="text-right">${ratecount.get(2)}</td>
                                            </tr>
                                            <tr>
                                                <td class="rating-label">Terrible</td>
                                                <td class="rating-bar">
                                                    <div class="bar-container">
                                                        <div class="bar" style="width: ${percent.get(1)}%"></div>
                                                    </div>
                                                </td>
                                                <td class="text-right">${ratecount.get(1)}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--<!-- end calculate -->
                        <!-- start header comment -->
                        <c:forEach var="rt" items="${product_rate}">
                            <div class="card">
                                <div class="row d-flex">
                                    <div style="margin-right: 20px;margin-top: 10px;"> 
                                        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50"
                                             fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                                        <path fill-rule="evenodd"
                                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                                        </svg>
                                    </div>
                                    <div class="d-flex flex-column">
                                        <h4 class="mt-2 mb-0" style="text-align: left">${rt.getFullname()}</h4>
                                        <div>
                                            <p class="text-left"><span class="text-muted">${rt.getRateStar()},0 </span> 
                                                <c:forEach begin="1" end="5" var="star">
                                                    <span class="fa fa-star ${rt.getRateStar()>=star?"star-active":"star-inactive"} ${star==1?"ml-3":""}"></span> 
                                                </c:forEach>
                                        </div>
                                    </div>
                                    <div class="ml-auto">
                                        <p class="text-muted pt-5 pt-sm-3"><fmt:formatDate value="${rt.getDate()}"/></p>
                                    </div>
                                </div>
                                <!-- end header -->
                                <div class="row text-left">
                                    <h4 class="blue-text mt-3" style="color: graytext"></h4>
                                </div>
                                <div class="row text-left">
                                    <p class="content">${rt.getComment()}
                                    </p>
                                </div>
                                <c:if test="${rt.getUserID() == sessionScope.use}">
                                    <div class="row text-right" style="margin-top: 20px">
                                        <form action="product?ac=dodelcomment" method="POST" id="dodelcomment">
                                            <a style="font-size: 15px;" href="javascript:{}" onclick="document.getElementById('dodelcomment').submit();">Delete</a>
                                            <input type="hidden" name="rateid" value="${rt.getRateID()}"/>
                                            <input type="hidden" name="pid" value="${product_infor.getpID()}"/>
                                        </form>     
                                    </div>
                                </c:if>

                            </div>
                        </c:forEach>
                        <div class="card">
                            <div class="row d-flex">
                                <div class="flex-column">
                                    <h4>Give us a comment</h4>
                                </div>
                            </div>
                            <div class="row d-flex">

                                <div class="flex-column" style="margin-top: 20px ; align-self: center">
                                    ${sessionScope.use !=null?'<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#form"> Click to comment </button>':'<a href="login" style="color=red; font-size:15px">Please login to comment</a>'}


                                    <div class="modal fade" id="form" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="text-right cross"> <button type="button" class="close" data-dismiss="modal"><i class="fa fa-times mr-2"></i></button> </div>
                                                <div class="card-body text-center"> <img src=" https://i.imgur.com/d2dKtI7.png" height="100" width="100">
                                                    <div class="comment-box text-center">
                                                        <h4>Add a comment</h4>
                                                        <form action="product?ac=docomment" method="POST">
                                                            <div class="ratingss"> 
                                                                <input type="radio" name="rating" value="5" id="5">
                                                                <label for="5">☆</label> 
                                                                <input type="radio" name="rating" value="4" id="4">
                                                                <label for="4">☆</label> 
                                                                <input type="radio" name="rating" value="3" id="3">
                                                                <label for="3">☆</label> 
                                                                <input type="radio" name="rating" value="2" id="2">
                                                                <label for="2">☆</label> 
                                                                <input type="radio" name="rating" value="1" id="1">
                                                                <label for="1">☆</label> </div>
                                                            <input type="hidden" name="pid" value="${product_infor.getpID()}">
                                                            <div class="comment-area"> <textarea class="form-control" placeholder="what is your view?" rows="4" name="comment"></textarea> </div>
                                                            <div class="text-center mt-4"> <button class="btn btn-success send px-5" type="submit"id="addcommentbtn">Post comment <i class="fa fa-long-arrow-right ml-1"></i></button> </div>
                                                        </form>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end comment -->


                </div>
            </div>
        </div>
    </div>
    <!--end rate and comment-->

    <!--start relate product-->

    <div class="row">
        <div class="col-lg-12 text-center">
            <div class="related__title">
                <h5>RELATED PRODUCTS</h5>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="product__item">
                <div class="product__item__pic set-bg" data-setbg="img/product/p1.jpg">
                    <div class="label new">New</div>
                    <ul class="product__hover">
                        <li><a href="img/product/p1.jpg" class="image-popup"><span
                                    class="arrow_expand"></span></a></li>
                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                    </ul>
                </div>
                <div class="product__item__text">
                    <h6><a href="#">Buttons tweed blazer</a></h6>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <div class="product__price">$ 59.0</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="product__item">
                <div class="product__item__pic set-bg" data-setbg="img/product/p2.jpg">
                    <ul class="product__hover">
                        <li><a href="img/product/p2.jpg" class="image-popup"><span
                                    class="arrow_expand"></span></a></li>
                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                    </ul>
                </div>
                <div class="product__item__text">
                    <h6><a href="#">Flowy striped skirt</a></h6>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <div class="product__price">$ 49.0</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="product__item">
                <div class="product__item__pic set-bg" data-setbg="img/product/p3.jpg">
                    <div class="label stockout">out of stock</div>
                    <ul class="product__hover">
                        <li><a href="img/product/p3.jpg" class="image-popup"><span
                                    class="arrow_expand"></span></a></li>
                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                    </ul>
                </div>
                <div class="product__item__text">
                    <h6><a href="#">Cotton T-Shirt</a></h6>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <div class="product__price">$ 59.0</div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="product__item">
                <div class="product__item__pic set-bg" data-setbg="img/product/p4.jpg">
                    <ul class="product__hover">
                        <li><a href="img/product/p4.jpg" class="image-popup"><span
                                    class="arrow_expand"></span></a></li>
                        <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                    </ul>
                </div>
                <div class="product__item__text">
                    <h6><a href="#">Slim striped pocket shirt</a></h6>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                    <div class="product__price">$ 59.0</div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
<!-- Product Details Section End -->

<jsp:include page="inc/footer.jsp"/>

