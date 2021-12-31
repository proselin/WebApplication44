<%-- 
    Document   : index
    Created on : Oct 29, 2021, 2:45:09 AM
    Author     : quoch
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page buffer="16kb" %>
<jsp:include page="inc/header.jsp"/>

<!-- Categories Section Begin -->
<section class="categories">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 p-0">
                <div class="banner__slider owl-carousel">
                    <div class="banner__item">
                        <div class="banner__text">
                            <div class="categories__item categories__large__item set-bg"
                                 data-setbg="img/categories/category-1.jpg">
                                <div class="categories__text">
                                    <h1>Women?s perfume</h1>
                                    <p>Sitamet, consectetur adipiscing elit, sed do eiusmod tempor incidid-unt
                                        labore
                                        edolore magna aliquapendisse ultrices gravida.</p>
                                    <a href="#">Shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="banner_item">
                        <a href="#">
                            <div class="categories__item categories__large__item set-bg"
                                 data-setbg="img/banner/banner-4.jpg">
                            </div>
                        </a>
                    </div>
                    <div class="banner_item">
                        <a href="#">
                            <div class="categories__item categories__large__item set-bg"
                                 data-setbg="img/banner/banner-6.jpg">
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 p-0">
                        <div class="categories__item set-bg" style="background-color: rgb(181, 246, 225);">
                            <div class="categories__text">
                                <h4>Men's perfume</h4>
                                <p>159 items</p>
                                <a href="#">Shop now</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12 col-md-12 col-sm-12 p-0">
                        <div class="categories__item set-bg" style="background-color:rgb(255, 221, 209);">
                            <div class="categories__text">
                                <h4>Voucher</h4>
                                <p>10 items</p>
                                <a href="#">claim now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Product Section Begin -->
<c:if test="${empty requestScope['listProduct']}">
    <jsp:forward page="home"/>
</c:if>

<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4">
                <div class="section-title">
                    <h4 style="margin-left: 20px;">New product</h4>
                </div>
            </div>
            <div class="col-lg-8 col-md-8">
                <ul class="filter__controls">
                    <li class="active" data-filter="*">All</li>
                    <li data-filter=".Women">Women</li>
                    <li data-filter=".Men">Men</li>
                    <li data-filter=".Unisex">Unisex</li>
                    <li><a href="product?ac=doshow"> More >></a></li>
                </ul>
            </div>
        </div>

        <div class="row property__gallery">
            <c:forEach var="x" items="${requestScope['listProduct']}">
                <div class="col-lg-3 col-md-4 col-sm-6 mix ${x.getpGender()}  ">
                    <div class="product__item">
                        <div class="product__item__pic set-bg " data-setbg="${x.getImgs().get(0).getImgURL()}">
                            <div class="label new">New</div>
                            <ul class="product__hover">
                                <li><a href="${x.getImgs().get(0).getImgURL()}" class="image-popup"><span
                                            class="arrow_expand"></span></a></li>

                                <li><a href="cart?ac=doincr&id=${x.getpID()}"><span class="icon_bag_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">  
                            <a href="product?ac=doshowdetail&pid=${x.getpID()}">${x.getpName()}</a>
                            <div class="product__price">$ ${x.getpPrice()}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Product Section End -->

<!-- Banner Section Begin 
<section class="banner set-bg" data-setbg="img/banner/banner-1.jpg">
    <div class="container">
        <div class="row">
            <div class="col-xl-7 col-lg-8 m-auto">
                <div class="banner__slider owl-carousel">
                    <div class="banner__item" style="margin-top: 30px;">
                        <div class="banner__text">
                            <span>The Frank Collection</span>
                            <h1>The Strong men</h1>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                    <div class="banner__item" style="margin-top: 30px;">
                        <div class="banner__text">
                            <span>The Chloe Collection</span>
                            <h1>The Summer Collection</h1>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                    <div class="banner__item" style="margin-top: 30px;">
                        <div class="banner__text">
                            <span>The Lumina Collection</span>
                            <h1>The Lover Stacking</h1>
                            <a href="#">Shop now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
-->
<!-- Banner Section End -->

<!-- Trend Section Begin 
<section class="trend spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="trend__content">
                    <div class="section-title">
                        <h4>Hot Trend</h4>
                    </div>
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p1.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Chain bucket bag</h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p2.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Pendant earrings</h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p3.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Cotton T-Shirt</h6>
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
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="trend__content">
                    <div class="section-title">
                        <h4>Best seller</h4>
                    </div>
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p4.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Cotton T-Shirt</h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p5.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Zip-pockets pebbled tote <br />briefcase</h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p6.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Round leather bag</h6>
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
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="trend__content">
                    <div class="section-title">
                        <h4>Best rate</h4>
                    </div>
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p7.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6><a href="product-details.html">COCO canel</a></h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p8.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6><a href="#">Metallic earrings</a></h6>
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
                    <div class="trend__item">
                        <div class="trend__item__pic">
                            <img src="img/product/p8.jpg" style="max-height: 90px;max-width: 90px;" alt="">
                        </div>
                        <div class="trend__item__text">
                            <h6>Flap cross-body bag</h6>
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
    </div>
</section>
-->
<!-- Trend Section End -->

<!-- Instagram Begin 
<div class="instagram">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-1.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-2.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-3.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-4.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-5.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-4 p-0">
                <div class="instagram__item set-bg" data-setbg="img/instagram/insta-6.jpg">
                    <div class="instagram__text">
                        <i class="fa fa-instagram"></i>
                        <a href="#">@ ashion_shop</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
-->
<!-- Instagram End -->

<!-- Discount Section Begin -->
<section class="discount">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 p-0">
                <div class="discount__pic">
                    <img src="img/banner/banner-7.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-6 p-0">
                <div class="discount__text">
                    <div class="discount__text__title">
                        <span>Discount</span>
                        <h2>Winter 2021</h2>
                        <h5><span>Free ship</span> ALL ORDER</h5>
                    </div>
                    <div class="discount__countdown" id="countdown-time">
                        <div class="countdown__item">
                            <span>22</span>
                            <p>Days</p>
                        </div>
                        <div class="countdown__item">
                            <span>18</span>
                            <p>Hour</p>
                        </div>
                        <div class="countdown__item">
                            <span>46</span>
                            <p>Min</p>
                        </div>
                        <div class="countdown__item">
                            <span>05</span>
                            <p>Sec</p>
                        </div>
                    </div>
                    <a href="#">Shop now</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Discount Section End -->

<!-- Services Section Begin -->
<section class="services spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="services__item">
                    <i class="fa fa-car"></i>
                    <h6>Free Shipping</h6>
                    <p>For all oder over $99</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="services__item">
                    <i class="fa fa-money"></i>
                    <h6>Money Back Guarantee</h6>
                    <p>If good have Problems</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="services__item">
                    <i class="fa fa-support"></i>
                    <h6>Online Support 24/7</h6>
                    <p>Dedicated support</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="services__item">
                    <i class="fa fa-headphones"></i>
                    <h6>Payment Secure</h6>
                    <p>100% secure payment</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Services Section End -->


<jsp:include page = "inc/footer.jsp" />
<script>
    var container = document.getElementById('container');
    var slider = document.getElementById('slider');
    var slides = document.getElementsByClassName('slide').length;
    var buttons = document.getElementsByClassName('btn');


    var currentPosition = 0;
    var currentMargin = 0;
    var slidesPerPage = 0;
    var slidesCount = slides - slidesPerPage;
    var containerWidth = container.offsetWidth;
    var prevKeyActive = false;
    var nextKeyActive = true;

    window.addEventListener("resize", checkWidth);

    function checkWidth() {
        containerWidth = container.offsetWidth;
        setParams(containerWidth);
    }

    function setParams(w) {
        if (w < 551) {
            slidesPerPage = 1;
        } else {
            if (w < 901) {
                slidesPerPage = 2;
            } else {
                if (w < 1101) {
                    slidesPerPage = 3;
                } else {
                    slidesPerPage = 4;
                }
            }
        }
        slidesCount = slides - slidesPerPage;
        if (currentPosition > slidesCount) {
            currentPosition -= slidesPerPage;
        }
        ;
        currentMargin = -currentPosition * (100 / slidesPerPage);
        slider.style.marginLeft = currentMargin + '%';
        if (currentPosition > 0) {
            buttons[0].classList.remove('inactive');
        }
        if (currentPosition < slidesCount) {
            buttons[1].classList.remove('inactive');
        }
        if (currentPosition >= slidesCount) {
            buttons[1].classList.add('inactive');
        }
    }

    setParams();

    function slideRight() {
        if (currentPosition !== 0) {
            slider.style.marginLeft = currentMargin + (100 / slidesPerPage) + '%';
            currentMargin += (100 / slidesPerPage);
            currentPosition--;
        }
        ;
        if (currentPosition === 0) {
            buttons[0].classList.add('inactive');
        }
        if (currentPosition < slidesCount) {
            buttons[1].classList.remove('inactive');
        }
    }


    function slideLeft() {
        if (currentPosition !== slidesCount) {
            slider.style.marginLeft = currentMargin - (100 / slidesPerPage) + '%';
            currentMargin -= (100 / slidesPerPage);
            currentPosition++;
        }

        if (currentPosition === slidesCount) {
            buttons[1].classList.add('inactive');
        }
        if (currentPosition > 0) {
            buttons[0].classList.remove('inactive');
        }
    }

</script>