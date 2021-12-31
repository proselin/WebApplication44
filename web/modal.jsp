<%-- 
    Document   : modal
    Created on : Dec 18, 2021, 3:04:12 PM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="inc/header.jsp"></jsp:include>
    <div class="container">



    <script>
        $(document).ready(function () {
            $("#myBtn").click(function () {
                $("#myModal").modal();
            });
        });
    </script>
<jsp:include page="inc/footer.jsp"></jsp:include>
