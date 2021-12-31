<%-- 
    Document   : newjsp
    Created on : Dec 16, 2021, 4:47:05 PM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="inc/header.jsp"></jsp:include>
    <style >
        .coupon_Container{
            border: solid black 0.12px;
            border-radius: 25px;
            margin-top: 20px;
            overflow: hidden;
            box-shadow:  1px 4px 10px #888888
        }
        .image_coupon{
            background-color:#2FDD92;
            height: 100%;
            border-radius: 25px;
            width: 75%
        }
        .name{
            font-size: 20px;
            margin-top: 10px

        }
        .button_Container .mid_coupon{
            margin: 20px 20px 20px
        }
        .btn {
            width: 100%;
            height: 100%;
        }
    </style>
    <div class="container">

        <div class="coupon_Container">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon">
                    <div class="row">
                        <div class="col-md-12">
                            invalid
                        </div>
                        <div class="col-md-12 name">
                            vulcal
                        </div>
                        <div class="col-md-12">
                            <p>$200</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                    <p>
                        200000
                    </p>

                </div>
                <div class='col-md-2 button_Container'>
                    <button type="submit" class="btn btn-danger " value="" >Submot</button>
                </div>
            </div>
        </div>'
    </div>
<jsp:include page="inc/footer.jsp"></jsp:include>
