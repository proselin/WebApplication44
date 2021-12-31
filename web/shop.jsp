<%-- Document : shop Created on : Nov 11, 2021, 5:08:40 PM Author : quoch --%>

<%@page import="java.util.ArrayList" %>
<%@page import="Entity.Product" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="inc/header.jsp" />

<!-- Breadcrumb Begin -->
<div class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__links">
                    <a href="./index.jsp"><i class="fa fa-home"></i> Home</a>
                    <span>Shop</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="shop__sidebar">
                    <div class="sidebar__categories">
                        <div class="section-title">
                            <h4>Categories</h4>
                        </div>
                        <div class="categories__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="card">
                                    <div class="card-heading active">
                                        <a  data-toggle="collapse" data-target="#collapseOne">Sort by category</a>
                                    </div>
                                    <div id="collapseOne" class="${cate !=null?"show":""}"
                                         data-parent="#accordionExample">
                                        <div class="card-body">
                                            <ul>
                                                <li><a href="product?ac=dosearch&cate=CATE1">Perfume</a></li>
                                                <li><a href="product?ac=dosearch&cate=CATE2">Eau de Perfume</a></li>
                                                <li><a href="product?ac=dosearch&cate=CATE3">Eau de Toilette</a></li>
                                                <li><a href="product?ac=dosearch&cate=CATE4">Eau de Cologne</a></li>
                                                <li><a href="product?ac=dosearch&cate=CATE5">Eau Fraiche</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseTwo">Gender</a>
                                    </div>
                                    <div id="collapseTwo" class="collapse"
                                         data-parent="#accordionExample">
                                        <div class="card-body">
                                            <ul>
                                                <li><a href="product?ac=dosearch&gender=Men">Perfume for Men</a></li>
                                                <li><a href="product?ac=dosearch&gender=Women">Perfume for Women</a></li>
                                                <li><a href="product?ac=dosearch&gender=Unisex">Unisex</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse"
                                           data-target="#collapseFour">Brand</a>
                                    </div>
                                    <div id="collapseFour" class="collapse"
                                         data-parent="#accordionExample">
                                        <div class="card-body">
                                            <ul>
                                                <c:forEach var="bra" begin="0" end="${brandname.size()-1}">
                                                    <li><a href="product?ac=dosearch&brand=${brandname.get(bra)}">${brandname.get(bra)}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="sidebar__filter">
                        <div class="section-title">
                            <h4>Shop by price</h4>
                        </div>
                        <div class="filter-range-wrap">
                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                 data-min="30" data-max="300"></div>
                            <div class="range-slider">
                                <div class="price-input">
                                    <p>Price:</p>
                                    <form id="price_form" method="POST" action="product?ac=dosearch">
                                        <input type="text" id="minamount" name="start"  >
                                        <input type="text" id="maxamount" name="end" >
                                        <a href="javascript:{}" onclick="document.getElementById('price_form').submit();">Filter</a>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--<div class="sidebar__sizes">
                        <div class="section-title">
                            <h4>Shop by star</h4>
                        </div>
                        <div class="size__list">
                            <label for="xxs">
                                5 star
                                <input type="checkbox" id="5star">
                                <span class="checkmark"></span>
                            </label>
                            <label for="xs">
                                4 star
                                <input type="checkbox" id="4star">
                                <span class="checkmark"></span>
                            </label>
                            <label for="xss">
                                3 star
                                <input type="checkbox" id="3star">
                                <span class="checkmark"></span>
                            </label>
                            <label for="s">
                                2 star
                                <input type="checkbox" id="2star">
                                <span class="checkmark"></span>
                            </label>
                            <label for="m">
                                1 star
                                <input type="checkbox" id="1star">
                                <span class="checkmark"></span>
                            </label>

                        </div>
                    </div>
                    <div class="sidebar__color">
                        <div class="section-title">
                            <h4>Shop by Sale</h4>
                        </div>
                        <div class="size__list color__list">
                            <label for="black">
                                Offers For Her
                                <input type="checkbox" id="black">
                                <span class="checkmark"></span>
                            </label>
                            <label for="whites">
                                Reduced to Clear

                                <input type="checkbox" id="whites">
                                <span class="checkmark"></span>
                            </label>
                            <label for="reds">
                                Gift Set Sale
                                <input type="checkbox" id="reds">
                                <span class="checkmark"></span>
                            </label>
                            <label for="greys">
                                Brands
                                <input type="checkbox" id="greys">
                                <span class="checkmark"></span>
                            </label>

                        </div>
                    </div>
                    -->
                </div>
            </div>

            <div class="col-lg-9 col-md-9">
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
                            <strong>Danger!</strong> ${error}
                        </div>
                    </c:when>

                </c:choose>
                <div class="row">


                    <c:forEach items="${product_list}" var="p">
                        <div class="col-lg-4 col-md-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${ p.getImgs().get(0).getImgURL()}">

                                    <div class="label new">New</div>
                                    <ul class="product__hover">
                                        <li><a href="${ p.getImgs().get(0).getImgURL()}" class="image-popup">
                                                <span class="arrow_expand"></span></a></li>
                                        <li><a href="#"><span class="icon_bag_alt"></span></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="product?ac=doshowdetail&pid=${p.getpID()}">${p.getpName()}</a></h6>
                                    <div class="rating">
                                        <c:forEach begin="1" end="${product_infor.getpRate_Count()}" var="rt">
                                            <i class="fa ${product_infor.getpRate_Count()>=rt?"fa-star":"fa-star-o"}"></i>
                                        </c:forEach>
                                    </div>
                                    <div class="product__price">$ <fmt:formatNumber value="${p.getpPrice()}"/></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="col-lg-12 text-center">
                        <div class="pagination__option">
                            <c:choose>
                                <c:when test="${current !=null || page !=null}">
                                    <c:choose>
                                        <c:when test="${cate_search !=null}">
                                            <c:forEach var="x" begin="1" end="${page}">
                                                <a class="${current == x ?"active":""}" href="product?ac=dosearch&index=${x}&cate=${cate_search}${start !=null?"&start="+start+"&end="+end:""}" >${x}</a>
                                            </c:forEach>
                                            <a href="product?ac=dosearch&index=${current+1}&cate=${cate}"><i class="fa fa-angle-right"></i></a>
                                            </c:when>
                                            <c:when test="${s_search !=null}">
                                                <c:forEach var="x" begin="1" end="${page}">
                                                <a class="${current == x ?"active":""}" href="product?ac=dosearch&index=${x}&s=${searchtext}${start!=null?"&start="+start_search+"&end="+end_search:""}" >${x}</a>
                                            </c:forEach>
                                            <a href="product?ac=dosearch&index=${current+1}&s=${s}"><i class="fa fa-angle-right"></i></a>
                                            </c:when>
                                            <c:when test="${gender_search !=null}">
                                                <c:forEach var="x" begin="1" end="${page}">
                                                <a class="${current == x ?"active":""}" href="product?ac=dosearch&index=${x}&gender=${gender_search}" >${x}</a>
                                            </c:forEach>
                                            <a href="product?ac=dosearch&index=${current+1}&s=${s}"><i class="fa fa-angle-right"></i></a>
                                            </c:when>
                                            <c:when test="${brand_search !=null}">
                                                <c:forEach var="x" begin="1" end="${page}">
                                                <a class="${current == x ?"active":""}" href="product?ac=dosearch&index=${x}&brand=${brand_search} >${x}</a>
                                                </c:forEach>
                                                <a href="product?ac=dosearch&index=${current+1}&s=${s}"><i class="fa fa-angle-right"></i></a>
                                            </c:when>
                                            <c:when test="${start_search!=null}">
                                                <c:forEach var="x" begin="1" end="${page}">
                                                <a class="${current == x ?"active":""}" href="product?ac=dosearch&index=${x}&start=${start_search}&end=${end_search} >${x}</a>
                                                </c:forEach>
                                                <a href="product?ac=dosearch&index=${current+1}&s=${s}"><i class="fa fa-angle-right"></i></a>
                                            </c:when>

                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="x" begin="1" end="${endpage}">
                                        <a class="${tag == x ?"active":""}" href="product?ac=doshow&index=${x}" >${x}</a>
                                    </c:forEach>
                                    <a href="product?ac=doshow&index=${tag+1}"><i class="fa fa-angle-right"></i></a>
                                    </c:otherwise>
                                </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->


<jsp:include page="inc/footer.jsp" />
